<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.crossover.pojo.*" %>
    <%@ page import="com.crossover.services.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Store a site</title>
</head>
<body>
<%
 String siteName = request.getParameter("siteName");

 String userId = request.getParameter("id");


 out.println(siteName);
 
 SiteService siteService = new SiteService();
 int highestId = siteService.getHighestId();
 
 Site site = new Site();
 site.setSiteId(highestId+1);
 site.setSiteName(siteName);
 site.setUserId(Integer.valueOf(userId));
 
 siteService.saveSite(site);
 
 response.sendRedirect("SiteList.jsp?id=" +userId);

%>
</body>
</html>