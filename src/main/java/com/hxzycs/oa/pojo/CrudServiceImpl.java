package com.hxzycs.oa.pojo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class CrudServiceImpl<D extends CrudDao<T>,T> implements CrudService<T>{

	protected D dao;
	@Autowired
	public void setDao(D dao) {
		this.dao = dao;
	}

	@Override
	public T get(Long id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public T get(T entity) {
		// TODO Auto-generated method stub
		return dao.get(entity);
	}

	@Override
	@Logging(type="修改")
	public void update(T entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	@Override
	@Logging(type="新建")
	public void create(T entity) {
		// TODO Auto-generated method stub
		dao.create(entity);
	}

	@Override
	@Logging(type="删除")
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	@Logging(type="删除")
	public void delete(T entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Override
	@Logging(type="批量删除")
	public void batchDelete(List<Long> ids) {
		// TODO Auto-generated method stub
		dao.batchDelete(ids);
	}

	@Override
	public List<T> findList(Page page) {
		// TODO Auto-generated method stub
		return dao.findList(page);
	}

	@Override
	public Long findAllCount() {
		// TODO Auto-generated method stub
		return dao.findAllCount();
	}
}
