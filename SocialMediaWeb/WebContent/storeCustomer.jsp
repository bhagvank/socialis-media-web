<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.services.*" %>
<%@ page import="org.archcorner.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Store Customer</title>
</head>
<body>
<%
  String siteId = request.getParameter("id");
  String customerId = request.getParameter("customerId");
  String customerName = request.getParameter("customerName");
  String customerMobile = request.getParameter("customerMobile");
  String customerAddress = request.getParameter("customerAddress");
  
  if(customerId == null)
  {
 //  out.println(blogTitle + "creating");
   CustomerService customerService = new CustomerService();
   Customer customer = new Customer();
   customer.setCustomerId(customerService.getHighestId()+1);
   customer.setCustomerName(customerName);
   customer.setMobileNo(customerMobile);
   customer.setAddress(customerAddress);
   customer.setSiteId(Integer.valueOf(siteId));
  
   
   customerService.saveCustomer(customer);
  }
  else
  {
	  CustomerService customerService = new CustomerService();
	  Customer customer = new Customer();
	  customer.setCustomerId(Integer.parseInt(customerId));
	  customer.setCustomerName(customerName);
	  customer.setMobileNo(customerMobile);
	  customer.setAddress(customerAddress);
	  customer.setSiteId(Integer.parseInt(siteId));
	  
	  customerService.updateCustomer(customer);
	  
  }
  // out.flush();
   //out.println(blogTitle + "created");
   
   response.sendRedirect("listCustomer.jsp?id="+siteId);
%>
</body>
</html>