package com.sangebang.water.domain;

import java.sql.Timestamp;

/**
 * @author Administrator
 *
 *ͶƱ��
 */
public class Voter {
	private int id;
	private String tid; // ������
	private String wxname; // ΢��openid
	private String province; // ʡ
	private String city; // ����
	private Timestamp tm; // �ӵ�ʱ��
	private String path; // ͼƬ��ַ
	private String status; // ���״̬
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
