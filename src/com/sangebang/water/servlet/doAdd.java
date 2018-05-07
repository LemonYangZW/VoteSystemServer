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
		//id tid 自动生成
		String tname=request.getParameter("tname");
		String tcontent=request.getParameter("tcontent");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		int tnumber=Integer.parseInt(request.getParameter("tnumber"));
		double price=Double.parseDouble(request.getParameter("price"));
		String url=request.getParameter("url");
		User u = new User();
		java.util.Date date = new java.util.Date();								
		Timestamp timeStamp = new Timestamp(date.getTime());
		u.setTname(tname);
		u.setTcontent(tcontent);
		u.setTnumber(tnumber);
		u.setName( name);
		u.setPhone(phone);
		u.setWxname((String)session.getAttribute("code"));
		u.setTm(timeStamp);
		u.setStatus("待审核");
		u.setPrice(price);
		u.setUrl(url);
		UserDao userdao = new UserDaoImpl();
		userdao.Add(u);
	}
}
