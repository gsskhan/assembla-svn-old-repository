package org.dms.web.bo;

import java.util.List;

import org.dms.web.document.Users;
import org.dms.web.exception.DmsException;

public interface UserService {
	
	String addNewUser(String username, String password, String address, String email, String role) throws DmsException;
	String deleteUserHavingId(String userId) throws DmsException;
	String deleteUserHavingName(String username) throws DmsException;
	String updateUser(String userId, String username, String password, String address, String email, String role) throws DmsException;
	Users findUserHavingId(String userId) throws DmsException;
	Users findUserHavingName(String username) throws DmsException;
	List<Users> findUsersWithNameLike(String uname) throws DmsException;
	List<String> allUsersNameList() throws DmsException;
	List<Users> allUsersList() throws DmsException;
	byte[] buildPdfListOfAllUsers();
}
