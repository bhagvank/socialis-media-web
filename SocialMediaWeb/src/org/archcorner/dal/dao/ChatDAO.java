package org.archcorner.dal.dao;

import java.sql.ResultSet;

import java.sql.PreparedStatement;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.archcorner.jdbc.util.JDBCManager;
import org.archcorner.pojo.Chat;
import org.archcorner.pojo.UserChat;

import java.sql.Connection;

public class ChatDAO {
	
	private String insertSQL = "INSERT INTO CHAT(CHATID,CHATTEXT,FROMUSER) VALUES(?,?,?)";
	private String insertChatSQL = "INSERT INTO CHATUSER(CHATUSERID,CHATID,FROMUSERID,TOUSERID) VALUES(?,?,?,?)";
	private String updateSQL = "UPDATE CHAT SET CHATTEXT=?,FROMUSER=? WHERE CHATID=?";
	private String deleteSQL = "DELETE FROM CHAT WHERE CHATID=?";
	private String fromSelectSQL = "SELECT * FROM CHAT WHERE FROMUSER=";
	private String toSelectSQL = "SELECT * FROM CHATUSER WHERE TOUSERID=? AND FROMUSERID=?";
	private String highestIdSQL = "SELECT MAX(CHATID) AS MaxChatId FROM CHAT";
	private String highestChatIdSQL = "SELECT MAX(CHATUSERID) AS MaxChatUserId FROM CHATUSER";
	private String selectSQL = "SELECT * FROM CHAT WHERE CHATID=";
	
	public void updateChat(Chat chat)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, chat.getChatText());
			preparedStatement.setInt(2, chat.getFromUserId());
			preparedStatement.setInt(3, chat.getChatId());
			preparedStatement.executeUpdate();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				preparedStatement.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			JDBCManager.closeConnection(connection);
		}
	}
	public void deleteChat(Chat chat)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, chat.getChatId());
			preparedStatement.executeUpdate();
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				preparedStatement.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			JDBCManager.closeConnection(connection);
		}
	}
	public int getHighestChatUserId()
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		int highestId = 0;
		
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(highestChatIdSQL);
			while(resultSet.next())
			{
				highestId = resultSet.getInt("MaxChatUserId");
			}
			resultSet.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			JDBCManager.closeConnection(connection);
		}
		
				return highestId;
	}
	public int getHighestId()
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		int highestId = 0;
		
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(highestIdSQL);
			while(resultSet.next())
			{
				highestId = resultSet.getInt("MaxChatId");
			}
			resultSet.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			JDBCManager.closeConnection(connection);
		}
		
				return highestId;
	}
	
	public void saveUserChat(UserChat userChat)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		
		try
		{
			preparedStatement = connection.prepareStatement(insertChatSQL);
			preparedStatement.setInt(1, userChat.getChatUserId());
			preparedStatement.setInt(2,userChat.getChatId());
			preparedStatement.setInt(3, userChat.getFromUserId());
			preparedStatement.setInt(4,userChat.getToUserId());
			
			preparedStatement.execute();
		}
		catch(Exception exception)
		{
		  exception.printStackTrace();
		}
		finally
		{
			try
			{
			 preparedStatement.close();
			}
			catch(Exception exception)
			{
			  exception.printStackTrace();
			}
			JDBCManager.closeConnection(connection);
		}
	}
	
	public void saveChat(Chat chat)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		
		try
		{
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, chat.getChatId());
			preparedStatement.setString(2, chat.getChatText());
			preparedStatement.setInt(3, chat.getFromUserId());
			
			preparedStatement.execute();
		}
		catch(Exception exception)
		{
		  exception.printStackTrace();
		}
		finally
		{
			try
			{
			 preparedStatement.close();
			}
			catch(Exception exception)
			{
			  exception.printStackTrace();
			}
			JDBCManager.closeConnection(connection);
		}
	}

	public List<Chat> getChatFrom(int fromUser)
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		
		List<Chat> chatList = new ArrayList<Chat>();
		
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(fromSelectSQL+fromUser);
			
			
			while(resultSet.next())
			{
				int chatId = resultSet.getInt("ChatId");
				String chatText = resultSet.getString("ChatText");
				int fromUserId = resultSet.getInt("fromUser");
				
				Chat chat = new Chat();
				chat.setChatId(chatId);
				chat.setChatText(chatText);
				chat.setFromUserId(fromUserId);
				
				chatList.add(chat);
				
			}
			resultSet.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
			 statement.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
			JDBCManager.closeConnection(connection);
		}
		
		return chatList;
	}
	
	public Chat getChat(int chatIdno)
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		Chat chat = null;
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectSQL+chatIdno);
			
			while(resultSet.next())
			{
				chat = new Chat();
				int chatId = resultSet.getInt("chatId");
				String chatText = resultSet.getString("chatText");
				int fromUser = resultSet.getInt("fromUser");
				
				chat.setChatId(chatId);
				chat.setChatText(chatText);
				chat.setFromUserId(fromUser);
				
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			JDBCManager.closeConnection(connection);
		}
		
		return chat;
		
	}
	public List<Chat> getChatTo(int toUser,int fromUser)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		
		List<UserChat> userChatList = new ArrayList<UserChat>();
		
		try
		{
			preparedStatement = connection.prepareStatement(toSelectSQL);
			preparedStatement.setInt(1, toUser);
			preparedStatement.setInt(2, fromUser);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				int chatUserId = resultSet.getInt("ChatUserId");
				int toUserId = resultSet.getInt("toUserId");
				int fromUserId = resultSet.getInt("fromUserId");
				int chatId = resultSet.getInt("chatId");
				
				
				
				UserChat chatUser = new UserChat();
				chatUser.setChatId(chatId);
				chatUser.setChatUserId(chatUserId);
				chatUser.setFromUserId(fromUserId);
                chatUser.setToUserId(toUserId);				
				userChatList.add(chatUser);
				
			}
			resultSet.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
			 preparedStatement.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
			JDBCManager.closeConnection(connection);
		}
		
		List<Chat> chatList = new ArrayList<Chat>();
		for(UserChat userChat: userChatList)
		{
			Chat chat = getChat(userChat.getChatId());
			
			chatList.add(chat);
		}
		return chatList;
	}
}
