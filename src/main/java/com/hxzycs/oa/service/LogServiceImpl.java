package com.hxzycs.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxzycs.oa.dao.LogDao;
import com.hxzycs.oa.entity.Log;
import com.hxzycs.oa.pojo.Page;
@Service("logService")
public class LogServiceImpl implements LogService{

	private LogDao logDao;
	
	@Autowired
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	@Override
	public void create(Log log) {
		// TODO Auto-generated method stub
		logDao.create(log);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		logDao.delete(id);
	}

	@Override
	public List<Log> findList(Page page) {
		// TODO Auto-generated method stub
		return logDao.findList(page);
	}

	@Override
	public Long findAllCount() {
		// TODO Auto-generated method stub
		return logDao.findAllCount();
	}

	@Override
	public void batchDelete(List<Long> ids) {
		// TODO Auto-generated method stub
		logDao.batchDelete(ids);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		logDao.clear();
	}

	@Override
	public void deleteByUserId(Long userId) {
		// TODO Auto-generated method stub
		logDao.deleteByUserId(userId);
	}
}
