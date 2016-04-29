package org.dms.web.bo.impl;

import org.apache.log4j.Logger;
import org.dms.web.bo.LoginService;
import org.dms.web.core.SystemConstants;
import org.dms.web.document.Users;
import org.dms.web.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users findUser(String username) throws Exception {
		log.info("searching users records in db with username as "+ username);
		Users user = usersRepository.findOneByUsername(username);
		if (user ==null) {
			log.warn("No Users record found in db with username as "+ username);
		}
		return user;
	}

	@Override
	public boolean verifyAdminUser(String inputUsername, String inputPassword, String inputRole) throws Exception {
		Users actualUser = findUser(inputUsername);		
		if (actualUser != null && actualUser.getUsername().equals(inputUsername) 
				&& actualUser.getPassword().equals(inputPassword) 
				&& actualUser.getRole().equalsIgnoreCase(inputRole)
				&& actualUser.getRole().equalsIgnoreCase(SystemConstants.ROLE_ADMIN.getValue())) {			
			return true;
		}		
		return false;
	}

	

}
