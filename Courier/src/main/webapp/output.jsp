<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.courier.CourierDetails"%>
<%@page import="com.dao.CalculateDao"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Apex Courier</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<style>
.col-4, .col-11, .col-8 {
	margin-bottom: 15px;
	text-align: left;
}




th, td {
  padding: 15px;
  }
  
 
</style>
</head>

<body >
	<div >
		<div id="nav-placeholder"></div>

		<div style="text-align: center; width: 100%" id="main">
			

			<table style="width: 100%;margin-top: 25px;">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Mobile Number</th>
					<th>From City</th>
					<th>To City</th>
					<th>Weight in Grams</th>
					<th>Cost</th>
					<th>Shipment Date</th>
					<th>Delivery Date</th>
					
				</tr>
				
				<%
				CalculateDao calculateDao = new CalculateDao(); 
				String mobile = (String)session.getAttribute("mobile"); 
				List<CourierDetails> list = calculateDao.selectAllTransactions(mobile);
				for (CourierDetails courierDetails : list) {
					%>
					<tr>
					<td><%=courierDetails.getId() %></td>
					<td><%=courierDetails.getCustomerName()%></td>
					<td><%=courierDetails.getMobile() %></td>
					<td><%=courierDetails.getFromCity() %></td>
					<td><%=courierDetails.getToCity() %></td>
					<td><%=courierDetails.getWeight() %></td>
					<td><%=courierDetails.getPrice() %></td>
					<td><%=courierDetails.getShipmentDate() %></td>   
					<td><%=courierDetails.getDeliverDate() %></td>
					</tr>
					
					
					<%
				}
			%>

			</table>
		</div>
	</div>

	<script>
		$(function() {
			$("#nav-placeholder").load("nav.html");
		});
	</script>
</body>
</html>