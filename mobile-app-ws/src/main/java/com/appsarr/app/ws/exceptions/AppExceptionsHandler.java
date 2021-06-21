package com.appsarr.app.ws.exceptions;



import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.appsarr.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object>handlerAnyException(Exception ex, WebRequest webRequest){
		ErrorMessage errormessage = new ErrorMessage();
		errormessage.setTimestamp(new Date());
		errormessage.setMessage((ex.getLocalizedMessage()!=null)?ex.getLocalizedMessage():ex.toString());
		return new ResponseEntity<>(errormessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(value= {NullPointerException.class, UserServiceException.class})
	public ResponseEntity<Object>handlerSpecificExceptions(Exception ex, WebRequest webRequest){
		ErrorMessage errormessage = new ErrorMessage();
		errormessage.setTimestamp(new Date());
		errormessage.setMessage((ex.getLocalizedMessage()!=null)?ex.getLocalizedMessage():ex.toString());
		return new ResponseEntity<>(errormessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
//	@ExceptionHandler(value= {UserServiceException.class})
//	public ResponseEntity<Object>handlerUserServiceException(UserServiceException ex, WebRequest webRequest){
//		ErrorMessage errormessage = new ErrorMessage();
//		errormessage.setTimestamp(new Date());
//		errormessage.setMessage((ex.getLocalizedMessage()!=null)?ex.getLocalizedMessage():ex.toString());
//		return new ResponseEntity<>(errormessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
//	}
}
