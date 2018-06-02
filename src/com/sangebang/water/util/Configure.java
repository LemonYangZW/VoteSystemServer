package com.sangebang.water.util;

public class Configure {
	private static String key = "bai91420XI100gxh5818yZw07ll3lSX6";

	//小程序ID	
	private static String appID = "wx910bf7bf9148bb9e";
	//商户号
	private static String mch_id = "10018405";
	//
	private static String secret = "726c3398b289f06567b0d74b88494d93";

	public static String getSecret() {
		return secret;
	}

	public static void setSecret(String secret) {
		Configure.secret = secret;
	}

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		Configure.key = key;
	}

	public static String getAppID() {
		return appID;
	}

	public static void setAppID(String appID) {
		Configure.appID = appID;
	}

	public static String getMch_id() {
		return mch_id;
	}

	public static void setMch_id(String mch_id) {
		Configure.mch_id = mch_id;
	}

}
