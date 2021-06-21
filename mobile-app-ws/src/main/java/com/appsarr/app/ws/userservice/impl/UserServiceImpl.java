package com.appsarr.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.appsarr.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsarr.app.ws.ui.model.response.UserRest;
import com.appsarr.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{

	private Map<Integer, UserRest> usersMap = new HashMap<Integer, UserRest>();
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest userRest = new UserRest();
		userRest.setFirstName(userDetails.getFirstName());
		userRest.setLastName(userDetails.getLastName());
		userRest.setEmail(userDetails.getEmail());
		userRest.setId(userDetails.getId());
		usersMap.put(userDetails.getId(), userRest);
		return userRest;
	}

}
