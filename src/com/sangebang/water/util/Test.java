package com.sangebang.water.util;

import java.util.List;

import com.sangebang.water.dao.UserDao;
import com.sangebang.water.dao.impl.UserDaoImpl;
import com.sangebang.water.domain.User;

public class Test {
	public static void main(String[] args) {
		UserDao userdao=new UserDaoImpl();
//		userdao.Delete(tid);
//		List<User> userlist = userdao.findAllByName("id","!=1");
		userdao.UpdateStatus("SGB2018050200001", "ÉóºËÍ¨¹ý");
	}
}	
