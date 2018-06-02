package com.sangebang.water.util;

import redis.clients.jedis.Jedis;

public class JedisHelp {
	public static Jedis getJedis(){
		Jedis jedis=new Jedis("118.24.41.227",8888);
		jedis.auth("Whbx!@#qwe");
		
		return jedis;
		
	}
}
