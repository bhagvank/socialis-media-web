<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.text.*" %>
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

String experienceText = request.getParameter("experience");

String siteId = request.getParameter("id");

out.println(experienceText);

ExperienceService experienceService = new ExperienceService();
Experience experience = new Experience();
experience.setExperienceId(experienceService.getHighestId()+1);
experience.setExperience(experienceText);
experience.setSiteId(Integer.valueOf(siteId));

experienceService.saveExperience(experience);

response.sendRedirect("listExperiences.jsp?id="+siteId);

%>
</body>
</html>