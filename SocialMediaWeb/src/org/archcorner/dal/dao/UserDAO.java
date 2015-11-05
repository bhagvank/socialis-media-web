package org.archcorner.dal.dao;

import java.sql.Statement;

import org.archcorner.jdbc.util.JDBCManager;
import org.archcorner.pojo.User;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class UserDAO 
{
	private String insertSQL = "INSERT INTO USER(UserId,USERNAME,PASSWORD) VALUES(?,?,?)";
	private String selectSQL = "SELECT * FROM USER WHERE USERNAME=?";
	private String highestIDSQL = "SELECT MAX(USERID) as MaxUSerId FROM USER";
	private String selectUserSQL = "SELECT * FROM USER WHERE USERID=?";
	private String updateSQL = "UPDATE USER SET USERNAME=? AND PASSWORD=? WHERE USERID=?";
	private String deleteSQL = "DELETE FROM USER WHERE USERID=?";
	
	public void deleteUser(User user)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, user.getUserId());
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
				if(preparedStatement != null)
				{
					preparedStatement.close();
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
	}
	
	public void updateUser(User user)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getUserId());
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
				if(preparedStatement != null)
				{
					preparedStatement.close();
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
	}
	public int getHighestId()
    {
    	Connection connection = JDBCManager.getConnection();
    	Statement statement = null;
    	int highestId =0;
    	try
    	{
    		statement = connection.createStatement();
    		ResultSet resultSet = statement.executeQuery(highestIDSQL);
    		
    		while(resultSet.next())
    		{
    			highestId = resultSet.getInt("MaxUSerId");
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
	
	public User getUser(String username)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		User user = null;
		
		try
		{
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery() ;
			
			while(resultSet.next())
			{
				int userId = resultSet.getInt("UserId");
				String userName = resultSet.getString("UserName");
				String password = resultSet.getString("Password");
				
				user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				user.setPassword(password);
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
		return user;
	}
	public User getUserById(int userIdNo)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		User user = null;
		
		try
		{
			preparedStatement = connection.prepareStatement(selectUserSQL);
			preparedStatement.setInt(1, userIdNo);
			ResultSet resultSet = preparedStatement.executeQuery() ;
			
			while(resultSet.next())
			{
				int userId = resultSet.getInt("UserId");
				String userName = resultSet.getString("UserName");
				String password = resultSet.getString("Password");
				
				user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				user.setPassword(password);
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
		return user;
	}

	
}
