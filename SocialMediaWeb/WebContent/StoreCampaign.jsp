<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="org.archcorner.services.*" %>
<%@ page import="org.archcorner.pojo.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Store Campaign</title>
</head>
<body>
<%
  String siteId = request.getParameter("id");
  String customerName = request.getParameter("customerName");
  String campaignName = request.getParameter("campaignName");
  String campaignText = request.getParameter("campaignText");
  
 //  out.println(blogTitle + "creating");
   CampaignService campaignService = new CampaignService();
   
   CustomerService customerService = new CustomerService();
   
   Customer customer = customerService.getCustomer(customerName);
   
   Campaign campaign = new Campaign();
   campaign.setCampaignId(campaignService.getHighestId()+1);
   campaign.setCampaignName(campaignName);
   campaign.setCampaignText(campaignText);
   campaign.setSiteId(Integer.valueOf(siteId));
   
   CustomerCampaign customerCampaign = new CustomerCampaign();
   customerCampaign.setCampaignId(campaign.getCampaignId());
   customerCampaign.setCustomerCampaignId(campaignService.getHighestCustomerCampaignId());
   customerCampaign.setCustomerId(customer.getCustomerId());
  
   
   campaignService.saveCampaign(campaign);
   
  // out.flush();
   //out.println(blogTitle + "created");
   
   response.sendRedirect("listCampaign.jsp?id="+siteId);
%>

</body>
</html>