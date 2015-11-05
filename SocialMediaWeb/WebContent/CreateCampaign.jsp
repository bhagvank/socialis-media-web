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
<title>Create a Campaign</title>
</head>
<body>
<section id='header'> 
<div class='inner'> <h1><span> <A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<B><%=siteName%></B> </br>
<B>Create Campaign</B>

</div>
</section>
<section id="one" class="main style1">
<div class="container">

<table>
<tr><td><A HREF="CreateCustomer.jsp?id=<%=siteId%>">Create Customer</A></td></tr>
<tr><td><A HREF="listCustomer.jsp?id=<%=siteId%>">Customer List</A></td></tr>
<tr><td><A HREF="createCustomerCampaign.jsp?id=<%=siteId%>">Create CustomerCampaign</A></td></tr>
<tr><td><A HREF="listCampaign.jsp?id=<%=siteId%>">CustomerCampaign List</A></td></tr>
<tr><td><A HREF="createGroupCampaign.jsp?id=<%=siteId%>">Create GroupCampaign</A></td></tr>
</table>
</div>
</section>
</body>
</html>