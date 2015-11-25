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
<title>Create Blog Item</title>
</head>
<body>
<%
String blogId = request.getParameter("blogid");

String siteId = request.getParameter("id");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();

%>
<section id='header'> 
<div class='inner'> <h1><span> Social Media Web</span> </h1></br>
<B><%=siteName%></B> </br>
<B>Write Blog Item</B>

</div>
</section>
<section id="one" class="main style1">
<div class="container">

<form action="storeBlogItem.jsp" method="post">
<input type="hidden" name="blogId" value="<%=blogId%>">
<input type="hidden" name="id" value="<%=siteId%>">
<table>
<tr>
<td>
Input the BlogItem Title
</td>
<td>
<input type="text" name="blogItemTitle">
</td>
</tr>
<tr>
<td>Input the blog Item </td>
<td><textArea name="blogItemText" cols=40 rows=10>
</textArea></td>
</tr>
<tr>
<td>
<input type="submit" name="Store Blog Item">
</td>
<td>
</td>
</tr>
</table>
</form>
</body>
</html>