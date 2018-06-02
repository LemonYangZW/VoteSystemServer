package com.sangebang.water.domain;

/**
 * Created by Hyman on 2017/2/27.
 */
public class Constant {

    public static final String DOMAIN = "localhost:8080";

    public static final String APP_ID = "wx910bf7bf9148bb9e";

    public static final String APP_SECRET = "726c3398b289f06567b0d74b88494d93";

    public static final String APP_KEY = "bai91420XI100gxh5818yZw07ll3lSX6";

    public static final String MCH_ID = "10018405";  //商户�?
//    public static final String URL_UNIFIED_ORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static final String URL_UNIFIED_ORDER = "https://api.mch.weixin.qq.com/sandboxnew/pay/unifiedorder";

    public static final String URL_NOTIFY = Constant.DOMAIN + "/wxpay/views/payInfo.jsp";

    public static final String TIME_FORMAT = "yyyyMMddHHmmss";

    public static final int TIME_EXPIRE = 2;  //单位是day

}
