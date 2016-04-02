package dao;

import domain.User;

public interface Userdao {

	/**
	 * add a new user when registration is correct
	 * 
	 */
	public abstract void add(User user);
	
	/**
	 * To check if the username is existed
	 * 
	 */

	public abstract boolean find(String username);
	
	/**
	 * 
	 * For login use, to check if the login is valid
	 */

	public abstract User find(String username, String password);

}