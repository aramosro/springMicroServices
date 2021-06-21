package com.appsarr.app.ws.userservice;

import com.appsarr.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsarr.app.ws.ui.model.response.UserRest;


public interface UserService {

	UserRest createUser(UserDetailsRequestModel userDetails);
}
