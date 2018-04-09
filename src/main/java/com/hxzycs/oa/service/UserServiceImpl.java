package com.hxzycs.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxzycs.oa.dao.UserDao;
import com.hxzycs.oa.entity.User;
import com.hxzycs.oa.pojo.Logging;
import com.hxzycs.oa.pojo.Page;
@Service("userService")
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	@Logging(description="添加用户",table="sys_user",type="添加")
	public void create(User user) {
		// TODO Auto-generated method stub
		userDao.create(user);
	}
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}
	@Override
	public void delete(Long userId) {
		// TODO Auto-generated method stub
		userDao.delete(userId);
	}
	@Override
	public User find(Long userId) {
		// TODO Auto-generated method stub
		return userDao.find(userId);
	}
	@Override
	public List<User> findList(Page page) {
		// TODO Auto-generated method stub
		return userDao.findList(page);
	}
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}
	@Override
	public Long findAllCount() {
		// TODO Auto-generated method stub
		return userDao.findAllCount();
	}
}
