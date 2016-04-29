package org.dms.web.bulkupload;

import org.apache.log4j.Logger;
import org.dms.web.document.Constants;
import org.dms.web.repository.ConstantsRepository;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

public class UploadConstants {

	
	private static Logger log = Logger.getLogger(UploadConstants.class);
	
	private static AbstractApplicationContext ctx = null;	
	
	public static void main(String[] args) {
		log.info("begin uploading constants into system ...");
		ctx = new ClassPathXmlApplicationContext("/spring/applicationContext-mongo.xml"
												,"/spring/applicationContext-core.xml");
		MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
		ConstantsRepository constantsRepository = ctx.getBean(ConstantsRepository.class);
		log.info("spring initialized sucessfully ...");
		
		Constants constant = new Constants("ACCESS TYPE", 10, "ADMINISTRATOR", 0);
		addOrUpdateConstants(constant, constantsRepository, mongoTemplate );
		constant = new Constants("ACCESS TYPE", 10, "PRINCIPAL", 0);
		addOrUpdateConstants(constant, constantsRepository, mongoTemplate );			
		constant = new Constants("ACCESS TYPE", 10, "TEACHER", 0);
		addOrUpdateConstants(constant, constantsRepository, mongoTemplate );			
		constant = new Constants("ACCESS TYPE", 10, "STUDENT", 0);
		addOrUpdateConstants(constant, constantsRepository, mongoTemplate );
		
		constant = new Constants("PAPER STATUS", 11, "CREATED", 0);
		addOrUpdateConstants(constant, constantsRepository, mongoTemplate );
		constant = new Constants("PAPER STATUS", 11, "PENDING AUTHORIZATION", 0);
		addOrUpdateConstants(constant, constantsRepository, mongoTemplate );
		constant = new Constants("PAPER STATUS", 11, "PENDING APPROVAL", 0);
		addOrUpdateConstants(constant, constantsRepository, mongoTemplate );
		constant = new Constants("PAPER STATUS", 11, "APPROVED", 0);
		addOrUpdateConstants(constant, constantsRepository, mongoTemplate );
		constant = new Constants("PAPER STATUS", 11, "AUTHORIZED", 0);
		addOrUpdateConstants(constant, constantsRepository, mongoTemplate );
		constant = new Constants("PAPER STATUS", 11, "REJECTED", 0);
		addOrUpdateConstants(constant, constantsRepository, mongoTemplate );
		
		log.info("Total constants in system = "+constantsRepository.count());
		log.info("completed ...");
	}
	
	private static void addOrUpdateConstants(Constants toBeSavedConstant, ConstantsRepository constantsRepository, MongoTemplate mongoTemplate){
		Update update = new Update();
		update.set("variablename", toBeSavedConstant.getVariableName());
		update.set("variableid", toBeSavedConstant.getVariableId());
		update.set("variablevalue", toBeSavedConstant.getVariableValue());
		update.set("parentvariableid", toBeSavedConstant.getParentVariableId());
		WriteResult writeResult = mongoTemplate.upsert(Query.query(
				Criteria.where("variablename").is(toBeSavedConstant.getVariableName())
						.and("variablevalue").is(toBeSavedConstant.getVariableValue())
				), update, Constants.class);
		if (writeResult.isUpdateOfExisting()) {
			log.info("Record updated.");
		} else {
			log.info("New record inserted with id = "+ writeResult.getUpsertedId());
		}
		log.info(constantsRepository.findOneByVariableNameAndVariableValue(toBeSavedConstant.getVariableName(), toBeSavedConstant.getVariableValue()));		
	}

}
