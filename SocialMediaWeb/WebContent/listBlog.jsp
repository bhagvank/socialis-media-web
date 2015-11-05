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
<%
String siteId = request.getParameter("id");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();

%>
<title>List of Blogs</title>
</head>
<body>
<section id='header'> <div class='inner'> <h1><span> <A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<b>SiteName : <%=siteName%> </b> </br>
<b>List of Blogs</b>
</div>
</section>
<section id="one" class="main style1">
<div class="container">
<%
BlogService blogService = new BlogService();
List<Blog> blogList = blogService.getBlogs(Integer.valueOf(siteId));

out.println("<table border=1>");
out.println("<tr><th>Site Name</th><th>Blog Id</th><th>Blog Title</th></tr>");
for(Blog blog:blogList)
{
	out.println("<tr border=1>");
	out.println("<td border=1>");
	out.println(siteService.getSite(blog.getSiteId()).getSiteName());
	out.println("</td>");
	out.println("<td border=1>");
	
	out.println(blog.getBlogId());
	out.println("</td>");
	
	out.println("<td border=1>");
	
	out.println("<A HREF='BlogItemMain.jsp?id="+siteId+"&blogid="+blog.getBlogId()+"'>"+blog.getBlogTitle()+"</A>");
	out.println("</td>");
	
	out.println("</tr>");
	
	
}

out.println("</table>");
%>
</div>
</section>
</body>
</html>