package org.archcorner.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.archcorner.jdbc.util.JDBCManager;
import org.archcorner.pojo.Experience;

public class ExperienceDAO {
	
	private String sql = "INSERT INTO Experience(ExperienceId,Experience,SiteId) VALUES(?,?,?)";
	
	private String selectSQL = "Select *  from Experience WHERE SITEID=";
	
	private String deleteSQL = "Delete From Experience where experienceId=";
	
	private String updateSQL = "Update Experience set experience=? where experienceId=?";
	
	private String highestIdSQL = "SELECT MAX(ExperienceID) as MAXExperienceId from Experience";
	
	public int getHighestId()
    {
    	Connection connection = JDBCManager.getConnection();
    	Statement statement = null;
    	int highestId =0;
    	try
    	{
    		statement = connection.createStatement();
    		ResultSet resultSet = statement.executeQuery(highestIdSQL);
    		
    		while(resultSet.next())
    		{
    			highestId = resultSet.getInt("MAXExperienceId");
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
	public void saveExperience(Experience experience)
	{
		
	Connection connection = JDBCManager.getConnection();

    PreparedStatement preparedStatement = null;       

	try
	{
	 preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setInt(1,experience.getExperienceId());
	preparedStatement.setString(2,experience.getExperience());
	preparedStatement.setInt(3, experience.getSiteId());
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
	
	public List<Experience> getExperiences(int siteIdNo)
	{
		 Connection connection = JDBCManager.getConnection();
		 
		 Statement statement = null;
		 
		 List<Experience> experienceList = new ArrayList<Experience>();
		 
		 try
		 {
			 statement = connection.createStatement();
			 
			 ResultSet resultSet = statement.executeQuery(selectSQL+siteIdNo);
			 
			 while(resultSet.next())
			 {
				 int experienceId = resultSet.getInt("experienceId");
				 
				 String experienceText = resultSet.getString("experience");
				 
				 int siteId = resultSet.getInt("siteId");
				 
				 Experience experience = new Experience();
				 experience.setExperienceId(experienceId);
				 experience.setExperience(experienceText);
				 experience.setSiteId(siteId);
				 
				 experienceList.add(experience);
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
		 
		 return experienceList;
	}
	
	public void deleteExperience(Experience experience)
	{
		Connection connection = JDBCManager.getConnection();
		
		Statement statement = null;
		
		try
		{
			statement = connection.createStatement();
			
			statement.execute(deleteSQL+experience.getExperienceId());
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
	
	public void updateExperience(Experience experience)
	{
		Connection connection = JDBCManager.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		try
		{
			
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, experience.getExperience());
			preparedStatement.setInt(2, experience.getExperienceId());
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
}
