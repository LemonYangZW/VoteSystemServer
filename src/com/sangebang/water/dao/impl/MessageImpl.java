package com.sangebang.water.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.sangebang.water.dao.MessageDao;
import com.sangebang.water.domain.Message;
import com.sangebang.water.util.DBHelp;

/**
 * @author Administrator
 *
 */
public class MessageImpl implements MessageDao{

	public void add(Message message) {
			Connection con = DBHelp.getConnection();
				try {
					PreparedStatement ps = con.prepareStatement("insert into  Message values (0,?,?,?)");
					ps.setString(1, message.getReceive());
					ps.setString(2, message.getContent());
					ps.setTimestamp(3, message.getTm());
					ps.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DBHelp.close(con);
				}
			}

	public List<Message> findByName(String openid) {
		Connection con = DBHelp.getConnection();
		List<Message> meslist=new CopyOnWriteArrayList<Message>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Message where receive = ?");
			ps.setString(1, openid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Message mes=new Message();
				mes.setReceive(rs.getString(2));
				mes.setContent(rs.getString(3));
				mes.setTm(rs.getTimestamp(4));
				meslist.add(mes);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelp.close(con);
		}
		
		return meslist;
	}
	
	
}
