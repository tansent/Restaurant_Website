package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.EncrptDataUtils;
import utils.JDBCUtils;
import dao.Orderdao;
import domain.Order;

public class MySQLOrderDAOImpl implements Orderdao{

	@Override
	public void add(Order order) {
		String sql = "insert into orders values(null,'"+order.getHostname()+"','"+order.getTelephone()+"','"+order.getTime()+"','"+order.getTotalPeople()+"','"+order.getNote()+"')";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtils.close(rs, stat, conn);
		}
		
	}

	@Override
	public void delete(String hostname) {
		String sql = "delete from orders where hostname = '"+ hostname +"'";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtils.close(rs, stat, conn);
		}
		
	}

	@Override
	public Order find(String hostname) {
		String sql = "select * from orders where hostname='"+hostname+"'";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()){
				Order order = new Order();
				order.setId(rs.getInt("id") + "");
				order.setHostname(rs.getString("hostname"));
				order.setTelephone(rs.getString("telephone"));
				order.setTime(rs.getString("time"));
				order.setTotalPeople(rs.getString("totalPeople"));
				order.setNote(rs.getString("note"));
				return order;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			JDBCUtils.close(rs, stat, conn);
		}
		
	}

}
