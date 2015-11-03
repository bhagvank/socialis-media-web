package org.archcorner.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.archcorner.jdbc.util.JDBCManager;
import org.archcorner.pojo.Blog;


public class BlogDAO {
	
	private String insertSQL = "INSERT INTO BLOG(BLOGID,BLOGTITLE,SITEID) VALUES(?,?,?)";
	
	private String updateSQL = "UPDATE BLOG Set BLOGTITLE=? WHERE BLOGID=?";
	
	private String deleteSQL = "DELETE FROM BLOG WHERE BLOGID=";
	
	private String selectSQL = "SELECT * FROM BLOG WHERE SITEID=";
	
	private String highestIDSQL = "SELECT MAX(BLOGID) as MaxBlogId FROM BLOG";
	
	private String selectBlogSQL = "SELECT * FROM BLOG WHERE BLOGID=";
	
	
	public void updateBlog(Blog blog)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, blog.getBlogTitle());
			preparedStatement.setInt(2, blog.getBlogId());
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
	
	public void deleteBlog(Blog blog)
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		try
		{
			statement = connection.createStatement();
			statement.execute(deleteSQL+blog.getBlogId());
			
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
    			highestId = resultSet.getInt("MaxBlogId");
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
	public void saveBlog(Blog blog)
	{
		Connection connection = JDBCManager.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		try
		{
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, blog.getBlogId());
			preparedStatement.setString(2, blog.getBlogTitle());
			preparedStatement.setInt(3, blog.getSiteId());
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
	
	public List<Blog> getBlogs(int siteIdNo)
	{
		Connection connection = JDBCManager.getConnection();
		
		Statement statement = null;
		List<Blog> blogList = new ArrayList<Blog>();
		
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectSQL+siteIdNo);
			
			while(resultSet.next())
			{
				int blogId = resultSet.getInt("BlogId");
				String blogTitle = resultSet.getString("BlogTitle");
				int siteId = resultSet.getInt("SiteId");
				
				Blog blog = new Blog();
				blog.setBlogId(blogId);
				blog.setBlogTitle(blogTitle);
				blog.setSiteId(siteId);
				
				blogList.add(blog);
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
		
		return blogList;
	}
	public Blog getBlog(int blogIdNo)
	{
		Connection connection = JDBCManager.getConnection();
		
		Statement statement = null;
		Blog blog = new Blog();
		
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectBlogSQL+blogIdNo);
			
			while(resultSet.next())
			{
				int blogId = resultSet.getInt("BlogId");
				String blogTitle = resultSet.getString("BlogTitle");
				int siteId = resultSet.getInt("SiteId");
				

				blog.setBlogId(blogId);
				blog.setBlogTitle(blogTitle);
				blog.setSiteId(siteId);
				
				
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
		
		return blog;
	}

}
