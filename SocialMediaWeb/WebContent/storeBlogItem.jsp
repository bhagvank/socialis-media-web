<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.crossover.services.*" %>
    <%@ page import="com.crossover.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String siteId = request.getParameter("id");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();
String blogId = request.getParameter("blogId");
String blogItemText = request.getParameter("blogItemText");

BlogItemService blogItemService = new BlogItemService();
BlogItem blogItem = new BlogItem();
blogItem.setBlogId(Integer.valueOf(blogId));
blogItem.setBlogItem(blogItemText);
blogItem.setBlogItemId(blogItemService.getHighestId()+1);
blogItem.setBlogItemTitle("Title");


blogItemService.saveBlogItem(blogItem);

response.sendRedirect("listBlogItem.jsp?id="+siteId+"&blogId="+blogId);
%>
</body>
</html>