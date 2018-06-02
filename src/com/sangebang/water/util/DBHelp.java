package com.sangebang.water.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelp {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://118.24.41.227:3306/VoteSystem?characterEncoding=utf-8";
	private static final String USER = "root";
	private static final String PASSWORD = "Whbx123!@#";

	// ��ȡ����
	public static Connection getConnection() {
		Connection con = null; // ����һ�����Ӷ���
		try {
			Class.forName(DRIVER);
			// ע����
			con = DriverManager.getConnection(URL, USER, PASSWORD); // ������Ӷ���
			if(!con.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
		} catch (ClassNotFoundException e) { // ���������޷��ҵ��쳣
			e.printStackTrace();
		} catch (SQLException e) { // ����SQL�쳣
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con) {// �ر����Ӷ���
		if (con != null) { // ���conn���Ӷ���Ϊ��
			try {
				con.close(); // �ر�conn���Ӷ������
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
