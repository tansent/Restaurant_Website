package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Order;
import domain.User;

import service.impl.Service;

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Service service = new Service();
		Order order = service.findOrder(username);
		User user = service.login(username, password);
		if(user == null){
			//request only works for a single operation, not for a user's whole session
			request.setAttribute("loginError","Either username or password is correct!" );
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("order", order);
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
