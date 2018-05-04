package com.sangebang.water.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sangebang.water.dao.UserDao;
import com.sangebang.water.dao.impl.UserDaoImpl;
import com.sangebang.water.domain.User;
import com.sangebang.water.util.Login;

public class doAdd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String tname=request.getParameter("tname");
		String tcontent=request.getParameter("tcontent");
		int tnumber=Integer.parseInt(request.getParameter("tnumber"));
		double price=Double.parseDouble(request.getParameter("price"));
		System.out.println(tname);
		System.out.println(tcontent);
		System.out.println(tnumber);
		System.out.println(price);
		User u = new User();
		
		u.setTname(tname);
		u.setTcontent(tcontent);
		u.setTnumber(tnumber);
		u.setName( "yangzhiwei");
		u.setPhone("13419533738");
		
		
		u.setWxname((String)session.getAttribute("code"));
		java.util.Date date = new java.util.Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		System.out.println(timeStamp);
		u.setTm(timeStamp);
		u.setStatus("´ýÉóºË");
		u.setPrice(price);
		u.setUrl("http://www.baidu.com");
		UserDao userdao = new UserDaoImpl();
		userdao.Add(u);
	}
}
