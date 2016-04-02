package service.impl;

import dao.Orderdao;
import dao.Userdao;
import dao.impl.MySQLUserDAOImpl;
import dao.impl.OrderdaoImpl;
import dao.impl.UserdaoImpl;
import domain.Order;
import domain.User;
import exception.MoreThanOneOrderException;
import exception.UserExistException;
import factory.DaoFactory;

public class Service {

//	Userdao dao = new MySQLUserDAOImpl();
//	Userdao dao = new UserdaoImpl();
	Userdao dao = DaoFactory.getFactory().getUserDao();
	
//	Orderdao orderdao = new OrderdaoImpl();
	Orderdao orderdao = DaoFactory.getFactory().getOrderDao();
	
	
	public void register(User user) throws UserExistException{
		if(dao.find(user.getUsername())){
			throw new UserExistException();
		}
		else {
			dao.add(user);
		}
	}
	
	public User login(String username, String password){
		User user = dao.find(username, password);
		return user;
	}
	
	public void createOrder(Order order) throws MoreThanOneOrderException{
		if(orderdao.find(order.getHostname())!=null){
			throw new MoreThanOneOrderException();
		}else {
			orderdao.add(order);
		}
	}
	
	public void deleteOrder(String hostname){
		orderdao.delete(hostname);
	}
	
	public Order findOrder(String hostname){
		return orderdao.find(hostname);
	}

}
