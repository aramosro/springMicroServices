package com.appsarr.app.ws.ui.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserRest {
	
	private String firstName;
	private String email;
	private String lastName;
	private Integer id;
	
	@Override
	public String toString() {
		return "UserRest [firstName=" + firstName + ", email=" + email + ", lastName=" + lastName + ", id=" + id + "]";
	}
	

	
}
