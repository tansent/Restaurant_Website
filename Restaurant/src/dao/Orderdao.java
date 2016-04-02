package dao;

import domain.Order;

public interface Orderdao {

	public abstract void add(Order order);

	public abstract void delete(String hostname);
	
	public abstract Order find(String hostname);

}