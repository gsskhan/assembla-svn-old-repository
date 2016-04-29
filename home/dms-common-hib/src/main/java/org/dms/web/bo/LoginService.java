package org.dms.web.bo;

import org.dms.web.entity.User;


public interface LoginService {	

	public User findUser(String username) throws Exception;
	
	public boolean verifyAdminUser(String inputUsername, String inputPassword, String inputRole) throws Exception;

}
