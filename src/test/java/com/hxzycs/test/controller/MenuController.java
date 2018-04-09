package com.hxzycs.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzycs.oa.entity.Menu;
import com.hxzycs.oa.service.MenuService;
import com.hxzycs.test.pojo.Junit4SpringTest;
@Controller
@RequestMapping(value="/menu")
public class MenuController extends Junit4SpringTest{
	private MenuService menuService;
	
	@Resource(name="menuService")
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		menu.setId(1L);
		menu.setName("¹¦ÄÜ²Ëµ¥");
		menu.setParent(new Menu());
		menu.setParentIds("0,");
		menuService.update(menu);
	}

	@Override
	public void before() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void after() {
		// TODO Auto-generated method stub
		
	}
}
