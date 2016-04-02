package utils;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import domain.Order;
import domain.ReservationForm;


public class ProcessReservationUtils {

	public static <T> T writeOrder2bean(HttpServletRequest request, Class<T> reservationFormClass){
		
		try {
			T reservationForm = reservationFormClass.newInstance();
			
			Map map = request.getParameterMap();
			
			BeanUtils.populate(reservationForm, map);
			
			return reservationForm;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}

	public static boolean checkOrderValid(ReservationForm reservationForm) {
		
		boolean token = true;
		
		if(reservationForm.getTelephone()==null || reservationForm.getTelephone().trim().equals("")){
			token = false;
			reservationForm.getOrderError().put("telephone", "telephone should not be empty!");
		}
		else {
			if(!reservationForm.getTelephone().matches("^1[3|4|5|8][0-9]\\d{4,8}$"))
			{
				token = false;
				reservationForm.getOrderError().put("telephone", "telephone number is not valid!");
			}
		}
		
		String month = reservationForm.getMonth();
		String day = reservationForm.getDay();
		String year = reservationForm.getYear();
		String hour = reservationForm.getHour();
		String time;
		StringBuffer sb = new StringBuffer();
		time = sb.append(year + "-" + month + "-" + day + " " + hour ).toString();
//		if(!time.matches("^((//d{2}(([02468][048])|([13579][26]))[//-/////s]?((((0?[13578])|(1[02]))[//-/////s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[//-/////s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[//-/////s]?((0?[1-9])|([1-2][0-9])))))|(//d{2}(([02468][1235679])|([13579][01345789]))[//-/////s]?((((0?[13578])|(1[02]))[//-/////s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[//-/////s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[//-/////s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(//s(((0?[0-9])|([1-2][0-3]))//:([0-5]?[0-9])((//s)|(//:([0-5]?[0-9])))))?$"))	
//		{
//			token = false;
//			reservationForm.getOrderError().put("time", "this date is not valid");
//		}//+ ":" + "00" + ":" + "00"
		
		if(reservationForm.getTotalPeople()==null||reservationForm.getTotalPeople().trim().equals("")){
			token = false;
			reservationForm.getOrderError().put("totalPeople", "people entered error!");
		}
		
		return token;
	}

	public static Order copyReservationForm2Order(Order order,
			ReservationForm reservationForm) {
		
		String month = reservationForm.getMonth();
		String day = reservationForm.getDay();
		String year = reservationForm.getYear();
		String hour = reservationForm.getHour();
		String time;
		StringBuffer sb = new StringBuffer();
		time = sb.append(year + "-" + month + "-" + day + " " + hour + ":" + "00" + ":" + "00").toString();
		
		order.setHostname(reservationForm.getHostname());
		order.setTelephone(reservationForm.getTelephone());
		order.setTime(time);
		order.setTotalPeople(reservationForm.getTotalPeople());
		order.setNote(reservationForm.getNote());
				
		return order;
	}

	public static void generateOrderID(Order order) {
		order.setId(UUID.randomUUID().toString());
	}

	
}
