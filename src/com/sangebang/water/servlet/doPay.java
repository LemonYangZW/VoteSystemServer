package com.sangebang.water.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.sangebang.water.domain.OrderInfo;
import com.sangebang.water.domain.OrderReturnInfo;
import com.sangebang.water.util.Configure;
import com.sangebang.water.util.GetUUID;
import com.sangebang.water.util.HttpRequest;
import com.sangebang.water.util.RandomStringGenerator;
import com.sangebang.water.util.Signature;
import com.thoughtworks.xstream.XStream;

public class doPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger L = Logger.getLogger(doPay.class);
   
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		try {
			String openid = request.getParameter("openid");
			OrderInfo order = new OrderInfo();
			order.setAppid(Configure.getAppID());
			order.setMch_id(Configure.getMch_id());
			order.setNonce_str(GetUUID.getUUID());
			order.setBody("Test");
			order.setOut_trade_no(RandomStringGenerator.getRandomStringByLength(32));
			order.setTotal_fee(1);
			order.setSpbill_create_ip("123.57.218.54"); //替换真实地址
			order.setNotify_url("https://www.333bang.com/wxpay/");
			order.setTrade_type("JSAPI");
			order.setOpenid(openid);
			order.setSign_type("MD5");
			//生成签名
			String sign = Signature.getSign(order);
			order.setSign(sign);
			
			
			String result = HttpRequest.sendPost("https://api.mch.weixin.qq.com/pay/unifiedorder", order);
			System.out.println(result);
			L.info("---------下单返回:"+result);
			XStream xStream = new XStream();
			xStream.alias("xml", OrderReturnInfo.class); 

			OrderReturnInfo returnInfo = (OrderReturnInfo)xStream.fromXML(result);
			JSONObject json = new JSONObject();
			json.put("prepay_id", returnInfo.getPrepay_id());
			response.getWriter().append(json.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
			L.error("-------", e);
		}
		
	
		
	}

}
