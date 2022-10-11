package com.inputs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.courier.CourierDetails;
import com.dao.CalculateDao;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Calculate")
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String username =request.getParameter("data-username");
		String fromCity=(request.getParameter("data-fromCity"));
		String toCity=(request.getParameter("data-toCity"));
		Double weight=Double.parseDouble(request.getParameter("data-weight"));
		String mobile=(request.getParameter("data-mobile"));
		
		CourierDetails courierDetails= new CourierDetails();
		CalculateDao calculateDao = new CalculateDao();
		courierDetails.setCustomerName(username);
		courierDetails.setFromCity(fromCity);
		courierDetails.setToCity(toCity);
		courierDetails.setMobile(mobile);
		courierDetails.setWeight(weight);
		courierDetails.setShipmentDate(LocalDate.now());
		
		
		System.out.println(courierDetails.getToCity());
		
		
		
		
		try {
			calculateDao.calculateDateAndPrice(courierDetails);
			calculateDao.insertTransaction(courierDetails);

			List<CourierDetails> courierDetailsList=calculateDao.selectAllTransactions();
			request.setAttribute("courierDetailsList", courierDetailsList);

			response.sendRedirect("output.jsp");
//			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
}