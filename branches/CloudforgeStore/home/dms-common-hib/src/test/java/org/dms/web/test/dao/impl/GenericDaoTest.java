package org.dms.web.test.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dms.web.dao.GenericDao;
import org.dms.web.entity.Constants;
import org.dms.web.mapper.ConstantsMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext-dbaccess.xml")
@TransactionConfiguration(transactionManager="dbTxManager", defaultRollback= true)
@Transactional
public class GenericDaoTest {
	
	private static Logger log = Logger.getLogger(GenericDaoTest.class);	
	private Map<String, Object> paramMap = new HashMap<String, Object>();
	
	@Autowired
	private GenericDao genericDao;
	
	@Test
	@Ignore
	public void testGenericHibDao(){	
		log.info("Starting test methods");
		
		try {									
			
			/* Hibernate Method Tests*/
			List<Constants> constantsList = genericDao.getList(" from Constants ", null, 100000);
			log.info("List of all constants -");
			for (Constants cons : constantsList) {
				log.info(cons);
			}
			
			paramMap.clear();
			paramMap.put("vconsId", new Integer(6));
			Constants cons = genericDao.getEntity("from Constants where constantId = :vconsId", paramMap);
			log.info("Constant value =" + cons);
			
			/* JDBC Template Test */			
			log.info("Find all constants records. [method 1]");
			List<Map<String, ?>> resultlist = genericDao.getList("select VARIABLE,VARIABLE_ID from CONSTANTS", null);
			log.info("Sql result data.");
			for (Map<String, ? > datamap : resultlist) {
				for ( String colname : datamap.keySet()) {
					log.info(colname+" : "+ datamap.get(colname));
				}
			}
			
			log.info("Find all constants records. [method 2]");
			List<Constants> allconstants = genericDao.getList("select * from CONSTANTS", null, new ConstantsMapper());
			for (Constants cnst : allconstants) {
				log.info(cnst);
			}			
			
			log.info("Find max constant_id.");
			Integer maxConstantId = genericDao.getObject("select max(constant_id) from CONSTANTS", null, java.lang.Integer.class );
			log.info("max constant_id = "+ maxConstantId);
			
			/* Named Parameter JDBC Test */
			log.info("Find constant_id with named param jdbc sql.");
			paramMap.clear();allconstants.clear();
			paramMap.put("cid", new Integer(1));
			allconstants = genericDao.getListWithNamedParamSql("select * from CONSTANTS where constant_id >= :cid" , paramMap, new ConstantsMapper());
			for (Constants cnst : allconstants) {
				log.info(cnst);
			}	
			
			log.info("Find count of constants where varaible = 'ACCESS TYPE' .");
			paramMap.clear();
			paramMap.put("var", new String("ACCESS TYPE"));
			Integer consid = genericDao.getObjectWithNamedParamSql("select count(*) from CONSTANTS where VARIABLE = :var ", paramMap, java.lang.Integer.class );
			log.info("count of constants = "+ consid);
			
			
		} catch (Exception e) {
			log.error("Error in GenericHibDaoTest.class :-", e);
			e.printStackTrace();
		}
		
	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}


}
