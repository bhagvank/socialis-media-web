<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.services.*" %>
    <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>List of Sites</title>
</head>
<%
String userId = request.getParameter("id");
AuthenticationService authenticationService = new AuthenticationService();
User user = authenticationService.getUserById(Integer.valueOf(userId));
%>
<body>
<section id='header'> <div class='inner'> <h1><span> Social Media Web</span> </h1></br>
<B>User Logged in : <%=user.getUserName()%> </B> </br>
<B>List of Sites</B>

</div>
</section>
<section id="one" class="main style1">
<div class="container">
<%
  

    SiteService siteService = new SiteService();
    List<Site> siteList = siteService.getSites(Integer.valueOf(userId));
    
    out.println("<table border=2>");
    out.println("<tr><th>SiteId</th><th>&nbsp&nbsp SiteName</th><th>Edit Site</th><th>Delete Site</th></tr>");
    for(Site site: siteList)
    {
    	out.println("<tr border=1>");
    	out.println("<td border=1>");
    	out.println(site.getSiteId());
    	out.println("</td>");
    	out.println("<td border=1>");
    	out.println("<A HREF='SocialMediaWeb.jsp?id="+site.getSiteId()+"&name="+site.getSiteName()+ "&userId="+userId+"'>"+site.getSiteName()+"</A>");
    	out.println("</td>");
    	out.println("<td border=1>");
    	out.println("<A HREF='EditSite.jsp?id="+site.getSiteId()+"'>Edit Site</A>");
    	out.println("</td>");
    	out.println("<td border=1>");
    	out.println("<A HREF='DeleteSite.jsp?id="+site.getSiteId()+"'>DeleteSite</A>");
    	out.println("</td>");
    	out.println("</tr>");
    }
    out.println("</table>");
%>
</body>
</html>