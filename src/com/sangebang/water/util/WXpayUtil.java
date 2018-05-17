package com.sangebang.water.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.NodeList;

public class WXpayUtil {

	// ��������ַ���
	public static String getNonce_str() {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 15; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	// mapתxml ����ǩ����Ϣ
	public static String map2Xml(Map<String, Object> map)
			throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		StringBuilder sb2 = new StringBuilder();
		sb2.append("<xml>");
		for (String key : map.keySet()) {
			sb.append(key);
			sb.append('=');
			sb.append(map.get(key));
			sb.append('&');
			// sb2�������������xml����
			sb2.append("<" + key + ">");
			// sb2.append("<![CDATA[" + map.get(key) + "]]>");
			sb2.append(map.get(key));
			sb2.append("</" + key + ">");
		}
		sb.append(System.getenv("signKey"));
		String sign = MD5.getMessageDigest(sb.toString())
				.toUpperCase();
		sb2.append("<sign>");
		sb2.append(sign);
		sb2.append("</sign>");
		sb2.append("</xml>");
		return sb2.toString();
	}

	// ����΢�ŷ���return_code SUCCESS��FILE
	// ����΢�ŷ���resultXml�ٴ�����ǩ��
	public static String getSign(Map<String, Object> map) {
		StringBuffer sb = new StringBuffer();
		for (String key : map.keySet()) {
			sb.append(key);
			sb.append('=');
			sb.append(map.get(key));
			sb.append('&');
		}
		sb.append(System.getenv("signKey"));
		System.out.println("�ڶ���ǩ������:" + sb);
		System.out.println("�ڶ���ǩ��SING:"
				+ MD5.getMessageDigest(sb.toString()).toUpperCase());
		return MD5.getMessageDigest(sb.toString()).toUpperCase();
	}

	// ����΢�ŷ���return_code SUCCESS��FILE
	public static String getReturnCode(String resultXml) {
		String nonceStr;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = dbf.newDocumentBuilder();
			InputStream inputStream = new ByteArrayInputStream(
					resultXml.getBytes());
			org.w3c.dom.Document doc = builder.parse(inputStream); //
			// ���濪ʼ��ȡ
			org.w3c.dom.Element root = doc.getDocumentElement(); // ��ȡ��Ԫ��
			NodeList nl = root.getElementsByTagName("return_code");
			org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
			org.w3c.dom.Node nd = el.getFirstChild();
			nonceStr = nd.getNodeValue();
			return nonceStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ����΢�ŷ���return_msg
	public static String getReturn_msg(String resultXml) {
		String nonceStr;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = dbf.newDocumentBuilder();
			InputStream inputStream = new ByteArrayInputStream(
					resultXml.getBytes());
			org.w3c.dom.Document doc = builder.parse(inputStream); //
			// ���濪ʼ��ȡ
			org.w3c.dom.Element root = doc.getDocumentElement(); // ��ȡ��Ԫ��
			NodeList nl = root.getElementsByTagName("return_msg");
			org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
			org.w3c.dom.Node nd = el.getFirstChild();
			nonceStr = nd.getNodeValue();
			return nonceStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ����΢�ŷ���appid
	public static String getAppId(String resultXml) {
		String nonceStr;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = dbf.newDocumentBuilder();
			InputStream inputStream = new ByteArrayInputStream(
					resultXml.getBytes());
			org.w3c.dom.Document doc = builder.parse(inputStream); //
			// ���濪ʼ��ȡ
			org.w3c.dom.Element root = doc.getDocumentElement(); // ��ȡ��Ԫ��
			NodeList nl = root.getElementsByTagName("appid");
			org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
			org.w3c.dom.Node nd = el.getFirstChild();
			nonceStr = nd.getNodeValue();
			return nonceStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ����΢�ŷ���mch_id
	public static String getMchId(String resultXml) {
		String nonceStr;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = dbf.newDocumentBuilder();
			InputStream inputStream = new ByteArrayInputStream(
					resultXml.getBytes());
			org.w3c.dom.Document doc = builder.parse(inputStream); //
			// ���濪ʼ��ȡ
			org.w3c.dom.Element root = doc.getDocumentElement(); // ��ȡ��Ԫ��
			NodeList nl = root.getElementsByTagName("mch_id");
			org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
			org.w3c.dom.Node nd = el.getFirstChild();
			nonceStr = nd.getNodeValue();
			return nonceStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ����΢�ŷ���nonce_str
	public static String getNonceStr(String resultXml) {
		String nonceStr;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = dbf.newDocumentBuilder();
			InputStream inputStream = new ByteArrayInputStream(
					resultXml.getBytes());
			org.w3c.dom.Document doc = builder.parse(inputStream); //
			// ���濪ʼ��ȡ
			org.w3c.dom.Element root = doc.getDocumentElement(); // ��ȡ��Ԫ��
			NodeList nl = root.getElementsByTagName("nonce_str");
			org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
			org.w3c.dom.Node nd = el.getFirstChild();
			nonceStr = nd.getNodeValue();
			return nonceStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ����΢�ŷ���prepay_id
	public static String getPrepayId(String resultXml) {
		String nonceStr;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = dbf.newDocumentBuilder();
			InputStream inputStream = new ByteArrayInputStream(
					resultXml.getBytes());
			org.w3c.dom.Document doc = builder.parse(inputStream); //
			// ���濪ʼ��ȡ
			org.w3c.dom.Element root = doc.getDocumentElement(); // ��ȡ��Ԫ��
			NodeList nl = root.getElementsByTagName("prepay_id");
			org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
			org.w3c.dom.Node nd = el.getFirstChild();
			nonceStr = nd.getNodeValue();
			return nonceStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
