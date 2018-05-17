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
		            // ��������
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
		      reqMap.put("total_fee", 1); //�����ܽ���λΪ��
		      reqMap.put("spbill_create_ip", "192.168.0.1"); //�û���ip
		      reqMap.put("notify_url", System.getenv("notify_url")); //֪ͨ��ַ
		      reqMap.put("trade_type", System.getenv("trade_type")); //trade_type=JSAPIʱ�������ں�֧�������˲����ش����˲���Ϊ΢���û����̻���Ӧappid�µ�Ψһ��ʶ
		      String reqStr = WXpayUtil.map2Xml(reqMap);
		      String resultXml = HttpRequest.sendPost(reqStr);
		      System.out.println("΢�����󷵻�:" + resultXml);
		      //����΢�ŷ��ش� ���״̬�ɹ� �򷵻ظ�ǰ��
		      if (WXpayUtil.getReturnCode(resultXml) != null && WXpayUtil.getReturnCode(resultXml).equals("SUCCESS")) {
		        //�ɹ�
		        Map<String, Object> resultMap = new TreeMap<>(
		            new Comparator<String>() {
		              public int compare(String obj1, String obj2) {
		                // ��������
		                return obj1.compareTo(obj2);
		              }
		            });
		        resultMap.put("appId", System.getenv("appid"));
		        resultMap.put("nonceStr", WXpayUtil.getNonceStr(resultXml));//��������ַ���
		        resultMap.put("package", "prepay_id=" + WXpayUtil.getPrepayId(resultXml));
		        resultMap.put("signType", "MD5");
		        resultMap.put("timeStamp", String.valueOf((System.currentTimeMillis() / 1000)));//ʱ���
		        String paySign = WXpayUtil.getSign(resultMap);
		        resultMap.put("paySign", paySign);
		        return resultMap;
		      } else {
		        throw new AVException(999, "΢������֧��ʧ��");
		      }
		    } else {
		      throw new AVException(98, "��ǰδ��¼�û�");
		    }
		  }}
