<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import="org.archcorner.services.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>Delete Campaign</title>
<%
 String siteId = request.getParameter("id");
 String campaignId = request.getParameter("campaignId");
 
 CampaignService campaignService = new CampaignService();
 Campaign campaign = campaignService.getCampaign(Integer.parseInt(campaignId));
 campaignService.deleteCampaign(campaign);

 response.sendRedirect("listCampaign.jsp?id="+siteId);

%>
</head>
<body>

</body>
</html>