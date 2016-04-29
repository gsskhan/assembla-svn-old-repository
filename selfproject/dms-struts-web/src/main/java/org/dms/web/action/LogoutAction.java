package org.dms.web.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3697301253668547946L;

	private Logger log = Logger.getLogger(LogoutAction.class); 
	
    Map<String, Object> session;
	
	public void setSession(Map<String, Object>  session) {
		this.session = session;
	}
	
	public String execute(){
		String msg = "";
		if(session.containsKey("uname")){
			session.remove("uname");
			session.remove("role");
			msg = "You have successfully logged out.";
			this.addActionMessage(msg);
			log.info(msg);
			return SUCCESS;	
		} else {
			session.put("uname", null);
			msg= "Error in logout, no 'uname' variable found in session object.";
			this.addActionError(msg);
			log.warn(msg);
			return ERROR;
		}
		
	}

}
