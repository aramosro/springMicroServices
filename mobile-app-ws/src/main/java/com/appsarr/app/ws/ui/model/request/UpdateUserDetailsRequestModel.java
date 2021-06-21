package com.appsarr.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserDetailsRequestModel {
	@NotNull(message = "firstname can not be missing")
	private String firstName;

	@NotNull(message = "lastname can not be missing")
	private String lastName;

	@Override
	public String toString() {
		return "UpdateUserDetailsRequestModel [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
