package com.hxzycs.oa.pojo;

import java.util.List;

/**
 * Dao��CRUD�ӿڸ���
 */
public interface CrudDao<T> {

	/**
	 * ����ID��ȡ��������
	 */
	T get(Long id);

	/**
	 * ���ݶ������Ի�ȡ��������
	 */
	T get(T entity);

	/**
	 * ����
	 */
	void update(T entity);

	/**
	 * �½�
	 */
	void create(T entity);

	/**
	 * ����idɾ��
	 */
	void delete(Long id);

	/**
	 * ���ݶ�������ɾ��
	 */
	void delete(T entity);

	/**
	 * ����ɾ��
	 */
	void batchDelete(List<Long> ids);

	/**
	 * ��ȡ�����б�
	 */
	List<T> findList(Page page);
	
	/**
	 * ��ȡ��������
	 */
	Long findAllCount();
}
