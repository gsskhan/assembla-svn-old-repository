package org.dms.web.bulkupload;

import org.apache.log4j.Logger;
import org.dms.web.dao.GenericDao;
import org.dms.web.entity.Constants;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UploadConstants {
	
	private static Logger log = Logger.getLogger(UploadConstants.class);
	
	private static AbstractApplicationContext ctx = null;
	
	public static void main(String[] args) {
		log.info("starting to upload constants into system ...");
		ctx = new ClassPathXmlApplicationContext("/spring/applicationContext-dbaccess.xml"
												,"/spring/applicationContext-aop.xml");
		GenericDao genericDao = ctx.getBean(GenericDao.class);
		log.info("initialized spring successfully ...");
		
		Constants constant = new Constants("ACCESS TYPE", 10, "ADMINISTRATOR", 0);
		genericDao.saveEntity(constant);
		log.info("Saved - "+ constant);		
		constant = new Constants("ACCESS TYPE", 10, "PRINCIPAL", 0);
		genericDao.saveEntity(constant);
		log.info("Saved - "+ constant);		
		constant = new Constants("ACCESS TYPE", 10, "TEACHER", 0);
		genericDao.saveEntity(constant);
		log.info("Saved - "+ constant);		
		constant = new Constants("ACCESS TYPE", 10, "STUDENT", 0);
		genericDao.saveEntity(constant);
		log.info("Saved - "+ constant);
		
		constant = new Constants("PAPER STATUS", 11, "CREATED", 0);
		genericDao.saveEntity(constant);
		log.info("Saved - "+ constant);
		constant = new Constants("PAPER STATUS", 11, "PENDING AUTHORIZATION", 0);
		genericDao.saveEntity(constant);
		log.info("Saved - "+ constant);
		constant = new Constants("PAPER STATUS", 11, "PENDING APPROVAL", 0);
		genericDao.saveEntity(constant);
		log.info("Saved - "+ constant);
		constant = new Constants("PAPER STATUS", 11, "APPROVED", 0);
		genericDao.saveEntity(constant);
		log.info("Saved - "+ constant);
		constant = new Constants("PAPER STATUS", 11, "AUTHORIZED", 0);
		genericDao.saveEntity(constant);
		log.info("Saved - "+ constant);
		constant = new Constants("PAPER STATUS", 11, "REJECTED", 0);
		genericDao.saveEntity(constant);
		log.info("Saved - "+ constant);
		
		log.info("completed ...");
		
	}
	

}
