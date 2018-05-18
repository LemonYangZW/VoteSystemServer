package com.sangebang.water.util;

import redis.clients.jedis.Jedis;

  
/* 
 * 用户发起统一下单请求 
 * 作者：董志平 
 */  
public class Test {
	public static void main(String[] args) {
//		DBHelp.getConnection();
		Jedis jedis=JedisHelp.getJedis();
		jedis.ping();
		System.out.println(jedis.ping());
		DBHelp.getConnection();
	}
}  