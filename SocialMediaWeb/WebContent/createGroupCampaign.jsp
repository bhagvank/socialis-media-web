<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import="org.archcorner.services.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>Create Group Campaign</title>
<%
String siteId = request.getParameter("id");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();

%>
</head>
<body>
<section id='header'> 
<div class='inner'> <h1><span> <A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<B><%=siteName%></B> </br>
<B>Create Group Campaign</B>

</div>
</section>
<section id="one" class="main style1">
<div class="container">
<form action="StoreCampaign.jsp" method="post">
<input type="hidden" name="id" value="<%=siteId%>">
<table>
<tr>
<td>
<label><span>Group Name</span>
</td>
<td>
<input type="text" name="customerName" value="customerName" placeholder=":input">
</label>
</td>
</tr>
<tr>
<td>
<label><span>Campaign Name</span>
</td>
<td>
<input type="text" name="campaignName" value="campaignName" placeholder=":input">
</label>
</td>
</tr>
<tr>
<td>
<label><span>Campaign Content</span>
</td>
<td>
<input type="text" name="campaignText" value="campaignText" placeholder=":input">
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
</div>
</section>
</body>
</html>