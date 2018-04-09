package com.hxzycs.oa.pojo;

import java.util.List;

/**
 * Dao层CRUD接口父类
 */
public interface CrudDao<T> {

	/**
	 * 根据ID获取单条数据
	 */
	T get(Long id);

	/**
	 * 根据对象属性获取单条数据
	 */
	T get(T entity);

	/**
	 * 更新
	 */
	void update(T entity);

	/**
	 * 新建
	 */
	void create(T entity);

	/**
	 * 根据id删除
	 */
	void delete(Long id);

	/**
	 * 根据对象条件删除
	 */
	void delete(T entity);

	/**
	 * 批量删除
	 */
	void batchDelete(List<Long> ids);

	/**
	 * 获取数据列表
	 */
	List<T> findList(Page page);
	
	/**
	 * 获取数据数量
	 */
	Long findAllCount();
}
