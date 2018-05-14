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
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        
        
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key); 
            jedis.del(key);
            
	}
}	
}