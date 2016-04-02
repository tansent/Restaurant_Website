package junit;

import org.junit.Test;

import domain.Order;
import domain.User;
import exception.MoreThanOneOrderException;
import exception.UserExistException;
import service.impl.Service;

public class TestService {
	
	@Test
	public void testRegister(){
		Service service = new Service();
		
		User user = new User();
		user.setEmail("haha@126.com");
		user.setId("2222");
		user.setUsername("jack");
		user.setPassword("1234");
		
		try {
			service.register(user);
		} catch (UserExistException e) {
			System.out.println("User Exist!");
		}
	}
	
	@Test
	public void testLogin(){
		Service service = new Service();
		
		User user = service.login("tom", "abcd");
		
		if(user==null){
			System.out.println("username/password error!");
		}else {
			System.out.println("welcome");
		}
	}
	
	@Test
	public void testAddOrder(){
		Service service = new Service();
		
		Order order = new Order();
		order.setHostname("michael");
		order.setTelephone("13971197553");
		order.setTime("2015-3-30 09:00:00");
		order.setTotalPeople("3");
		order.setNote("first time to come, hope it's great!");
		try {
			service.createOrder(order);
		}catch (MoreThanOneOrderException e) {
			System.out.println("you have already had an order in progress!");
		}
	}
	
	@Test
	public void testDeleteOrder(){
		Service service = new Service();
		service.deleteOrder("michael");
	}
	
	@Test
	public void testExpression(){//
		String str = "18236589675";
		if(str.matches("^1[3|4|5|8][0-9]\\d{4,8}$")){ //^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$
			System.out.println("success!");
		}else {
			System.out.println("fail");
		}
	}
}
