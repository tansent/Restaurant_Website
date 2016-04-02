package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Order;

import service.impl.Service;

public class DeleteOrderServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Order order = (Order)session.getAttribute("order");
		
		Service service = new Service();
		service.deleteOrder(order.getHostname());
		
		session.removeAttribute("order");
		
		request.setAttribute("message", "your order has been canceled successfully, the page will jump back to home page in 3 seconds, if not, <a href='"+request.getContextPath()+"/index.jsp'>click</a> to jump. <meta http-equiv='refresh' content='3; url="+request.getContextPath()+"/index.jsp' >");
		request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,  response);
	}

}
