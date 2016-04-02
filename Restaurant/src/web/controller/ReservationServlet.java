package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Form;
import domain.Order;
import domain.ReservationForm;
import exception.MoreThanOneOrderException;

import service.impl.Service;
import utils.ProcessReservationUtils;

public class ReservationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ReservationForm reservationForm =ProcessReservationUtils.writeOrder2bean(request, ReservationForm.class);
		
		boolean b = ProcessReservationUtils.checkOrderValid(reservationForm);
		
		if(!b){
			request.setAttribute("reservationForm", reservationForm);
			request.getRequestDispatcher("/WEB-INF/jsp/Order.jsp").forward(request, response);
			return;
		}
		
		Order order = new Order();
		ProcessReservationUtils.copyReservationForm2Order(order, reservationForm);
		ProcessReservationUtils.generateOrderID(order);
		
		Service service = new Service();
		
		try {
			service.createOrder(order);
			request.getSession().setAttribute("order", order);
			request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(request, response); //jump to the "delete.jsp" page to show the order info
			return;
		} catch (MoreThanOneOrderException e) {
			request.setAttribute("orderMessage", "You have made an order which is on the progress, only one order can be made per person!");
			request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(request, response);;
			return;
		} catch (Exception e) {
			request.setAttribute("orderMessage", "An unknown error occurs when making the order!");
			request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(request, response);;
			return;
		}
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet( request,  response);
	}

}
