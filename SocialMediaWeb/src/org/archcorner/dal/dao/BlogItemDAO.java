package org.archcorner.dal.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.archcorner.jdbc.util.JDBCManager;
import org.archcorner.pojo.Blog;
import org.archcorner.pojo.BlogItem;

import java.sql.ResultSet;
import java.sql.Connection;

public class BlogItemDAO {

	private String insertSQL = "INSERT INTO BLOGITEMS(BLOGITEMID,BLOGITEMTITLE,BLOGITEMTEXT,BLOGID) VALUES(?,?,?,?)";
	private String updateSQL = "UPDATE BLOGITEMS SET BLOGITEMTITLE=? WHERE BLOGITEMID=? AND BLOGID=?";
	private String selectSQL = "SELECT * FROM BLOGITEMS WHERE BLOGID=";
	private String deleteSQL = "DELETE FROM BLOGITEMS WHERE BLOGITEMID=? AND BLOGID=?";
	private String highestIDSQL = "SELECT MAX(BLOGITEMID) as MaxBlogItemId From BLOGITEMS";
	
	public void updateBlogItem(BlogItem blogItem)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, blogItem.getBlogItemTitle());
			preparedStatement.setInt(2, blogItem.getBlogItemId());
			preparedStatement.setInt(3, blogItem.getBlogId());
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
	
	public void deleteBlogItem(BlogItem blogItem)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, blogItem.getBlogItemId());
			preparedStatement.setInt(2, blogItem.getBlogId());
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
    			highestId = resultSet.getInt("MaxBlogItemId");
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
	public void saveBlogItem(BlogItem blogItem)
	{
		Connection connection = JDBCManager.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		try
		{
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setInt(1, blogItem.getBlogItemId());
			
			preparedStatement.setString(2,blogItem.getBlogItemTitle());
			
			preparedStatement.setString(3, blogItem.getBlogItem());
			
			preparedStatement.setInt(4, blogItem.getBlogId());
			
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
	
	
	public List<BlogItem> getBlogItems(Blog blog)
	{
		Connection connection = JDBCManager.getConnection();
		
		Statement statement = null;
		
		List<BlogItem> blogItemList = new ArrayList<BlogItem>();
		
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectSQL+blog.getBlogId());
			
			while(resultSet.next())
			{
				int blogItemId = resultSet.getInt("BlogItemId");
				String blogItemTitle = resultSet.getString("BlogItemTitle");
				String blogItemText = resultSet.getString("BlogItemText");
				int blogId = resultSet.getInt("BlogId");
				BlogItem blogItem = new BlogItem();
				blogItem.setBlogId(blogId);
				blogItem.setBlogItem(blogItemText);
				blogItem.setBlogItemId(blogItemId);
				blogItem.setBlogItemTitle(blogItemTitle);
				
				blogItemList.add(blogItem);
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
		
		return blogItemList;
	}
	
}
