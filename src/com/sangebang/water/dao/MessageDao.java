package com.sangebang.water.dao;

import java.util.List;

import com.sangebang.water.domain.Message;

public interface  MessageDao {
	public void add(Message message);
	public List<Message> findByName(String openid);
		
	
}
