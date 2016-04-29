package org.dms.web.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author gsskhan Fields decorated with validator api from jboss hibernate.
 * 
 */

public class LoginUser {
	
	@NotEmpty(message="Username cannot be empty.")
	@NotNull(message="Username cannot be null.")
	@Size(min=4,max=20,message="Username must be b/w 4-20 chars.")
	private String username;
	
	@NotEmpty(message="Password cannot be empty.")
	@NotNull(message="Password cannot be null.")
	@Size(min=4,max=20,message="Password must be b/w 6-20 chars.")
	private String password;
	
	@NotEmpty(message="Role cannot be empty.")
	@NotNull(message="Role cannot be null.")
	private String role;	
	
	public LoginUser() {
		super();
	}
	
	public LoginUser(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "LoginUser [username=" + username + ", password=" + password
				+ ", role=" + role + "]";
	}	

}
