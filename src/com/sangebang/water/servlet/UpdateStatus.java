package com.sangebang.water.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sangebang.water.dao.MessageDao;
import com.sangebang.water.dao.UserDao;
import com.sangebang.water.dao.impl.MessageImpl;
import com.sangebang.water.dao.impl.UserDaoImpl;
import com.sangebang.water.domain.Message;

public class UpdateStatus extends HttpServlet {

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
		String tid=request.getParameter("tid");
		String status = request.getParameter("status");
		UserDao userdao=new UserDaoImpl();
		MessageDao mesdao=new MessageImpl();
		HttpSession session = request.getSession();
		 
		userdao.UpdateStatus(tid, status);
//		
//		Timestamp timeStamp = new Timestamp(new java.util.Date().getTime());
//		Message mes=new Message();
//		mes.setReceive((String)session.getAttribute("openid"));
//		mes.setContent(status);
//		mes.setTm(timeStamp);
//		
//		mesdao.add(mes);
	}

}
