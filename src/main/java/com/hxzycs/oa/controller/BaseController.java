package com.hxzycs.oa.controller;

import javax.annotation.Resource;

import com.hxzycs.oa.service.UserService;

public class BaseController {
	protected UserService userService;
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
