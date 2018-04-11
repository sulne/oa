package com.hxzycs.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.hxzycs.oa.entity.Role;
import com.hxzycs.oa.entity.User;
import com.hxzycs.oa.pojo.Page;
import com.hxzycs.oa.service.UserService;
import com.hxzycs.test.pojo.Junit4SpringTest;

public class UserController extends Junit4SpringTest{
	private UserService userService;
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void test() {
		Double d = 1.34;
		Double d1 = 1.34;
		Double d2 = d * d1;
		System.out.println(d2);
	}
	
	public void test1() {
		User user = new User();
		user.setId(10003L);
		user.setUsername("ÕÅÈý");
		user.setEmail("qq@1631.com");
		user.setPassword("123");
		user.setSalt("123");
		List<Role> roles = new ArrayList<>();
		roles.add(new Role());
		user.setRoles(roles);
		user.setLocked(false);
		userService.create(user);
		
	}

	@Override
	public void before() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void after() {
		// TODO Auto-generated method stub
		test1();
	}
}
