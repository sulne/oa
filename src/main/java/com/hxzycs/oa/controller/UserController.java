package com.hxzycs.oa.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxzycs.oa.entity.User;
import com.hxzycs.oa.pojo.Page;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController{

	@RequiresPermissions("user:add")
	@RequestMapping(value = "/add")
	@ResponseBody
	public String add(User user) {
		userService.create(user);
		return "";
	}
	
	@RequiresPermissions("user:view")
	@RequestMapping(value = "/view")
	@ResponseBody
	public User view(Long userId) {
		return userService.find(userId);
	}
	
	@RequiresPermissions("user:view")
	@RequestMapping(value = "/list")
	@ResponseBody
	public Page list(Page page) {
		List<User> users = userService.findList(page);
		page.setRows(users);
		page.setTotal(userService.findAllCount());
		return page;
	}
	
	@RequiresPermissions("user:del")
	@RequestMapping(value = "/del")
	@ResponseBody
	public String del(Long userId) {
		userService.delete(userId);
		return "";
	}
	
	@RequiresPermissions("user:edit")
	@RequestMapping(value = "/edit")
	@ResponseBody
	public String edit(User user) {
		userService.update(user);
		return "";
	}
}
