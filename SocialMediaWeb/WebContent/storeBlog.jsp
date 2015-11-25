<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.archcorner.services.*" %>
<%@ page import="org.archcorner.pojo.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Store Blog</title>
</head>
<body>
<%
  String siteId = request.getParameter("id");
  String blogTitle = request.getParameter("blogTitle");
  String blogId = request.getParameter("blogId");
 //  out.println(blogTitle + "creating");
   BlogService blogService = new BlogService();
   
   Blog blog = null;
   if(blogId == null)
   {
    blog = new Blog();
    blog.setBlogId(blogService.getHighestId()+1);
    blog.setBlogTitle(blogTitle);
    blog.setSiteId(Integer.valueOf(siteId));
    blogService.saveBlog(blog);
   }
   else
   {
	 blog = blogService.getBlog(Integer.parseInt(blogId));  
	 blog.setBlogTitle(blogTitle);
	 blog.setSiteId(Integer.valueOf(siteId));
	 blogService.updateBlog(blog);  
	   
   }
  
   
  
   
  // out.flush();
   //out.println(blogTitle + "created");
   
   response.sendRedirect("listBlog.jsp?id="+siteId);
%>
</body>
</html>