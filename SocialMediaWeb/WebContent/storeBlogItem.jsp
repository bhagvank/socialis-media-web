<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.services.*" %>
    <%@ page import="org.archcorner.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String siteId = request.getParameter("id");
String blogItemId = request.getParameter("blogItemId");
String blogItemTitle = request.getParameter("blogItemTitle");
String blogItemText = request.getParameter("blogItemText");
String blogId = request.getParameter("blogId");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();



BlogItemService blogItemService = new BlogItemService();

BlogItem blogItem = null;

if(blogItemId == null)
{
  blogItem = new BlogItem();
  blogItem.setBlogId(Integer.valueOf(blogId));
  blogItem.setBlogItem(blogItemText);
  blogItem.setBlogItemId(blogItemService.getHighestId()+1);
  blogItem.setBlogItemTitle(blogItemTitle);
  blogItemService.saveBlogItem(blogItem);
}
else
{
	blogItem = new BlogItem();
	blogItem.setBlogId(Integer.valueOf(blogId));
	blogItem.setBlogItem(blogItemText);
	blogItem.setBlogItemId(Integer.valueOf(blogItemId));
	blogItem.setBlogItemTitle(blogItemTitle);
	
  blogItemService.updateBlogItem(blogItem);
}




response.sendRedirect("listBlogItem.jsp?id="+siteId+"&blogid="+blogId);
%>
</body>
</html>