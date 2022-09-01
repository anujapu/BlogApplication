package com.app.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {

	private long id;
	@NotEmpty
	@Size(min=4,message="name must be minimun of 4 chars")
	private String name;
	@Email(message="email not valid!!")
	private String email;
	@NotEmpty
	@Size(min=6,max=20,message="password must be min of 3 and max of 20 chars")
	private String password;
	@NotNull
	private String about;
	
	
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO( String name, String email, String password, String about) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}

	
	
}
