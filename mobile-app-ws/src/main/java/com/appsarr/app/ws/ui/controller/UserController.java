package com.appsarr.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsarr.app.ws.exceptions.UserServiceException;
import com.appsarr.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsarr.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsarr.app.ws.ui.model.response.UserRest;
import com.appsarr.app.ws.userservice.UserService;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
	private Map<Integer, UserRest> usersMap = new HashMap<Integer, UserRest>();

	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUsers() {
		return "getusers was called";
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable Integer id) {
		//Test exception handler
		String lastName = null;
		int length = lastName.length();
		// 
		//test custome exception
		if(true) throw new UserServiceException("A user service exception is thrown");
		
		if(usersMap.containsKey(id)) {
			return new ResponseEntity<>(usersMap.get(id), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(path = "pag")
	public String getUsersPag(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", defaultValue = "50") Integer limit) {
		String msg = "getusersPag was called with ";
		if (page != null) {
			msg = msg + "pag : " + page + " and ";
		}
		msg = msg + "limit : " + limit;

		return msg;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUsers(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		return new ResponseEntity<UserRest>(userService.createUser(userDetails), HttpStatus.OK);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> updateUser(@PathVariable Integer id,
			@Valid @RequestBody UpdateUserDetailsRequestModel userUpdate) {
		if (usersMap.containsKey(id)) {
			UserRest user = usersMap.get(id);
			user.setFirstName(userUpdate.getFirstName());
			user.setLastName(userUpdate.getLastName());
			usersMap.put(id, user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@DeleteMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> deleteUser(@PathVariable Integer id) {
		if (usersMap.containsKey(id)) {
			UserRest user = usersMap.get(id);
			usersMap.remove(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
