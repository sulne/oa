package com.hxzycs.oa.dao;

import java.util.List;

import com.hxzycs.oa.entity.Log;
import com.hxzycs.oa.pojo.Page;

public interface LogDao {
	// ���
	void create(Log log);

	// ɾ��
	void delete(Long id);

	// ��ȡ�б�
	List<Log> findList(Page page);

	// ��ȡ����
	Long findAllCount();
	
	// ����ɾ��
	void batchDelete(List<Long> ids);
	
	// ���
	void clear();
	
	// ����û�������־
	void deleteByUserId(Long userId);
}
