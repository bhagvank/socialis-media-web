<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.crossover.pojo.*" %>
    <%@ page import="com.crossover.services.*" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>List of Experiences</title>
</head>
<body>
<%
String siteId = request.getParameter("id");
SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

ExperienceService experienceService = new ExperienceService();
List<Experience> experiences = experienceService.getExperiences(Integer.valueOf(siteId));

String siteName = site.getSiteName();

%>
<section id='header'> <div class='inner'> <h1><span> <A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<b>SiteName : <%=site.getSiteName()%> </b> </br>
<b>List of Experiences</b>
</div>
</section>
<section id="one" class="main style1">
<div class="container">
<table border=1>
<tr>
<th> SiteName</th>
<th> ExperienceId</th>
<th> Experience</th>
</tr>
<%

for(Experience experience: experiences)
{
	out.println("<tr border=1>");
	out.println("<td border=1");
	
	out.println(siteService.getSite(experience.getSiteId()).getSiteName());
	out.println("</td>");
	out.println("<td border=1>");
	out.println(experience.getExperienceId());
	out.println("</td>");
	out.println("<td border=1>");
	out.println(experience.getExperience());
	out.println("</td>");
%>

<%
    out.println("</tr>");
}
%>
</table>
</div>
</section>
</body>
</html>