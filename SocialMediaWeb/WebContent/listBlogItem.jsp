<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ page import="org.archcorner.services.*" %>
    <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>List of BlogItems</title>
<%
String siteId = request.getParameter("id");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();

%>
</head>
<body>
<section id='header'> <div class='inner'> <h1><span> <A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<b>SiteName : <%=siteName%> </b> </br>
<b>List of Blog Items</b>
</div>
</section>
<section id="one" class="main style1">
<div class="container">
<%
 String blogId = request.getParameter("blogid");
 

 Blog blog = new Blog();
 blog.setBlogId(Integer.valueOf(blogId));
 BlogItemService blogItemService = new BlogItemService();
 List<BlogItem> blogItemList =blogItemService.getBlogItems(blog);
 out.println("<table border=1>");
 out.println("<tr><th>BlogItemId</th><th>Blog Item</th><th>Edit Blog Item</th><th>Delete Blog Item</th></tr>");
 for( BlogItem blogItem: blogItemList)
 {
	 out.println("<tr border=1>");
	 out.println("<td>");
	 out.println(blogItem.getBlogItemId());
	 out.println("</td>");
	 out.println("<td>");
	 out.println(blogItem.getBlogItemTitle());
	 out.println("</td>");
	 out.println("<td>");
	 out.println("<A HREF='editBlogItem.jsp?id="+siteId+"&blogId="+blog.getBlogId()+"&blogItemId="+blogItem.getBlogItemId()+"'>"+"Edit Blog Item"+"</A>");
	 out.println("</td>");
	 out.println("<td>");
	 out.println("<A HREF='deleteBlogItem.jsp?id="+siteId+"&blogId="+blog.getBlogId()+"&blogItemId="+blogItem.getBlogItemId()+"'>"+"Delete Blog Item"+"</A>");
	 out.println("</tr>");
 }
 
 out.println("</table>");
%>
</div>
</section>
</body>
</html>