package com.sangebang.water.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redis.clients.jedis.Jedis;
import net.sf.json.JSONObject;

import com.sangebang.water.util.GetUUID;
import com.sangebang.water.util.JedisHelp;
import com.sangebang.water.util.Login;

public class OnLogin extends HttpServlet {

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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		Jedis jedis=JedisHelp.getJedis();
		
		String code = request.getParameter("code");
		String session_id = null;
		String userinfo = Login.sendGet(code);
		PrintWriter out = response.getWriter();
		JSONObject json = JSONObject.fromObject(userinfo);
		HttpSession session = request.getSession();
		String str = json.values().toString();
		session.setAttribute("openid",str.substring(str.indexOf(',')+1, str.indexOf(']')));
		System.out.println(str.substring(str.indexOf(',')+1, str.indexOf(']')));
		String openidStr = str
				.substring(str.indexOf(',') + 2, str.indexOf(']'));
		String sessionkeyStr = str.substring(str.indexOf('[') + 1,
				str.indexOf(','));
		session.setAttribute("openid", openidStr);

		if (jedis.exists(openidStr + sessionkeyStr)) {
			session_id = jedis.get(openidStr + sessionkeyStr);
			jedis.expire(openidStr + sessionkeyStr, 86400);
			System.out.println("已存在");
		} else {
			jedis.set(openidStr + sessionkeyStr, GetUUID.getUUID());
			session_id = jedis.get(openidStr + sessionkeyStr);
			System.out.println("新插入");
		}
		String data = "{\"openid\":\"" + openidStr + "\",\"session_id\":\"" + session_id + "\"}";
		out.write(data);
		out.flush();
		System.out.println(json);
		
		out.close();

	}

}
