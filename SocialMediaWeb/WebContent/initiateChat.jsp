<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="org.archcorner.dal.dao.*" %>
    <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<%
String siteId = request.getParameter("id");

SiteDAO siteDAO = new SiteDAO();
Site site = siteDAO.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();

%>
<title>Intiate Chat</title>
</head>
<body>
<section id='header'> <div class='inner'> <h1><span> <A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<b>SiteName : <%=siteName%> </b> </br>
<b>Initiate Chat</b>
</div>
</section>
<section id="one" class="main style1">
<div class="container">
<form action="GetChat.jsp" method="post">
<input type="hidden" name="fromUser" value="1">
<input type="hidden" name="id" value="<%=siteId%>">
<table>
<tr>
<td>
UserName
</td>
<td>
<input type="text" name="toUser">
</td>
</tr>
<tr>
<td>
Type in Chat
</td>
<td>
<textArea cols=40 rows=10 name="chatText">
</textArea>
</td>
</tr>
<tr>
<td>
<input type="submit" name="sendChat">
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