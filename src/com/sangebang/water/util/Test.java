package com.sangebang.water.util;

import redis.clients.jedis.Jedis;

  
/* 
 * �û�����ͳһ�µ����� 
 * ���ߣ���־ƽ 
 */  
public class Test {
	public static void main(String[] args) {
//		DBHelp.getConnection();
		Jedis jedis=JedisHelp.getJedis();
		jedis.ping();
		System.out.println(jedis.ping());
		
	}
}  