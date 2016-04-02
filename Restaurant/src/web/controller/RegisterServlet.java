package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Form;
import domain.User;
import exception.UserExistException;

import service.impl.Service;
import utils.WebUtils;

public class RegisterServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. judge if all the information is valid		
		//2. if not, return to the Register.jsp page to alter		
		//3. if okay, distinguish whether the user is already exist		
		//4. if not, continue the process to register		
		//5. if existed, return back to the Register.jsp page to denote the user		
		//6. if not existed, yet some other errors occur, return to a message.jsp page to inform the user
		
		request.setCharacterEncoding("UTF-8");
		
		Form form = WebUtils.write2bean(request, Form.class);
		
		//1. judge if all the information is valid		
		boolean b = WebUtils.checkInfoValid(request, form);
					
		if(!b){
			//2. if not, return to the Register.jsp page to alter
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		//3. if okay, distinguish whether the user is already exist		
		User user = new User();
		WebUtils.copyBean(user, form);
		WebUtils.generateUserID(user);
		
		Service service = new Service();
		try {
			service.register(user);
			//4. if not, continue the process to register		
			request.setAttribute("message", "Congratulation! Register successful!browser will automaticly switch to home page in 3 seconds; if not, <a href='"+request.getContextPath()+"/index.jsp'>click</a> to jump.  <meta http-equiv='refresh' content='3; url="+request.getContextPath()+"/index.jsp' >");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			//5. if existed, return back to the Register.jsp page to denote the user	
			form.getError().put("username", "User Exist!");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}catch(Exception e){
			//6. if not existed, yet some other errors occur, return to a message.jsp page to inform the user
			request.setAttribute("message", "Server encounter an unknown error!");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

}
