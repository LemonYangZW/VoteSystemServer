package com.sangebang.water.domain;

import java.sql.Timestamp;

public class User {
	private int id;	
	private String tid; 			//������
	private String tname;		//��������
	private String tcontent;	//��������
	private int tnumber;			//��������
	private String name;			//����������
	private String phone;		//�����˵绰
	private String wxname;		//΢��
	private Timestamp tm;		//����ʱ��
	private String status;		//���״̬
	private double price;		//����
	private String url;				//ͶƱ����
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public int getTnumber() {
		return tnumber;
	}
	public void setTnumber(int tnumber) {
		this.tnumber = tnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWxname() {
		return wxname;
	}
	public void setWxname(String wxname) {
		this.wxname = wxname;
	}
	public String getStatus() {
		return status;
	}
	
	public Timestamp getTm() {
		return tm;
	}
	public void setTm(Timestamp tm) {
		this.tm = tm;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User(int id, String tid, String tname, String tcontent, int tnumber,
			String name, String phone, String wxname, Timestamp tm,
			String status, double price, String url) {
		super();
		this.id = id;
		this.tid = tid;
		this.tname = tname;
		this.tcontent = tcontent;
		this.tnumber = tnumber;
		this.name = name;
		this.phone = phone;
		this.wxname = wxname;
		this.tm = tm;
		this.status = status;
		this.price = price;
		this.url = url;
	}
	@Override
	//��дtoString ΪJSON��ʽ
	public String toString() {
		return "{\"id\":\"" + id + "\",\"tid\":\"" + tid + "\",\"tname\":\""
				+ tname + "\",\"tcontent\":\"" + tcontent + "\",\"tnumber\":\""
				+ tnumber + "\",\"name\":\"" + name + "\",\"phone\":\"" + phone
				+ "\",\"wxname\":\"" + wxname + "\",\"tm\":\"" + tm
				+ "\",\"status\":\"" + status + "\",\"price\":\"" + price
				+ "\",\"url\":\"" + url + "\"}";
	}
	
	
	
	
	
	
	
	
	
	
}
