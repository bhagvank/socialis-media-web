<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.services.*" %>
    <%@ page import="org.archcorner.pojo.*" %>
    <%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String siteId = request.getParameter("id");

SiteService siteService = new SiteService();
Site site = siteService.getSite(Integer.valueOf(siteId));

String siteName = site.getSiteName();

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="photonlanding.css">

<%
 String fromUserId = request.getParameter("fromUser");

 String toUserName = request.getParameter("toUser");
 
 String chatText = request.getParameter("chatText");

 AuthenticationService authenticationService = new AuthenticationService();
 User user = authenticationService.getUser(toUserName);
 
 ChatService chatService = new ChatService();
 Chat chat = new Chat();
 chat.setChatId(chatService.getHighestId()+1);
 chat.setChatText(chatText);
 chat.setFromUserId(Integer.valueOf(fromUserId));
 

 chatService.saveChat(chat);
 
 
 UserChat userChat = new UserChat();
 userChat.setChatUserId(chatService.getHighestChatUserId()+1);
 userChat.setChatId(chat.getChatId());
 userChat.setFromUserId(Integer.valueOf(fromUserId));
 userChat.setToUserId(user.getUserId());
 
 chatService.saveUserChat(userChat);
 
 
 
 List<Chat> chatList = chatService.getChatTo(Integer.valueOf(user.getUserId()),Integer.valueOf(fromUserId));
 
 String chatToText  = null;
 for(Chat chatTo:chatList)
 {
	 chatToText = chatToText + chatTo.getChatText();
 }
%>
<title>Get Chat</title>
</head>
<body>
<section id='header'> <div class='inner'> <h1><span> <A HREF="SocialMediaWeb.jsp?id=<%=siteId%>&name=<%=siteName%>">Social Media Web</A></span> </h1></br>
<b>Chat with  <%=toUserName%></b>
</div>
</section>
<section id="one" class="main style1">
<div class="container">

<form action="GetChat.jsp" method="post">

<input type="hidden" name="fromUser" value=<%=fromUserId%>>
<input type="hidden" name="toUser" value="<%=user.getUserName()%>">
<input type="hidden" name="id" value="<%=siteId%>">
<table>
<tr>
<td>
Type in Chat
</td>
<td>
<textArea cols=40 rows=10 name="chatToText">
<%=chatText%>
</textArea>
</td>
</tr>
<tr>
<td>
<input type="submit" name="sendChat">
</td>
<td>
</td>
</tr>
</table>
</form>
</body>
</html>