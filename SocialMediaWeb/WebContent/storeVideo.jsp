<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*,java.util.*,javax.servlet.*" %>
    <%@ page import="javax.servlet.http.*"%>
    <%@ page import="org.apache.commons.fileupload.*" %>
    <%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
    <%@ page import="org.apache.commons.fileupload.servlet.*" %>
    <%@ page import="org.apache.commons.io.output.*" %>
    <%@ page import="com.crossover.pojo.*" %>
    <%@ page import="com.crossover.services.*" %>
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


ServletContext context = pageContext.getServletContext();

String uploadContentType = request.getContentType();

if((uploadContentType.indexOf("multipart/form-data") >=0))
{
	DiskFileItemFactory itemFactory = new DiskFileItemFactory();
	itemFactory.setSizeThreshold(5000*1024);
	itemFactory.setRepository(new File("/Users/bhagvan_kommadi/temp"));
	
	ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
	
	fileUpload.setSizeMax(5000*1024);
	
	try
	{
		List uploadFiles = fileUpload.parseRequest(request);
		out.println("uploading files");
		out.println("count"+uploadFiles.size());
		Iterator iterator = uploadFiles.iterator();
		
		while(iterator.hasNext())
		{
			FileItem fileItem = (FileItem) iterator.next();
			if(!fileItem.isFormField())
			{
				String field = fileItem.getFieldName();
				String fileName = fileItem.getName();
				boolean isInMemory = fileItem.isInMemory();
				long size = fileItem.getSize();
				File file;
				if(fileName.lastIndexOf("\\") >= 0)
				{
					file = new File("/Users/bhagvan_kommadi/temp/"+fileName.substring(fileName.lastIndexOf("\\")));
					
				}
				else
				{
					file = new File("/Users/bhagvan_kommadi/temp/"+fileName.substring(fileName.lastIndexOf("\\")+1));
				}
				
				fileItem.write(file);
				
			}
		}
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	
}

response.sendRedirect("SocialMediaWeb.jsp?id="+site.getSiteId()+"&name="+site.getSiteName());
%>

</body>
</html>