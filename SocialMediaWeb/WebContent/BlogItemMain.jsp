<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.crossover.services.*" %>
    <%@ page import="com.crossover.pojo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>List of BlogItems</title>
</head>
<body>
<%
String siteId = request.getParameter("id");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();

 String blogId = request.getParameter("blogid");
%>
<section id='header'> <div class='inner'> <h1><span> <A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<b>SiteName : <%=siteName%> </b> </br>
<b>List of Blog Items</b>
</div>
</section>
<section id="one" class="main style1">
<div class="container">
<table>
<tr><td> <A HREF="blogItemCreate.jsp?id=<%=siteId%>&blogid=<%=blogId%>">Create a Blog Item</A> </td></tr>
<tr><td><A HREF="listBlogItem.jsp?id=<%=siteId%>&blogid=<%=blogId%>"> List of Blog Items</A></td></tr>
</table>
</div>
</section>
</body>
</html>