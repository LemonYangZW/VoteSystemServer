package com.sangebang.water.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sangebang.water.dao.UserDao;
import com.sangebang.water.dao.impl.UserDaoImpl;
import com.sangebang.water.domain.User;

public class doUpdate extends HttpServlet {

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
		/* 设置响应头允许ajax跨域访问 */
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* 星号表示所有的异域请求都可以接受， */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		UserDao userdao = new UserDaoImpl();
		User u = new User();
		String tid = request.getParameter("tid");
		String tname=request.getParameter("tname");
		String tcontent=request.getParameter("tcontent");
		String phone=request.getParameter("phone");
		int tnumber=Integer.parseInt(request.getParameter("tnumber"));
		double price=Double.parseDouble(request.getParameter("price"));
		String url=request.getParameter("url");
		u.setTname(tname);
		u.setTcontent(tcontent);
		u.setTnumber(tnumber);
		u.setPhone(phone);
		u.setStatus("待审核");
		u.setPrice(price);
		u.setUrl(url);
		userdao.Add(u);
		userdao.Update(u);
	}

}
