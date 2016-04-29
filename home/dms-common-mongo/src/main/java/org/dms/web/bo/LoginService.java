package org.dms.web.bo;

import org.dms.web.document.Users;

public interface LoginService {	

	public Users findUser(String username) throws Exception;
	
	public boolean verifyAdminUser(String inputUsername, String inputPassword, String inputRole) throws Exception;

}
