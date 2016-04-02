package junit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import dao.Orderdao;
import dao.Userdao;
import dao.impl.OrderdaoImpl;
import dao.impl.UserdaoImpl;
import domain.Order;
import domain.User;

public class Testdao {

	@Test
	public void testadd(){
		User user = new User("11111", "tom", "abcd", "tom@gmail.com");
		
		Userdao udi = new UserdaoImpl();
		
		udi.add(user);
	}
	
	@Test
	public void testfindwithname(){
		Userdao udi = new UserdaoImpl();
		if(udi.find("tony")){
			System.out.println("exist!");
		}
		else {
			System.out.println("no such user!");
		}
	}
	
	@Test
	public void testfindwithnameandpsd(){
		Userdao udi = new UserdaoImpl();
		User user = udi.find("tom", "abcd");
		if(user==null){
			System.out.println("either username or password is incorrect!");
		}
		else {
			System.out.println("welcome "+user.getUsername());
		}
	}
	@Test
	public void testDateConnection(){
		String string1 = "1992";
		String string2 = "10";
		String string3 = "21";
		
		Calendar rightnow = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
		String string4 = f.format(rightnow.getTime());
		
		//String string4 = System.currentTimeMillis() + "";
		String string5;
		
		StringBuffer sb = new StringBuffer();
		
		string5 = sb.append(string1 + "-" + string2 + "-" + string3 + " " +string4).toString();
		System.out.println(string5);
	}
	
	@Test
	public void testOrderAdd(){
		Order order = new Order();
		order.setHostname("michael");
		order.setTelephone("13971197553");
		order.setTime("2015-3-30 09:00:00");
		order.setTotalPeople("3");
		order.setNote("first time to come, hope it's great!");
		
		Orderdao o = new OrderdaoImpl();
		o.add(order);
	}
	
	@Test
	public void testOrderDelete(){
		String hostname = "michael";
		Orderdao o = new OrderdaoImpl();
		o.delete(hostname);
	}
}
