<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.crossover.pojo.*" %>
     <%@ page import="com.crossover.services.*" %>
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
<title>Store a video</title>
</head>
<body>
<section id='header'> <div class='inner'> <h1><span> Social Media Web</span> </h1></br>
<b>SiteName : <%=siteName%> </b> </br>
<b>Share An Video</b>
</div>
</section>
<section id="one" class="main style1">
<div class="container">
<form action="storeVideo.jsp?id=<%=siteId%>" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>upload the video</td>
<td><input type="file" name="uploadvideo" size="50"></td>
</tr>
<tr>
<td><input type="submit" name="submit"></td>
<td><input type="button" name="cancel" value="Cancel"></td>

</tr>
</table>

</section>
</div>

</form>
</body>
</html>