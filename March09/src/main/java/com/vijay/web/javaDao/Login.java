package main.java.com.vijay.web.javaDao;

import javax.validation.constraints.Size;


public class Login {
	
	@Size(min=1, message = "User Name cant be empty")
	String username;
	

	@Size(min=5, message = "Password must be at least 5 characters")
	String password;
	
	
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

}
