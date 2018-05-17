package com.sangebang.water.util;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.WebUtils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

public class wxPay {
	
	public JSONObject createUnifiedOrder(HttpServletRequest request,
			HttpServletResponse response) {
		// �������շ��ض���
		JSONObject resultJson = new JSONObject();
		// ��������
		Criteria criteria = new Criteria();

		// ���ܲ���(���)
		String amount = request.getParameter("amount");
		// ���ܲ���(openid)
		String openid = request.getParameter("openid");
		// �ӿڵ����ܽ�λΪ�ֻ���һ��(���Խ��ĳ�1,��λΪ������0.01,�����Լ�ҵ�񳡾��ж���ת����float���ͻ���int����)
		// String amountFen =
		// Integer.valueOf((Integer.parseInt(amount)*100)).toString();
		// String amountFen =
		// Float.valueOf((Float.parseFloat(amount)*100)).toString();
		String amountFen = "1";
		// ����hashmap(�û����ǩ��)
		SortedMap<String, String> paraMap = new TreeMap<String, String>();
		// ����body���� (֧���ɹ���ʾ��΢��֧�� ��Ʒ������)
		String body = "����������";
		// ��������ַ���
		String nonceStr = GetUUID.getUUID();
		// �����̻�������
		String outTradeNo = GetUUID.getUUID();

		// �����������(С����ID)
		paraMap.put("appid", "wx910bf7bf9148bb9e");
		// �����������(�̻���)
		paraMap.put("mch_id", "10018405");
		// �����������(����ַ���)
		paraMap.put("nonce_str", nonceStr);
		// �����������(��Ʒ����)
		paraMap.put("body", body);
		// �����������(�̻�������)
		paraMap.put("out_trade_no", outTradeNo);
		// �����������(�ܽ��)
		paraMap.put("total_fee", amountFen);
		// �����������(�ն�IP)
		paraMap.put("spbill_create_ip",
				WebUtils.getIpAddress(request, response));
		// �����������(֪ͨ��ַ)
		paraMap.put("notify_url", WebUtils.getBasePath()
				+ "wechat/wechatAppletGolf/payCallback");
		// �����������(��������)
		paraMap.put("trade_type", "JSAPI");
		// �����������(openid)(�ڽӿ��ĵ��� �ò��� �Ƿ������ ����һ��Ҫע�� ��������������ó�'JSAPI'����봫��openid)
		paraMap.put("openid", openid);
		// �����߼�������������ֶ����� ASCII ���С���������ֵ���
		String stringA = formatUrlMap(paraMap, false, false);
		// �ڶ�������stringA���ƴ����key�õ�stringSignTemp�ַ���������stringSignTemp����MD5���㣬�ٽ��õ����ַ��������ַ�ת��Ϊ��д���õ�signֵsignValue��(ǩ��)
		String sign = MD5Util.MD5(stringA + "&key=" + KEY).toUpperCase();
		// ������ ��дXML��ʽ
		StringBuffer paramBuffer = new StringBuffer();
		paramBuffer.append("<xml>");
		paramBuffer.append("<appid>" + APPLYID + "</appid>");
		paramBuffer.append("<mch_id>" + MCHID + "</mch_id>");
		paramBuffer.append("<nonce_str>" + paraMap.get("nonce_str")
				+ "</nonce_str>");
		paramBuffer.append("<sign>" + sign + "</sign>");
		paramBuffer.append("<body>" + body + "</body>");
		paramBuffer.append("<out_trade_no>" + paraMap.get("out_trade_no")
				+ "</out_trade_no>");
		paramBuffer.append("<total_fee>" + paraMap.get("total_fee")
				+ "</total_fee>");
		paramBuffer.append("<spbill_create_ip>"
				+ paraMap.get("spbill_create_ip") + "</spbill_create_ip>");
		paramBuffer.append("<notify_url>" + paraMap.get("notify_url")
				+ "</notify_url>");
		paramBuffer.append("<trade_type>" + paraMap.get("trade_type")
				+ "</trade_type>");
		paramBuffer.append("<openid>" + paraMap.get("openid") + "</openid>");
		paramBuffer.append("</xml>");

		try {
			// ��������(POST)(������ݰ�ID)(���и�ע��ĵط� �����ת���ISO8859-1��������body����UTF8����
			// ������ĳ�UTF8����Ҳһ������ʹ �����޸ĳ�ISO8859-1)
			Map<String, String> map = doXMLParse(getRemotePortData(URL,
					new String(paramBuffer.toString().getBytes(), "ISO8859-1")));
			// Ӧ�ô��� ֧��������
			if (map != null) {
				// ���
				criteria.clear();
				// ����openId����
				criteria.put("openId", openid);
				// ��ȡ����
				List<WechatAppletGolfPayInfo> payInfoList = appletGolfPayInfoMapper
						.selectByExample(criteria);
				// ������ڿ� ��֤���ǵ�һ��֧��
				if (CollectionUtils.isEmpty(payInfoList)) {
					// ����֧����Ϣ����
					WechatAppletGolfPayInfo appletGolfPayInfo = new WechatAppletGolfPayInfo();
					// ��������
					appletGolfPayInfo.setPayId(outTradeNo);
					// ����openid
					appletGolfPayInfo.setOpenId(openid);
					// ���ý��
					appletGolfPayInfo.setAmount(Long.valueOf(amount));
					// ����֧��״̬
					appletGolfPayInfo.setPayStatus("0");
					// ����Dao
					int sqlRow = appletGolfPayInfoMapper
							.insert(appletGolfPayInfo);
					// �ж�
					if (sqlRow == 1) {
						System.out.println("΢�� ͳһ�µ� �ӿڵ��óɹ� ��������֧����Ϣ�ɹ�");
						resultJson.put("prepayId", map.get("prepay_id"));
						resultJson.put("outTradeNo",
								paraMap.get("out_trade_no"));
						return resultJson;
					}
				} else {
					// �ж� �Ƿ����һ��
					if (payInfoList.size() == 1) {
						// ��ȡ ��Ҫ��������
						WechatAppletGolfPayInfo wechatAppletGolfPayInfo = payInfoList
								.get(0);
						// ���� ������ ���
						wechatAppletGolfPayInfo.setAmount(Long.valueOf(amount));
						// ����Dao
						int sqlRow = appletGolfPayInfoMapper
								.updateByPrimaryKey(wechatAppletGolfPayInfo);
						// �ж�
						if (sqlRow == 1) {
							System.out.println("΢�� ͳһ�µ� �ӿڵ��óɹ� �޸�֧����Ϣ�ɹ�");
							resultJson.put("prepayId", map.get("prepay_id"));
							resultJson.put("outTradeNo",
									paraMap.get("out_trade_no"));
							return resultJson;
						}
					}
				}
			}
			// �� ���ݰ�ID ����

			System.out.println(map);
		} catch (UnsupportedEncodingException e) {
			System.out.println("΢�� ͳһ�µ� �쳣��" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("΢�� ͳһ�µ� �쳣��" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("΢�� ͳһ�µ� ʧ��");
		return resultJson;
	}
}
