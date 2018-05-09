package com.sangebang.water.dao;

import java.util.List;

import com.sangebang.water.domain.User;

public interface UserDao {
	public List <User> findAll();
	
	public void Add(User user);
	
	public void Update(User user);
	
	public void Delete(String tid);
	
	public User findById (int id);
	
	public List <User> limit(int pagestart,int pagesize);
	
	public List <User> findAllByName(String Type,String SearchName);
	
	public List <User> limitSerch(int pagestart,int pagesize,String Type,String SearchName);
	
	public void UpdateStatus (String tid,String status);
}
