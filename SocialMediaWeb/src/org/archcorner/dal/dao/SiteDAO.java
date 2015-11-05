package org.archcorner.dal.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.archcorner.jdbc.util.JDBCManager;
import org.archcorner.pojo.Site;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class SiteDAO {

	private String insertSQL = "INSERT INTO SITE(SiteId,SiteName,UserId) Values(?,?,?)";
	
	private String updateSQL = "UPDATE SITE SET SITENAME=? WHERE SITEID=? AND USERID=?";
	
	private String deleteSQL = "DELETE FROM SITE WHERE SITEID=? AND USERID=?";
	private String highestIdSQL = "SELECT MAX(SiteId) as MaxSiteId FROM SITE";
	
	private String selectSQL = "SELECT * FROM SITE WHERE USERID=";
	
	private String selectSiteSQL = "SELECT * FROM SITE WHERE SITEID=";
	
	public void deleteSite(Site site)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, site.getSiteId());
			preparedStatement.setInt(2, site.getUserId());
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
	
	public void updateSite(Site site)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, site.getSiteName());
			preparedStatement.setInt(2, site.getSiteId());
			preparedStatement.setInt(3, site.getUserId());
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
		Connection connection  = JDBCManager.getConnection();
		Statement statement = null;
		int highestId=0;
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(highestIdSQL);
			while(resultSet.next())
			{
				highestId = resultSet.getInt("MaxSiteId");
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
	
	public void saveSite(Site site)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, site.getSiteId());
			preparedStatement.setString(2, site.getSiteName());
			preparedStatement.setInt(3, site.getUserId());
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
	
	public List<Site> getSites(int user)
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		List<Site> siteList = new ArrayList<Site>();
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectSQL+user);
			
			while(resultSet.next())
			{
				Site site = new Site();
				int siteId = resultSet.getInt("SiteId");
				String siteName = resultSet.getString("SiteName");
				int userId = resultSet.getInt("UserId");
				
				site.setSiteId(siteId);
				site.setSiteName(siteName);
				site.setUserId(userId);
				siteList.add(site);
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
		
		return siteList;
	}
	
	public Site getSite(int siteIdNo)
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		Site site = new Site();
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectSiteSQL+siteIdNo);
			
			while(resultSet.next())
			{
				int siteId = resultSet.getInt("SiteId");
				String siteName = resultSet.getString("SiteName");
				int userId = resultSet.getInt("UserId");
				
				site.setSiteId(siteId);
				site.setSiteName(siteName);
				site.setUserId(userId);
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
		
		return site;
	}
}
