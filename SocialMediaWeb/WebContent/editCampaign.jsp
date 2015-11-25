<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import="org.archcorner.services.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>Edit Campaign</title>
<%
String siteId = request.getParameter("id");
SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.parseInt(siteId));
String siteName = site.getSiteName();

String campaignId = request.getParameter("campaignId");

CampaignService campaignService = new CampaignService();

Campaign campaign = campaignService.getCampaign(Integer.parseInt(campaignId));
%>
</head>
<body>
<section id='header'>
<div class="inner">
<h1><span><A HREF="SocialMediaWeb.jsp?id="+siteId+"&name="+siteName">SocialMediaWeb</A></span></h1><br>
<B><%=siteName%></B>
<B>Edit Campaign <%=campaign.getCampaignName() %></B>

</div>
</section>
<section id="one" class="mainStyle">
<div class="container">
<form action="storeCampaign.jsp" method="post">
<input type="hidden" name="id" value=<%=siteId%>>
<input type="hidden" name="campaignId" value=<%=campaign.getCampaignId()%>>
<table>
<tr>
<td>
Edit Campaign Name
</td>
<td>
<input type="text" name="campaignName" value="<%=campaign.getCampaignName() %>">
</td>
</tr>
<tr>
<td>
Edit Campaign Text
</td>
<td>
<input type="text" name="campaignText" value="<%=campaign.getCampaignText() %>">
</td>
</tr>
<tr>
<td>
<input type="submit" name="editCampaign">
</td>
</tr>
</table>
</form>
</div>
</section>

</body>
</html>