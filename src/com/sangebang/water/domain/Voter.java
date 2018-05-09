package com.sangebang.water.domain;

import java.sql.Timestamp;

/**
 * @author Administrator
 *
 *投票者
 */
public class Voter {
	private int id;
	private String tid; // 任务编号
	private String wxname; // 微信openid
	private String province; // 省
	private String city; // 城市
	private Timestamp tm; // 接单时间
	private String path; // 图片地址
	private String status; // 审核状态
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
	public String getWxname() {
		return wxname;
	}
	public void setWxname(String wxname) {
		this.wxname = wxname;
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
	public Timestamp getTm() {
		return tm;
	}
	public void setTm(Timestamp tm) {
		this.tm = tm;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
