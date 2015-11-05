<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">
<title>SocialMediaWeb</title>
</head>
<%
 String siteId = request.getParameter("id");
 String siteName = request.getParameter("name");

%>
<body>
<section id='header'> <div class='inner'> <h1><span> Social Media Web</span> </h1></br>
<B>SiteName : <%=siteName%> </B> </br>

</div>
</section>
<section id="one" class="main style1">
<div class="container">
<table>
<tr><td><A HREF="CreateExperience.jsp?id=<%=siteId%>">Create an Experience</A></td></tr>
<tr><td><A HREF="listExperiences.jsp?id=<%=siteId%>">List of Experiences</A></td></tr>
<tr><td><A HREF="createBlog.jsp?id=<%=siteId%>">Create a Blog</A></td></tr>
<tr><td><A HREF="listBlog.jsp?id=<%=siteId%>">List of Blogs</A></td></tr>
<tr><td><A HREF="uploadVideo.jsp?id=<%=siteId%>">Upload a video</A></td></tr>
<tr><td><A HREF="initiateChat.jsp?id=<%=siteId%>">Group chat</A></td></tr>
<tr><td><A HREF="CreateCampaign.jsp?id=<%=siteId%>">Create a Campaign</A></td></tr>
</table>
</div>
</section>
</body>
</html>