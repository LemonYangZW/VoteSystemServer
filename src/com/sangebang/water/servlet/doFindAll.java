package com.sangebang.water.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;




import com.sangebang.water.dao.UserDao;
import com.sangebang.water.dao.impl.UserDaoImpl;
import com.sangebang.water.domain.User;

public class doFindAll extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dofindAll");
		response.setContentType("text/html;charset=utf-8");
		/* ������Ӧͷ����ajax������� */
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");

		// ��ȡ΢��С����get�Ĳ���ֵ����ӡ
		String username = request.getParameter("id");
		String password = request.getParameter("tid");
		System.out.println("id=" + username + " ,tid=" + password);
		PrintWriter out = response.getWriter();
		// ����ֵ��΢��С����
		UserDao userdao = new UserDaoImpl();
		 List<User> userlist = userdao.findAll();
		 
		for(int i=0;i<userlist.size();i++){
			JSONObject json = JSONObject.fromObject(userlist.get(i).toString());
			System.out.println(json);
			out.write(json.toString()+"|");
			out.flush();
		}
		
		
		out.close();

	}

}
