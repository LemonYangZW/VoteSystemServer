package com.sangebang.water.util;

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONArray;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class wxPay {
	public static Map<String, Object> getPayInformation(
		  ) throws AVException, UnsupportedEncodingException, DocumentException {
		    Map<String, Object> reqMap = new TreeMap<String, Object>(
		        new Comparator<String>() {
		          public int compare(String obj1, String obj2) {
		            // 升序排序
		            return obj1.compareTo(obj2);
		          }
		        });
		    if (AVUser.getCurrentUser() != null) {
		      String authDataJson = JSONArray.toJSONString(AVUser.getCurrentUser().get("authData"));
		      JSONObject jsonObject = JSON.parseObject(authDataJson);
		      jsonObject.get("lc_weapp");
		      JSONObject j2 = JSON.parseObject(jsonObject.get("lc_weapp").toString());
		      String openId = (String) j2.get("openid");
		 
		      AVQuery<Order> query = AVObject.getQuery(Order.class);
		      Order order = query.get(orderId);
		      reqMap.put("appid", System.getenv("appid"));
		      reqMap.put("mch_id", System.getenv("mch_id"));
		      reqMap.put("nonce_str", WXPayUtil.getNonce_str());
		      reqMap.put("body", new String(order.getDishesList().toString().getBytes("UTF-8")));
		      reqMap.put("openid", openId);
		      reqMap.put("out_trade_no", order.getObjectId());
		      reqMap.put("total_fee", 1); //订单总金额，单位为分
		      reqMap.put("spbill_create_ip", "192.168.0.1"); //用户端ip
		      reqMap.put("notify_url", System.getenv("notify_url")); //通知地址
		      reqMap.put("trade_type", System.getenv("trade_type")); //trade_type=JSAPI时（即公众号支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识
		      String reqStr = WXpayUtil.map2Xml(reqMap);
		      String resultXml = HttpRequest.sendPost(reqStr);
		      System.out.println("微信请求返回:" + resultXml);
		      //解析微信返回串 如果状态成功 则返回给前端
		      if (WXpayUtil.getReturnCode(resultXml) != null && WXpayUtil.getReturnCode(resultXml).equals("SUCCESS")) {
		        //成功
		        Map<String, Object> resultMap = new TreeMap<>(
		            new Comparator<String>() {
		              public int compare(String obj1, String obj2) {
		                // 升序排序
		                return obj1.compareTo(obj2);
		              }
		            });
		        resultMap.put("appId", System.getenv("appid"));
		        resultMap.put("nonceStr", WXpayUtil.getNonceStr(resultXml));//解析随机字符串
		        resultMap.put("package", "prepay_id=" + WXpayUtil.getPrepayId(resultXml));
		        resultMap.put("signType", "MD5");
		        resultMap.put("timeStamp", String.valueOf((System.currentTimeMillis() / 1000)));//时间戳
		        String paySign = WXpayUtil.getSign(resultMap);
		        resultMap.put("paySign", paySign);
		        return resultMap;
		      } else {
		        throw new AVException(999, "微信请求支付失败");
		      }
		    } else {
		      throw new AVException(98, "当前未登录用户");
		    }
		  }}
