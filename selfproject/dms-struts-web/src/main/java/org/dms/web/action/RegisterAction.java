package org.dms.web.action;

import java.util.List;



import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.dms.web.bo.ConstantsService;
import org.dms.web.bo.UserService;
import org.dms.web.document.Users;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = -6524688616443882468L;
	private Logger log = Logger.getLogger(RegisterAction.class);
	
	private String userId;
	private String username;
	private String password;
	private String address;
	private String email;
	private String accessType;
	private List<String> accessTypeList;
	private HttpServletRequest request;	
	
	@Autowired
	private ConstantsService constantsService;
	@Autowired
	private UserService userService;
	
	private String message = "";
	
	public String execute(){
		return getJSON();	
	}
	
	// Json call methods
	public String getJSON(){
		accessTypeList = constantsService.findAllValuesForVariable("ACCESS TYPE");		
		return SUCCESS;
    }
			
	// Method to add User
	public String addUser(){		
		this.clearErrorsAndMessages();		
		try {
			message = userService.addNewUser(username, password, address, email, accessType);
			this.addActionMessage(message);			
			clearForm();			
		} catch (Exception e) {
			message  = "Error in adding new user. Message - " + e.getMessage();
			this.addActionError(message);
			log.error(message, e);
			return ERROR;
		}
		return SUCCESS;	
	}
	
	// Method to delete user by getting userid from request object parameters.
	public String deleteUser(){
		this.clearErrorsAndMessages();		
		String userIdString = request.getParameter("userid");				
		try {		
			message = userService.deleteUserHavingId(userIdString);
			log.info(message);
			this.addActionMessage(message);		
		} catch (Exception e){			
			message = "Error in deleting user with id ["+userIdString+"]. Message - " +e.getMessage();
			this.addActionError(message);
			log.error(message, e);
			return ERROR;
		}	
		return SUCCESS;
	}
	
	// Method to set user record to httpRequest for editing later by editUser().
	public String userSetToHTTPRequest(){
			this.clearErrorsAndMessages();
			String userIdString = request.getParameter("userid");
			try {
				Users modUser = userService.findUserHavingId(userIdString);
				if (modUser == null) {
					this.addActionError("Sorry! Couldn't get user record to edit. Please try again.");
					return ERROR;
				} 
				request.setAttribute("moduser", modUser);
				this.addActionMessage("Please update records for "+ modUser.getUsername()+" and press 'Save'.");
				log.info("User record set to 'httpRequest' = "+ modUser);
			} catch (Exception e) {
				message = "Problem with processing user record for edit. "+ e.getMessage();
				this.addActionError(message);
				log.error(message, e);
				return ERROR;
			}		
			return SUCCESS;
	}
	
	// Method to update a User record and persist to db.
	public String editUser(){
		this.clearErrorsAndMessages();
		try {
			message = userService.updateUser(userId, username, password, address, email, accessType);
			this.addActionMessage(message);
			log.info(message);
		} catch (Exception e) {
			message = "Error in updating user . Message -"+ e.getMessage();
			this.addActionError(message);
			log.error(message, e);
			return ERROR;
		}		
		return SUCCESS;
		
	}
	
	public void validate() {
		super.validate();
		if (username == null || username.length() == 0) {
			log.info("Found 'username' to be null or empty, No addition of user done.");
			this.addActionError("Username was null or empty, Please provide a valid username.");
		}
		if (password == null || password.length() == 0) {
			log.info("Found 'password' to be null or empty, No addition of user done.");
			this.addActionError("Password was null or empty. Please provide a valid password.");
		}
		if (address == null || address.length() == 0) {
			log.info("Found 'address' to be null or empty, No addition of user done.");
			this.addActionError("Address was null or empty, Please provide a valid address.");
		}
		if (accessType == null || accessType.length() == 0) {
			log.info("Found 'accessType' to be null or empty, No addition of user done.");
			this.addActionError("Access Type was null or empty, Please select a valid Access Type.");
		} else if (accessType.equals("-1")){ // Value for headerKey for Access Type DropDown.
			log.info("Found 'accessType' to be invalid ie '-1' , No addition of user done.");
			this.addActionError("Access Type selected is invalid, Please select a valid Access Type.");
		}
	}
	
	private void clearForm(){
		this.setUsername("");
		this.setPassword("");
		this.setAddress("");
		this.setEmail("");
		this.setAccessType("-1"); // headerKey value of dropdown list.		
	}	
	
	// getter - setter methods
	@Override // For Editing and Deleting users
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}
	public String getUserId() {
		return userId; // Using only for edit method
	}
	public void setUserId(String userId) {
		this.userId = userId; // Using only for edit method
	}	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}	
	public List<String> getAccessTypeList() {
		return accessTypeList;
	}
	public void setAccessTypeList(List<String> accessTypeList) {
		this.accessTypeList = accessTypeList;
	}
	public ConstantsService getConstantsService() {
		return constantsService;
	}
	public void setConstantsService(ConstantsService constantsService) {
		this.constantsService = constantsService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}	
	
}
