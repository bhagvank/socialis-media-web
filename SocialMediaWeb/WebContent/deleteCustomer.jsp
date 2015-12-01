<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import="org.archcorner.services.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>Delete Customer</title>
<%
String siteId = request.getParameter("id");
String customerName = request.getParameter("customerName");
SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.parseInt(siteId));

CustomerService customerService = new CustomerService();
Customer customer = customerService.getCustomer(customerName);

customerService.deleteCustomer(customer);

response.sendRedirect("listCustomer.jsp?id="+siteId);



%>
</head>
<body>

</body>
</html>