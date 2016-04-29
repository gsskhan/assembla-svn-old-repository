package org.dms.batch.tasklets;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dms.web.dao.GenericDao;
import org.dms.web.document.Users;
import org.dms.web.entity.User;
import org.dms.web.repository.UsersRepository;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class SyncUsers implements Tasklet{

	private Logger log = Logger.getLogger(this.getClass());
	
	private UsersRepository usersRepository;
	private GenericDao genericDao;
	
	
	@Override
	public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {		
		this.syncUsers();
		return RepeatStatus.FINISHED;
	}
	
	private void syncUsers(){
		log.info("starting to sync users records in mongo ...");
		for (User u : genericDao.getListWhereEq(User.class, null, 100000)) {
			Users mongoUser = usersRepository.findOneByUsername(u.getUsername());
			if(mongoUser == null){
				Users saveduser = usersRepository.save(new Users(u.getUsername(), u.getPassword(), u.getAddress(), u.getEmail(), u.getRole()));
				log.info("added new user to mongo with id "+ saveduser.getId());
			} else {
				if(	mongoUser.getUsername().equals(u.getUsername()) &&
					mongoUser.getPassword().equals(u.getPassword()) &&
					mongoUser.getAddress().equals(u.getAddress()) 	&&
					mongoUser.getEmail().equals(u.getEmail()) 		&&
					mongoUser.getRole().equals(u.getRole())) {
					log.info("username "+ u.getUsername()+ " records same in mongo as compared to mysql.");
				} else {
					mongoUser.setUsername(u.getUsername());
					mongoUser.setPassword(u.getPassword());
					mongoUser.setAddress(u.getAddress());
					mongoUser.setEmail(u.getEmail());
					mongoUser.setRole(u.getRole());
					usersRepository.save(mongoUser);
					log.info("username "+ u.getUsername()+ " records updated in mongo.");
				}
			}
		}
		log.info("starting to sync users records in mysql ...");
		for (Users u : usersRepository.findAll()) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("username", u.getUsername());
			User user = genericDao.getEntityWhereEq(User.class,paramMap);
			if (user == null) {
				long saveduserid = (long) genericDao.saveEntity(new User(u.getUsername(), u.getPassword(), u.getAddress(), u.getEmail(), u.getRole()));
				log.info("added new user to mysql with id "+ saveduserid);
			} else {
				if(	user.getUsername().equals(u.getUsername()) &&
					user.getPassword().equals(u.getPassword()) &&
					user.getAddress().equals(u.getAddress()) 	&&
					user.getEmail().equals(u.getEmail()) 		&&
					user.getRole().equals(u.getRole())) {
					log.info("username "+ u.getUsername()+ " records same in mysql as compared to mongo.");
				} else {
					user.setUsername(u.getUsername());
					user.setPassword(u.getPassword());
					user.setAddress(u.getAddress());
					user.setEmail(u.getEmail());
					user.setRole(u.getRole());
					genericDao.updateEntity(user);
					log.info("username "+ u.getUsername()+ " records updated in mysql.");
				}				
			}
		}
		
	}

	// getter-setter methods
	public UsersRepository getUsersRepository() {
		return usersRepository;
	}
	public void setUsersRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	public GenericDao getGenericDao() {
		return genericDao;
	}
	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
}
