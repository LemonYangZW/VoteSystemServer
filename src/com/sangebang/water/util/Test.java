package com.sangebang.water.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

import com.sangebang.water.dao.UserDao;
import com.sangebang.water.dao.impl.UserDaoImpl;
import com.sangebang.water.domain.User;

public class Test {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("193.112.185.121",6379);
        System.out.println("���ӳɹ�");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
}	
}