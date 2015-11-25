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
<title>Create Customer Campaign</title>
</head>
<body>
<section id='header'> 
<div class='inner'> <h1><span> Social Media Web</span> </h1></br>
<B><%=siteName%></B> </br>
<B>Create Customer Campaign</B>

</div>
</section>
<section id="one" class="main style1">
<div class="container">
<form action="storeCampaign.jsp" method="post">
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

</form>

</div>
</section>
</body>
</html>