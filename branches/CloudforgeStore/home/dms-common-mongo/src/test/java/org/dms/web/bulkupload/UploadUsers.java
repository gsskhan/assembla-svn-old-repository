package org.dms.web.bulkupload;

import org.apache.log4j.Logger;
import org.dms.web.document.Users;
import org.dms.web.repository.UsersRepository;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

public class UploadUsers {
	
	private static Logger log = Logger.getLogger(UploadUsers.class);
	
	private static AbstractApplicationContext ctx = null;	

	public static void main(String[] args) {
		log.info("begin uploading users into system ...");
		ctx = new ClassPathXmlApplicationContext("/spring/applicationContext-mongo.xml"
												,"/spring/applicationContext-core.xml");
		MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
		UsersRepository usersRepository = ctx.getBean(UsersRepository.class);
		log.info("spring initialized sucessfully ...");
		
		Users tmpUser = new Users( "gs2k", "password", "Ramgarh cantt, India", "gs2k@dms.org", "ADMINISTRATOR");
		addOrUpdateUser(tmpUser,usersRepository, mongoTemplate);		
		tmpUser = new Users("BheshanBedi", "bb1298", "Delhi, India",	"bheshan@dms.org", "TEACHER");
		addOrUpdateUser(tmpUser,usersRepository, mongoTemplate);
		tmpUser = new Users("AmitShah", "as1298", "Jaipur, India", "amit.shah@dms.org", "PRINCIPAL");
		addOrUpdateUser(tmpUser,usersRepository, mongoTemplate);
		tmpUser = new Users( "RahulKumar", "rk1298", "Kolkata, India", "rahul.kr@dms.org", "STUDENT");
		addOrUpdateUser(tmpUser,usersRepository, mongoTemplate);
		
		log.info("Total users in system = "+usersRepository.count());
		log.info("completed ...");
	}
	
	private static void addOrUpdateUser(Users toSaveUserDetails, UsersRepository usersRepository, MongoTemplate mongoTemplate ){
		Update update = new Update();
		update.set("username", toSaveUserDetails.getUsername());
		update.set("password", toSaveUserDetails.getPassword());
		update.set("address", toSaveUserDetails.getAddress());
		update.set("email", toSaveUserDetails.getEmail());
		update.set("role", toSaveUserDetails.getRole());		
		WriteResult writeResult = mongoTemplate.upsert(Query.query(Criteria.where("username").is(toSaveUserDetails.getUsername())), update, Users.class);
		if (writeResult.isUpdateOfExisting()) {
			log.info("Record updated.");
		} else {
			log.info("New record inserted with id = "+ writeResult.getUpsertedId());
		}
		log.info(usersRepository.findOneByUsername(toSaveUserDetails.getUsername()));
	}

}
