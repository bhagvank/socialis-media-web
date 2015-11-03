<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.crossover.services.*" %>
    <%@ page import="com.crossover.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>Site Main</title>
</head>
<body>

<%
 String username = request.getParameter("username");
 String password = request.getParameter("password");
 
 AuthenticationService authenticationService = new AuthenticationService();
 User user = authenticationService.getUser(username);
 
 if(user != null)
 {
 if( password.equals(user.getPassword()))
 {
	 out.println("<section id='header'> <div class='inner'> <h1><span> Social Media Web </span></h1></br>");
	 out.println("<b>User Logged In :  "+user.getUserName() + "</b>");
	 out.println("</div> </section>");
	 
	 out.println("<section id='one' class='main style1'> <div class='container'>");
	 out.println("<table>");
	 out.println("<tr><td><A HREF='CreateSite.jsp?id="+user.getUserId()+"'> CreateSite</A> </td></tr>");
	 out.println("<tr><td><A HREF='SiteList.jsp?id=" +user.getUserId()+"'>List of Sites</A> </td></tr>");
	 out.println("</table>");
	 out.println("</div> </section>");
 }
 else
 {
	 out.println("Login Failure");
	 response.sendRedirect("Login.jsp");
 }
 }
 else
 {
	 out.println("Login Failure");
	 response.sendRedirect("Login.jsp");
	 
 }
%>

</div>
</section>
</body>
</html>