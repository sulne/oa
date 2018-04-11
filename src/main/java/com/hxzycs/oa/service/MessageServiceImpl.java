package com.hxzycs.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hxzycs.oa.entity.Message;
import com.hxzycs.oa.pojo.Page;
@Service("messageService")
public class MessageServiceImpl implements MessageService{

	@Override
	public Message get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message get(Message entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Message entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Message entity) {
		// TODO Auto-generated method stub
		System.out.println(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Message entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchDelete(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Message> findList(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findAllCount() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
