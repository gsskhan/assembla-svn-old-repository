package org.dms.web.bo;

import java.util.List;

import org.dms.web.entity.User;
import org.dms.web.exception.DmsException;

public interface UserService {
	
	String addNewUser(String username, String password, String address, String email, String role) throws DmsException;
	String deleteUserHavingId(String userId) throws DmsException;
	String deleteUserHavingName(String username) throws DmsException;
	String updateUser(long userid, String username, String password, String address, String email, String role) throws DmsException;
	User findUserHavingId(String userId) throws DmsException;
	User findUserHavingName(String username) throws DmsException;
	List<User> findUsersWithNameLike(String uname) throws DmsException;
	List<String> allUsersNameList() throws DmsException;
	List<User> allUsersList() throws DmsException;
	byte[] buildPdfListOfAllUsers();
}
