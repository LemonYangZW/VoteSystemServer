package com.sangebang.water.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

import com.sangebang.water.util.GetUUID;
import com.sangebang.water.util.Login;

public class OnLogin extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		/* ������Ӧͷ����ajax������� */
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		Jedis jedis = new Jedis("193.112.185.121", 6379);
		String code = request.getParameter("code");
		String session_id = null;
		String userinfo = Login.sendGet(code);
		PrintWriter out = response.getWriter();
		JSONObject json = JSONObject.fromObject(userinfo);
		HttpSession session = request.getSession();
		String str = json.values().toString();
		String openidStr = str
				.substring(str.indexOf(',') + 2, str.indexOf(']'));
		String sessionkeyStr = str.substring(str.indexOf('[') + 1,
				str.indexOf(','));
		session.setAttribute("openid", openidStr);

		if (jedis.exists(openidStr + sessionkeyStr)) {
			session_id = jedis.get(openidStr + sessionkeyStr);
			jedis.expire(openidStr + sessionkeyStr, 86400);
			System.out.println("�Ѵ���");
		} else {
			jedis.set(openidStr + sessionkeyStr, GetUUID.getUUID());
			session_id = jedis.get(openidStr + sessionkeyStr);
			System.out.println("����redis");
		}
		String data = "{\"session_id\":\"" + session_id + "\"}";
		out.write(data);
		out.flush();
		out.close();

	}

}
