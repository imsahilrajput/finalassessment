package com.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.courier.CourierDetails;
public class CalculateDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/allstates?useSSL=true";
	private String jdbctransactionname = "root";
	private String jdbcPassword = "password";
	private static final String INSERT_TRANSACTIONS_SQL = "INSERT INTO courier" + "  (customer_name, mobile,fromCity,toCity,weight,price,shipmentDate,deliveryDate) VALUES "
			+ " (?, ?, ?,?,?,?,?,?);";
	
	private static final String SELECT_ALL_TRANSACTIONS = "select * from courier;";
	private static final String DELETE_TRANSACTIONS_SQL = "delete from courier where id = ?;";
	
	double price = 0.0;
	LocalDate deliveryDate;
	public CalculateDao() {
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbctransactionname, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void calculateDateAndPrice(CourierDetails  courierDetails)throws SQLException{
		String fromCity=courierDetails.getFromCity();
		String toCity=courierDetails.getToCity();
		Double weight=courierDetails.getWeight();
		LocalDate shipmentDate = courierDetails.getShipmentDate();
		deliveryDate = shipmentDate.plusDays(1);



		
		if(fromCity.equals("mumbai") && toCity.equals("mumbai")) {
			price=(double)10*weight;

		}
		else if(fromCity.equals("mumbai") && toCity.equals("bangalore")) {
			price=(double)100*weight;
		}
		else if(fromCity.equals("mumbai") && toCity.equals("chennai") ){
			price=(double)120*weight;

		}
		else if(fromCity.equals("mumbai") && toCity.equals("kolkata")) {
			price=(double)140*weight;

		}else if(fromCity.equals("bangalore") && toCity.equals("bangalore")) {
			price=(double)10*weight;
		
		}else if(fromCity.equals("bangalore") && toCity.equals("mumbai")) {
			price=(double)100*weight;
		
		}else if(fromCity.equals("bangalore") && toCity.equals("chennai")) {
			price=(double)70*weight;
		
		}else if(fromCity.equals("bangalore") && toCity.equals("kolkata")) {
			price=(double)170*weight;
		
		}else if(fromCity.equals("kolkata") && toCity.equals("kolkata")) {
			price=(double)10*weight;
		
		}
		else if(fromCity.equals("kolkata") && toCity.equals("mumbai")) {
			price=(double)140*weight;
		
		}else if(fromCity.equals("kolkata") && toCity.equals("bangalore")) {
			price=(double)170*weight;
		
		}else if(fromCity.equals("kolkata") && toCity.equals("chennai")) {
			price=(double)180*weight;
		
		}else if(fromCity.equals("chennai") && toCity.equals("chennai")) {
			price=(double)10*weight;
		
		}else if(fromCity.equals("chennai") && toCity.equals("kolkata")) {
			price=(double)180*weight;
		
		}else if(fromCity.equals("chennai") && toCity.equals("mumbai")) {
			price=(double)120*weight;
		
		}else if(fromCity.equals("chennai") && toCity.equals("bangalore")) {
			price=(double)70*weight;
		
		}else {
			System.out.println("hii");
		}
		System.out.println(shipmentDate);
		System.out.println(deliveryDate);
		System.out.println(price);

				
	
	}
	
	public  int insertTransaction(CourierDetails  courierDetails) throws SQLException {
		System.out.println(INSERT_TRANSACTIONS_SQL);
		// try-with-resource statement will auto close the connection.
		int r=0;

		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRANSACTIONS_SQL)) {
			preparedStatement.setString(1, courierDetails.getCustomerName());
			preparedStatement.setString(2, courierDetails.getMobile());

			preparedStatement.setString(3, courierDetails.getFromCity());
			preparedStatement.setString(4, courierDetails.getToCity());
			preparedStatement.setDouble(5, courierDetails.getWeight());
			preparedStatement.setDouble(6, price);
			preparedStatement.setDate(7, java.sql.Date.valueOf(courierDetails.getShipmentDate()));
			preparedStatement.setDate(8, java.sql.Date.valueOf(deliveryDate));

			

			System.out.println(preparedStatement);
			r=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public List<CourierDetails> selectAllTransactions() {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<CourierDetails> courierDetails = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSACTIONS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("customer_name");
				String mobile = rs.getString("mobile");				
				String from=rs.getString("fromCity");
				String to=rs.getString("toCity");
				Double weight = rs.getDouble("weight");
				Double price=rs.getDouble("price");
				Date shipmentDate=rs.getDate("shipmentDate");
			    Date deliveryDate = rs.getDate("deliveryDate");
			    
			    LocalDate localDate1 = shipmentDate.toLocalDate();
			    LocalDate localDate2 = deliveryDate.toLocalDate();
			    
				
				courierDetails.add(new CourierDetails(id,name,mobile, from,to,weight,price,localDate1,localDate2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courierDetails;
	}
}