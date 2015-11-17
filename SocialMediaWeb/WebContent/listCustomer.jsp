<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import="org.archcorner.services.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>Customer List</title>
<%
String siteId = request.getParameter("id");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();

CustomerService customerService = new CustomerService();

List<Customer> customerList = customerService.getCustomers(Integer.valueOf(siteId));

%>
</head>
<body>
<section id='header'> 
<div class='inner'> <h1><span><A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<B><%=siteName%></B> </br>
<B>Customer List</B>

</div>
</section>
<section id="one" class="main style1">
<div class="container">
<%
out.println("<table border=1>");
out.println("<tr><th>Site Name</th><th>Customer Id</th><th>CustomerName</th><th>Edit Customer</th><th>Delete Customer</th></tr>");
for(Customer customer:customerList)
{
	out.println("<tr border=1>");
	out.println("<td border=1>");
	out.println(siteName);
	out.println("</td>");
	out.println("<td border=1>");
	
	out.println(customer.getCustomerId());
	out.println("</td>");
	
	out.println("<td border=1>");
	
	out.println(customer.getCustomerName());
	out.println("</td>");
	out.println("<td border=1>");
	out.println("<A HREF='EditCustomer.jsp?id="+siteId+"&customerId="+customer.getCustomerId()+"'> Edit Customer</A>");
	out.println("</td>");
	out.println("<td border=1>");
	out.println("<A HREF='DeleteCustomer.jsp?id="+siteId+"&customerId="+customer.getCustomerId()+"'>Delete Customer</A>");
	out.println("</td>");
	
	
	out.println("</tr>");
	
	
}

out.println("</table>");
%>

</div>
</section>

</body>
</html>