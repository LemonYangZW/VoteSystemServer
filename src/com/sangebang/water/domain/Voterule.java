package com.sangebang.water.domain;

public class Voterule {
	private int id;
	private String tid;		//任务编号
	private String	province; //省限制
	private String	city;	//城市限制
	private int tmlimit; //时间限制 间隔时间
	private int freednum; //间隔时间释放数量
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getTmlimit() {
		return tmlimit;
	}
	public void setTmlimit(int tmlimit) {
		this.tmlimit = tmlimit;
	}
	public int getFreednum() {
		return freednum;
	}
	public void setFreednum(int freednum) {
		this.freednum = freednum;
	}
	
	
}
