package com.sangebang.water.util;

import java.util.Random;

import redis.clients.jedis.Jedis;

  
/* 
 * 用户发起统一下单请求 
 * 作者：董志平 
 */  
public class Test {
	public static void main(String[] args) {
        // UUID.randomUUID().toString().replace("-","")
        Random random = new Random(System.currentTimeMillis());
        int value = random.nextInt();
        while (value < 0) {
            value = random.nextInt();
        }
        System.out.println(value);
    }
}  