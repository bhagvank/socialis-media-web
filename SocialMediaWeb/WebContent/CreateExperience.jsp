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
<title>Share An Experience</title>
</head>
<body>
<section id='header'> <div class='inner'> <h1><span> <A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<b>SiteName : <%=siteName%> </b> </br>
<b>Share an Experience</b>
</div>
</section>
<section id="one" class="main style1">
<div class="container">
<form action="storeExperience.jsp" method="post">
<table>
<input type="hidden" name="id" value="<%=siteId%>">
<tr>
<td>
<b>Input An Experience</b>
</td>
<td>
<textArea name="experience" cols=40 rows=10></textArea>
</td>
</tr>
<tr>
<td>

</td>
<td>
<input type="submit" value="submit">
</td>
</tr>
</table>
</form>
</div>
</section>
</body>
</html>