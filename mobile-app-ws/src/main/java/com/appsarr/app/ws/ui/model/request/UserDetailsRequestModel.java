package com.appsarr.app.ws.ui.model.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsRequestModel {
	@NotNull(message = "firstname can not be missing")
	private String firstName;
	
	@NotNull 
	@Email(message = "email bad format")
	private String email;
	
	@NotNull
	private String lastName;
	
	@NotNull 
	private Integer id;

	@Override
	public String toString() {
		return "UserDetailsRequestModel [firstName=" + firstName + ", email=" + email + ", lastName=" + lastName
				+ ", id=" + id + "]";
	}

}
