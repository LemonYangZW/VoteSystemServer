package com.sangebang.water.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.sangebang.water.dao.UserDao;
import com.sangebang.water.domain.User;
import com.sangebang.water.util.DBHelp;

public class UserDaoImpl implements UserDao{

	public List<User> findAll() {
		List<User> userlist = new CopyOnWriteArrayList<User>();
		Connection con = DBHelp.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from userinfo");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User u= new User();
				u.setId( rs.getInt(1));
				u.setTid(rs.getString(2));
				u.setTname(rs.getString(3));
				u.setTcontent(rs.getString(4));
				u.setTnumber(rs.getInt(5));
				u.setName(rs.getString(6));
				u.setPhone(rs.getString(7));
				u.setWxname(rs.getString(8));
				u.setTm(rs.getTimestamp(9));
				u.setStatus(rs.getString(10));
				u.setPrice(rs.getDouble(11));
				u.setUrl(rs.getString(12));
				userlist.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelp.close(con);
		}
		return userlist;
	}

	public void Add(User u) {
		Connection con = DBHelp.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into  userinfo values (0,0,?,?,?,?,?,?,?,?,?,?)");
//			ps.setString(1, u.getTid());
			ps.setString(1, u.getTname());
			ps.setString(2, u.getTcontent());
			ps.setInt(3, u.getTnumber());
			ps.setString(4, u.getName());
			ps.setString(5, u.getPhone());
			ps.setString(6, u.getWxname());
			ps.setTimestamp(7, u.getTm());
			ps.setString(8, u.getStatus());
			ps.setDouble(9, u.getPrice());
			ps.setString(10, u.getUrl());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelp.close(con);
		}
	}

	public void Update(User u) {
		Connection con = DBHelp.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement
			("update userinfo set tid=?,tname=?,tcontent=?,tnumber=?,name=?,phone=?,wxname=?,time=?,status=?,price=?,url=? where id =? ");
			
			ps.setString(1, u.getTid());
			ps.setString(2, u.getTname());
			ps.setString(3, u.getTcontent());
			ps.setInt(4, u.getTnumber());
			ps.setString(5, u.getName());
			ps.setString(6, u.getPhone());
			ps.setString(7, u.getWxname());
			ps.setDate(8, new java.sql.Date(u.getTm().getTime()));
			ps.setString(9, u.getStatus());	
			ps.setDouble(10, u.getPrice());
			ps.setString(11, u.getUrl());
			ps.setInt(12, u.getId());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelp.close(con);
		}
	}

	public void Delete(int id) {
		Connection con =DBHelp.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from userinfo where id=?");
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelp.close(con);
		}
	}

	public User findById(int id) {
		User u = new User();
		Connection con = DBHelp.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from userinfo where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				u.setId( rs.getInt(1));
				u.setTid(rs.getString(2));
				u.setTname(rs.getString(3));
				u.setTcontent(rs.getString(4));
				u.setTnumber(rs.getInt(5));
				u.setName(rs.getString(6));
				u.setPhone(rs.getString(7));
				u.setWxname(rs.getString(8));
				u.setTm(rs.getTimestamp(9));
				u.setStatus(rs.getString(10));
				u.setPrice(rs.getDouble(11));
				u.setUrl(rs.getString(12));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelp.close(con);
		}
		return u;
	}

	public List<User> limit(int pagestart, int pagesize) {
		List<User> userlist = new CopyOnWriteArrayList<User>();
		Connection con = DBHelp.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from userinfo limit ?,?");
			ps.setInt(1, pagestart);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setId( rs.getInt(1));
				u.setTid(rs.getString(2));
				u.setTname(rs.getString(3));
				u.setTcontent(rs.getString(4));
				u.setTnumber(rs.getInt(5));
				u.setName(rs.getString(6));
				u.setPhone(rs.getString(7));
				u.setWxname(rs.getString(8));
				u.setTm(rs.getTimestamp(9));
				u.setStatus(rs.getString(10));
				u.setPrice(rs.getDouble(11));
				u.setUrl(rs.getString(12));
				userlist.add(u);
			}
		} catch (Exception e) {
		}finally{
			DBHelp.close(con);
		}
		return userlist;
	}

	public List<User> findAllByName(String Type, String SearchName) {
		List<User> userlist = new CopyOnWriteArrayList<User>();
		Connection con = DBHelp.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from userinfo where "+Type+" like ?");
			ps.setString(1, "%"+SearchName+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setId( rs.getInt(1));
				u.setTid(rs.getString(2));
				u.setTname(rs.getString(3));
				u.setTcontent(rs.getString(4));
				u.setTnumber(rs.getInt(5));
				u.setName(rs.getString(6));
				u.setPhone(rs.getString(7));
				u.setWxname(rs.getString(8));
				u.setTm(rs.getTimestamp(9));
				u.setStatus(rs.getString(10));
				u.setPrice(rs.getDouble(11));
				u.setUrl(rs.getString(12));
				userlist.add(u);
			}
		} catch (Exception e) {
		}finally{
			DBHelp.close(con);;
		}
		return userlist;
	}

	public List<User> limitSerch(int pagestart, int pagesize, String Type,
			String SearchName) {
		List<User> userlist = new CopyOnWriteArrayList<User>();
		Connection con = DBHelp.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from userinfo where "+Type+" like ? limit ?,?");
			ps.setString(1, "%"+SearchName+"%");
			ps.setInt(2, pagestart);
			ps.setInt(3, pagesize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setId( rs.getInt(1));
				u.setTid(rs.getString(2));
				u.setTname(rs.getString(3));
				u.setTcontent(rs.getString(4));
				u.setTnumber(rs.getInt(5));
				u.setName(rs.getString(6));
				u.setPhone(rs.getString(7));
				u.setWxname(rs.getString(8));
				u.setTm(rs.getTimestamp(9));
				u.setStatus(rs.getString(10));
				u.setPrice(rs.getDouble(11));
				u.setUrl(rs.getString(12));
				userlist.add(u);
			}
		} catch (Exception e) {
		}finally{
			DBHelp.close(con);
		}
		return userlist;
	}

}
