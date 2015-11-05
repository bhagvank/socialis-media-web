<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import="org.archcorner.services.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<%
String siteId = request.getParameter("id");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();

%>
<title>Write a Blog</title>
</head>
<body>
<section id='header'> <div class='inner'> <h1><span> <A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<b>SiteName : <%=siteName%> </b> </br>
<b>Create a Blog</b>
</div>
</section>
<section id="one" class="main style1">
<div class="container">
<form action="storeBlog.jsp" method="post">
<input type="hidden" name="id" value=<%=siteId%>>
<table>
<tr>
<td>
Write the Blog title
</td>
<td>
<input type="text" name="blogTitle">
</td>
</tr>
<tr>
<td>
<input type="submit" name="CreateBlog">
</td>
<td>
</td>
</tr>
</table>
</form>
</div>
</section>
</body>
</html>