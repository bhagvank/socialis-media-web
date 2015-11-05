<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import="org.archcorner.services.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String siteId = request.getParameter("id");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>Create Customer</title>
</head>
<body>
<section id='header'> 
<div class='inner'> <h1><span><A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<B><%=siteName%></B> </br>
<B>Create Customer</B>

</div>
</section>
<section id="one" class="main style1">
<div class="container">
<form action="storeCustomer.jsp" method="post">
<input type="hidden" name="id" value="<%=siteId%>">
<table>
<tr>
<td>
<label><span>Customer Name</span>
</td>
<td>
<input type="text" name="customerName" value="customerName" placeholder=":input">
</label>
</td>
</tr>
<tr>
<td>
<label><span>Customer Mobile</span>
</td>
<td>
<input type="text" name="customerMobile" value="customerMobile" placeholder=":input">
</label>
</td>
</tr>
<tr>
<td>
<label><span>Customer Address</span>
</td>
<td>
<input type="text" name="customerAddress" value="customerAddress" placeholder=":input">
</label>
</td>
</tr>
<tr>
<td>

</td>
<td>
<input type="submit" name="submit" value="submit">
</td>
</tr>
</table>

</form>
</div>
</section>
</body>
</html>