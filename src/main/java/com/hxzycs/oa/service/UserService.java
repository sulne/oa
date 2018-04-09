package com.hxzycs.oa.service;

import java.util.List;

import com.hxzycs.oa.entity.User;
import com.hxzycs.oa.pojo.Page;

public interface UserService {
	// �½��û�
	void create(User user);

	// �޸��û�
	void update(User user);

	// ɾ���û�
	void delete(Long userId);

	// ��ȡ�û�
	User find(Long userId);

	// ��ȡ�û��б�
	List<User> findList(Page page);

	// �����û��������û�
	User findByUsername(String username);
	
	// ������������û�
	User findByEmail(String email);
	
	// ��ȡ���û���
	Long findAllCount();
}
