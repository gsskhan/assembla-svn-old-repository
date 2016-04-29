package org.dms.web.action;

import org.apache.log4j.Logger;
import org.dms.web.bo.UserService;
import org.dms.web.document.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class SearchUsers extends ActionSupport {

	private static final long serialVersionUID = 302335607412515537L;
	
	private Logger log = Logger.getLogger(SearchUsers.class);
	
	private InputStream fileInputStream;
	
	// properties mainly for search form	
	private String searchkeyword;
	private List<Users> usersList;

	@Autowired
	private UserService userService;
	
	private String message = "";
    
	// To search the users matching the input keyword.
	public String searchUserWithKeyword(){
		log.info("Starting to search user(s) with keyword = "+ searchkeyword);
		this.clearErrorsAndMessages();
		usersList = new ArrayList<Users>();
		usersList.clear();		
		try {		
			usersList = userService.findUsersWithNameLike(searchkeyword);
			message = usersList.size() + " users found .";	
			log.info(message);	
		} catch (Exception e) {
			message = "Error in finding users for keyword [" +searchkeyword+"]. "+ e.getMessage();
			this.addActionError(message);
			log.error(message, e);
		}	
		// reset the keyword
		searchkeyword = "";
		return SUCCESS;
	}
	
	public String getPdfReportForAllUsers(){
		byte[] bytebuf = userService.buildPdfListOfAllUsers();
		fileInputStream = new ByteArrayInputStream(bytebuf);
		log.info("created and set to stream a report(.pdf) of all users from db ...");
		return SUCCESS;
	}	
	
	// getter - setters
	public String getSearchkeyword() {
		return searchkeyword;
	}
	public void setSearchkeyword(String searchkeyword) {
		this.searchkeyword = searchkeyword;
	}
	public List<Users> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
	

}
