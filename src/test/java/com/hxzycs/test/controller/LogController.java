package com.hxzycs.test.controller;

import java.util.List;

import javax.annotation.Resource;

import com.hxzycs.oa.entity.Log;
import com.hxzycs.oa.pojo.Page;
import com.hxzycs.oa.service.LogService;
import com.hxzycs.test.pojo.Junit4SpringTest;

public class LogController extends Junit4SpringTest{

	@Resource(name="logService")
	private LogService logService;
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		List<Log> logs =  logService.findList(new Page());
		System.out.println(logService.findAllCount());
		System.out.println(logs);
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
