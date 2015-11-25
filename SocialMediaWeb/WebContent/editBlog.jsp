<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.archcorner.pojo.*"%>
    <%@page import="org.archcorner.services.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>Edit Blog</title>
<%
String siteId = request.getParameter("id");
SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.parseInt(siteId));
String siteName = site.getSiteName();

String blogId = request.getParameter("blogid");

BlogService blogService = new BlogService();

Blog blog = blogService.getBlog(Integer.parseInt(blogId));

%>
</head>
<body>
<section id='header'>
<div class="inner"><h1><span><A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span></h1></br>
<B><%=siteName%></B></br>
<B>Edit Blog <%=blog.getBlogTitle()%></B>

</div>
</section>
<section id="one" class="mainStyle">
<div class="container">
<form action="storeBlog.jsp" method="post">
<input type="hidden" value="<%=siteId%>" name="id">
<input type="hidden" value="<%=blogId%>" name="blogId">
<table>
<tr>
<td>
Edit the blog Title
</td>
<td>
<input type="text" name="blogTitle" value="<%=blog.getBlogTitle() %>">
</td>
</tr>
<tr>
<td>
<input type="submit" name="editBlog">
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