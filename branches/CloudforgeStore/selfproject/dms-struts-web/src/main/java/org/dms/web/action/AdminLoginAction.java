package org.dms.web.action;


import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.dms.web.bo.LoginService;
import org.springframework.beans.factory.annotation.Autowired;


/* 
 * Use when calling spring directly
 *  
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
*/
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 2597622183530792258L;

	private Logger log = Logger.getLogger(AdminLoginAction.class);
	
	private String username;
	private String password;
	private String accesstype;
	
	@Autowired
	private LoginService loginService;
	
	Map<String, Object> session;
	
	/* 
	 * To Call Spring directly.
	 *  
	private WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(
            ServletActionContext.getServletContext());
    */
	
	@Override
	public String execute() throws Exception {
		/* 1. Clear all messages.
		 * 2. Override the access type to only check for Admin user.
		 * 3. Check if is a user record exists in db matching details passed from the login form.
		 *    If match exists return success else return error. Add user to session object.
		 */
		clearErrorsAndMessages();
		if (loginService.verifyAdminUser(username, password, accesstype)) {
			session.put("uname", username);
			session.put("role", accesstype);
			this.addActionMessage("You have successfully logged in.");
			log.info("Login success for - " + username );
			return SUCCESS;
		} else {
			session.remove("uname");
			session.remove("role");
			this.addActionError("Login un-successful, Please recheck your username/password/access type.");
			log.info("Login un-successful for - [ "+username+" , "+ password + " , "+ accesstype+" ].");
			return ERROR;
		}
		
	}	
	
	/* 
	 * Not working for some reason, shall try to figure out later.
	 * 
	 */
	public void validate() {
		clearFieldErrors();
		
		if ( (username == null) && (username.length() == 0) ) {
			this.addFieldError("username", "Username is required.");
		}
		if ( (password == null) && (password.length() == 0) ) {
			this.addFieldError("password", "password is required.");
		}
		if ( (accesstype == null) && (accesstype.length() == 0) && (accesstype.equals("ADMINISTRATOR")) ) {
			this.addFieldError("accesstype", "accesstype is required and should be 'ADMINISTRATOR'.");
		}
	}
	
	// getter-setters
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;		
	}	
	public String getUsername() {
		return username;
	}
	public void setUsername(String loginname) {
		this.username = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccesstype() {
		return accesstype;
	}
	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	

}
