package com.jwt.react.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {
	
	    @NotBlank
	    @Size(min=3, max = 50)
	    private String firstname;
	    
	    @NotBlank
	    @Size(min=3, max = 50)
	    private String lastname;

	    @NotBlank
	    @Size(min=3, max = 50)
	    private String username;

	    @NotBlank
	    @Size(max = 50)
	    @Email
	    private String email;
	    
	    private List<String> role;
	    @NotBlank
	    @Size(min=6, max = 100)
	    private String password;
	    
	    public List<String> getRole() {
			return role;
		}

		public void setRole(List<String> role) {
			this.role = role;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
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
	    
}