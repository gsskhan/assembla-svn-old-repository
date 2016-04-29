package org.dms.web.bulkupload;

import org.apache.log4j.Logger;
import org.dms.web.dao.GenericDao;
import org.dms.web.entity.User;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UploadUsers {
	
private static Logger log = Logger.getLogger(UploadUsers.class);
	
	private static AbstractApplicationContext ctx = null;
	
	public static void main(String[] args) {
		log.info("starting to upload users into system ...");
		ctx = new ClassPathXmlApplicationContext("/spring/applicationContext-dbaccess.xml"
												,"/spring/applicationContext-aop.xml");
		GenericDao genericDao = ctx.getBean(GenericDao.class);
		log.info("initialized spring successfully ...");
		
		User tmpUser = new User("gs2k", "password", "Ramgarh cantt, India", "gs2k@dms.org", "ADMINISTRATOR");
		genericDao.saveEntity(tmpUser);
		log.info("added - " + tmpUser);
		tmpUser = new User("BheshanBedi", "bb1298", "Delhi, India",	"bheshan@dms.org", "TEACHER");
		genericDao.saveEntity(tmpUser);
		log.info("added - " + tmpUser);
		tmpUser = new User("AmitShah", "as1298", "Jaipur, India", "amit.shah@dms.org", "PRINCIPAL");
		genericDao.saveEntity(tmpUser);
		log.info("added - " + tmpUser);
		tmpUser = new User("RahulKumar", "rk1298", "Kolkata, India", "rahul.kr@dms.org", "STUDENT");
		genericDao.saveEntity(tmpUser);
		log.info("added - " + tmpUser);

		log.info("completed ...");
		
	}
	

}
