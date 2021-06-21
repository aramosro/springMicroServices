package com.appsarr.app.ws.ui.model.response;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ErrorMessage {

	private Date timestamp;
	private String message;
}
