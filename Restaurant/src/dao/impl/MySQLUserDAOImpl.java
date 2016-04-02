package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.EncrptDataUtils;
import utils.JDBCUtils;

import dao.Userdao;
import domain.User;

public class MySQLUserDAOImpl implements Userdao {

	@Override
	public void add(User user) {
//		String sql = "insert into users values(null,'"+user.getUsername()+"','"+EncrptDataUtils.encrpt(user.getPassword())+"','"+user.getEmail()+"')";
//		Connection conn = null;
//		Statement stat = null;
//		ResultSet rs = null;
//		try {
//			conn = JDBCUtils.getConn();
//			stat = conn.createStatement();
//			stat.executeUpdate(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally{
//			JDBCUtils.close(rs, stat, conn);
//		}
		String sql = "insert into users values(null,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, EncrptDataUtils.encrpt(user.getPassword()));
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}

	@Override
	public boolean find(String username) {
//		String sql = "select * from users where username = '"+username+"'";
//		Connection conn = null;
//		Statement stat = null;
//		ResultSet rs = null;
//		try {
//			conn = JDBCUtils.getConn();
//			stat = conn.createStatement();
//			rs = stat.executeQuery(sql);
//			if(rs.next()){				
//				return true;  // there is a user with that name already
//			}else{
//				return false; // represents that no such username exists
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally{
//			JDBCUtils.close(rs, stat, conn);
//		}
		String sql = "select * from users where username = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){				
				return true;  // there is a user with that name already
			}else{
				return false; // represents that no such username exists
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}

	@Override
	public User find(String username, String password) {
//		String sql = "select * from users where username = '"+username+"' and password = '"+EncrptDataUtils.encrpt(password)+"'";
//		Connection conn = null;
//		Statement stat = null;
//		ResultSet rs = null;
//		try {
//			conn = JDBCUtils.getConn();
//			stat = conn.createStatement();
//			rs = stat.executeQuery(sql);
//			if(rs.next()){
//				User user = new User();
//				user.setId(rs.getInt("id") + "");
//				user.setEmail(rs.getString("email"));
//				user.setUsername(rs.getString("username"));
//				user.setPassword(rs.getString("password"));
//				return user;     // return the user's information if found
//			}else{
//				return null;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally{
//			JDBCUtils.close(rs, stat, conn);
//		}
//	}
		//'"+EncrptDataUtils.encrpt(password)+"'
		String sql = "select * from users where username = ? and password = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, EncrptDataUtils.encrpt(password));
			rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id") + "");
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;     // return the user's information if found
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
}
