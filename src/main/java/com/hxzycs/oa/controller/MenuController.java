package com.hxzycs.oa.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzycs.oa.pojo.BaseController;
import com.hxzycs.oa.service.MenuService;
@Controller
@RequestMapping(value="/menu")
public class MenuController extends BaseController{
	private MenuService menuService;
	
	@Resource(name="menuService")
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	

}
