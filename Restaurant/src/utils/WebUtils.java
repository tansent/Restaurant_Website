package utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import domain.Form;
import domain.User;

public class WebUtils {

	public static <T> T write2bean(HttpServletRequest request, Class<T> formClass){
		
		try {
			T form = formClass.newInstance();
			
			Map map = request.getParameterMap();
			
			BeanUtils.populate(form, map);
			
			return form;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		
	}

	public static boolean checkInfoValid(HttpServletRequest request, Form form) {
		
		boolean token = true;
		
		if(form.getUsername()==null || form.getUsername().trim().equals("")){
			token = false;
			form.getError().put("username", "username can not be empty!");
		}else{
			if(!form.getUsername().matches("[A-Za-z]{3,8}")){
				token = false;
				form.getError().put("username", "username must be 3-8 characters!");
			}
		}
		
		if(form.getPassword()==null || form.getPassword().trim().equals("")){
			token = false;
			form.getError().put("password", "password can not be empty!");
		}
//		else {
//			if(!form.getPassword().matches("\\d{3,8}$"));
//			token = false;
//			form.getError().put("password","password must be 3-8 numbers!");
//		}
		
		if(form.getCpassword()==null || form.getCpassword().trim().equals("") || (!form.getPassword().equals(form.getCpassword()))){
			token = false;
			form.getError().put("Cpassword", "passwords do not match!");
		}
		
		if(form.getEmail()==null || form.getEmail().trim().equals("")){
			token=false;
			form.getError().put("email", "email can not be empty!");
		}else{
			if(!form.getEmail().matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")){
				token=false;
				form.getError().put("email", "email's format is incorrect!");
			}
		}
		
		if (form.getCheckcode()==null || form.getCheckcode().trim().equals("")) {
			token = false;
			form.getError().put("checkcode", "checkcode can not be empty!");
		}else{
			String clientCheckcode = form.getCheckcode(); //request.getParameter("checkcode");
			String serverCheckcode = (String) request.getSession().getAttribute("checkcode");
			if(serverCheckcode == null || (!clientCheckcode.equals(serverCheckcode))){
				token = false;
				form.getError().put("checkcode", "checkcode is not entered correctly!");
			}
		}
		
		return token;
	}
	
	public static void copyBean(User dest, Form src){
		
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}

	public static void generateUserID(User user) {
		user.setId(UUID.randomUUID().toString());		
	}
	
}
