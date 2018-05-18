package com.sangebang.water.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelp {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://193.112.185.121:3306/VoteSystem?characterEncoding=utf-8";
	private static final String USER = "root";
	private static final String PASSWORD = "Whbx123";

	// 获取连接
	public static Connection getConnection() {
		Connection con = null; // 声明一个连接对象
		try {
			Class.forName(DRIVER);
			// 注册驱动
			con = DriverManager.getConnection(URL, USER, PASSWORD); // 获得连接对象
			if(!con.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
		} catch (ClassNotFoundException e) { // 捕获驱动类无法找到异常
			e.printStackTrace();
		} catch (SQLException e) { // 捕获SQL异常
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con) {// 关闭连接对象
		if (con != null) { // 如果conn连接对象不为空
			try {
				con.close(); // 关闭conn连接对象对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
