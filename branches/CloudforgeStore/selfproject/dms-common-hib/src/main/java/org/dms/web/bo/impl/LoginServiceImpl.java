package org.dms.web.bo.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dms.web.bo.LoginService;
import org.dms.web.core.SystemConstants;
import org.dms.web.dao.GenericDao;
import org.dms.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService{
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private GenericDao genericDao;	

	@Override
	public User findUser(String username) throws Exception {
		Map<String, Object> hqlparams = new HashMap<String, Object>();
		hqlparams.put("uname", username);
		User user = genericDao.getEntity(" from User where username = :uname ", hqlparams);
		if (user == null) {
			log.warn("No record found in db for User name = "+ username);
		}
		return user;
	}
	
	@Override
	public boolean verifyAdminUser(String inputUsername, String inputPassword, String inputRole) throws Exception {
		User actualUser = findUser(inputUsername);		
		if (actualUser != null && actualUser.getUsername().equals(inputUsername) 
				&& actualUser.getPassword().equals(inputPassword) 
				&& actualUser.getRole().equalsIgnoreCase(inputRole)
				&& actualUser.getRole().equalsIgnoreCase(SystemConstants.ROLE_ADMIN.getValue())) {			
			return true;
		}		
		return false;
	}

	//getter-setter methods
	public GenericDao getGenericDao() {
		return genericDao;
	}
	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

}
