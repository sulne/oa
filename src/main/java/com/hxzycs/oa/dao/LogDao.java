package com.hxzycs.oa.dao;

import java.util.List;

import com.hxzycs.oa.entity.Log;
import com.hxzycs.oa.pojo.Page;

public interface LogDao {
	// 添加
	void create(Log log);

	// 删除
	void delete(Long id);

	// 获取列表
	List<Log> findList(Page page);

	// 获取总数
	Long findAllCount();
	
	// 批量删除
	void batchDelete(List<Long> ids);
	
	// 清空
	void clear();
	
	// 清空用户操作日志
	void deleteByUserId(Long userId);
}
