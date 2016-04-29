package org.dms.web.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="users")
public class Users {
	
	@Id
	private String id;
	
	@Field(value="username")
	@Indexed(name="usernameIdx",unique=true,dropDups=true)
	private String username;
	
	@Field(value="password")
	private String password;
	
	@Field(value="address")
	private String address;
	
	@Field(value="email")
	private String email;
	
	@Field(value="role")
	private String role;	
	
	public Users() {
		super();
	}

	public Users(String username, String password, String address,
			String email, String role) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.email = email;
		this.role = role;
	}	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "Users [id=" + id + ", username="
				+ username + ", password=" + password + ", address=" + address
				+ ", email=" + email + ", role=" + role + "]";
	}
		

}
