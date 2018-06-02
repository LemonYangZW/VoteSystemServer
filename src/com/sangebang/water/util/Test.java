package com.sangebang.water.util;

import java.util.UUID;

import redis.clients.jedis.Jedis;

public class Test {
	public static void main(String[] args) {
         System.out.println(UUID.randomUUID().toString().replace("-",""));
         DBHelp.getConnection();
         Jedis jedis = JedisHelp.getJedis();
         jedis.set("key", "value");
         System.out.println(jedis.get("key"));
    }
}  