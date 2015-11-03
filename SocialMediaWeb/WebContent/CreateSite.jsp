<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.crossover.pojo.*" %>
    <%@ page import="com.crossover.services.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>Create a site</title>
<%
  String userid = request.getParameter("id");

AuthenticationService authenticationService = new AuthenticationService();
  User user = authenticationService.getUserById(Integer.valueOf(userid));
%>
</head>
<body>
<section id='header'> <div class='inner'> <h1><span> Social Media Web</span> </h1></br>
<B>User Logged in : <%=user.getUserName()%> </B> </br>
<B>Site Creation Page</B>

</div>
</section>
<section id="one" class="main style1">
<div class="container">



<form action="StoreSite.jsp" method="post" style="elegant-aero">
<input type="hidden" name="id" value="<%=userid%>">
<table>
<tr>
<td>
<label><span>Create a Site</span>
</td>
<td>
<input type="text" name="siteName" value="siteName" placeholder=":input">
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