package com.sangebang.water.domain;

public class Voterule {
	private int id;
	private String tid;		//������
	private String	province; //ʡ����
	private String	city;	//��������
	private int tmlimit; //ʱ������ ���ʱ��
	private int freednum; //���ʱ���ͷ�����
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
