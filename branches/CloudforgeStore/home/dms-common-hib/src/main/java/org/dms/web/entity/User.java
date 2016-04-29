package org.dms.web.entity;

public class User {
	
	private long userId;
	private String username;
	private String password;
	private String address;
	private String email;
	private String role;	
	
	public User(){
		super();
	}
	
	public User(String username, String password, String address, String email, String role) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.email = email;
		this.role = role;
	}	

	public User(long userId, String username, String password, String address,
			String email, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.address = address;
		this.email = email;
		this.role = role;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "[userId=" + userId + ", username=" + username
				+ ", password=" + password + ", address=" + address
				+ ", email=" + email + ", role=" + role + "]";
	}
	

}
