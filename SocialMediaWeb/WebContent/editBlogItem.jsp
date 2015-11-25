<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import= "org.archcorner.services.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>Edit BlogItem</title>
<%
String siteId = request.getParameter("id");
String blogId = request.getParameter("blogId");
String blogItemId = request.getParameter("blogItemId");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.parseInt(siteId));
String siteName = site.getSiteName();

BlogService blogService = new BlogService();
Blog blog = blogService.getBlog(Integer.parseInt(blogId));
String blogName = blog.getBlogTitle();

BlogItemService blogItemService = new BlogItemService();
BlogItem blogItem = blogItemService.getBlogItem(Integer.parseInt(blogItemId));
String blogItemName = blogItem.getBlogItemTitle();


%>
</head>
<body>
<section id='header'>
<div class="inner">
<h1><span><A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span></h1>
<B><%=siteName%></B>
<B>Blog <%=blogName%></B>
<B>Edit BlogItem <%=blogItemName%></B>
</div>
</section>
<section>
<div class="container">
<form action="storeBlogItem.jsp" method="post">
<input type="hidden" value="<%=siteId%>" name="id">
<input type="hidden" value="<%=blogId%>" name="blogId">
<input type="hidden" value="<%=blogItemId%>" name="blogItemId">
<table>
<tr>
<td>
Edit the Blog Item Title
</td>
<td>
<input type="text" name="blogItemTitle" value="<%=blogItem.getBlogItemTitle()%>">
</td>
</tr>
<tr>
<td>
Edit the Blog Item Text
</td>
<td>
<textarea name="blogItemText" cols=40 rows=10><%=blogItem.getBlogItem()%></textarea>
</td>
</tr>
<tr>
<td>
<input type="submit" name="EditBlogItem">
</td>
<td>
</td>
</tr>

</table>
</form>
</div>
</section>
</body>
</html>