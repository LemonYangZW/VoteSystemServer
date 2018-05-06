package com.sangebang.water.domain;

import java.sql.Timestamp;

public class Voter {
	private int id;	
	private String tid; 			//任务编号
	private String wxname;		//微信openid
	private Timestamp tm;		//接单时间
	private String path;				//图片地址
}
