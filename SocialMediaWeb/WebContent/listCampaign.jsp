<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="com.crossover.pojo.*" %>
    <%@ page import="com.crossover.services.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>Campaign List</title>
<%
String siteId = request.getParameter("id");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();

CampaignService campaignDAO = new CampaignService();

List<Campaign> campaignList = campaignDAO.getCampaigns(Integer.valueOf(siteId));

%>
</head>
<body>
<section id='header'> 
<div class='inner'> <h1><span> <A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<B><%=siteName%></B> </br>
<B>Campaign List</B>

</div>
</section>
<section id="one" class="main style1">
<div class="container">
<%
out.println("<table border=1>");
out.println("<tr><th>Site Name</th><th>Campaign Id</th><th>CampaignName</th><th>Campaign Content</tr>");
for(Campaign campaign:campaignList)
{
	out.println("<tr border=1>");
	out.println("<td border=1>");
	out.println(siteName);
	out.println("</td>");
	out.println("<td border=1>");
	
	out.println(campaign.getCampaignId());
	out.println("</td>");
	
	out.println("<td border=1>");
	
	out.println(campaign.getCampaignName());
	out.println("</td>");
	
    out.println("<td border=1>");
	
	out.println(campaign.getCampaignText());
	out.println("</td>");
	out.println("</tr>");
	
	
}

out.println("</table>");
%>

</div>
</section>

</body>
</html>