package com.hxzycs.oa.service;

import java.util.List;

import com.hxzycs.oa.entity.User;
import com.hxzycs.oa.pojo.Page;

public interface UserService {
	// 新建用户
	void create(User user);

	// 修改用户
	void update(User user);

	// 删除用户
	void delete(Long userId);

	// 获取用户
	User find(Long userId);

	// 获取用户列表
	List<User> findList(Page page);

	// 根据用户名查找用户
	User findByUsername(String username);
	
	// 根据邮箱查找用户
	User findByEmail(String email);
	
	// 获取总用户数
	Long findAllCount();
}
