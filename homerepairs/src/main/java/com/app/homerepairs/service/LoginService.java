package com.app.homerepairs.service;

import com.app.homerepairs.reponse.GeneralResponse;
import com.app.homerepairs.request.LoginRequest;

public interface LoginService
{
	public GeneralResponse checkLogin(LoginRequest loginRequest);
}
