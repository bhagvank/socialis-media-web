package org.archcorner.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.archcorner.jdbc.util.JDBCManager;
import org.archcorner.pojo.Campaign;
import org.archcorner.pojo.Customer;
import org.archcorner.pojo.CustomerCampaign;

import java.sql.ResultSet;

public class CampaignDAO {
	private String insertSQL = "INSERT INTO CAMPAIGN(CAMPAIGNID,CAMPAIGNNAME,CAMPAIGNTEXT,SITEID) VALUES(?,?,?,?)";
	private String updateSQL = "UPDATE CAMPAIGN SET CAMPAIGNNAME=? AND CAMPAIGNTEXT=? WHERE CAMPAIGNID=?";
	private String deleteSQL = "DELETE FROM CAMPAIGN WHERE CAMPAIGNID=?";
	private String highestIDSQL = "SELECT MAX(CAMPAIGNID) AS MaxCampaignId FROM CAMPAIGN";
	private String highestCustomerIDSQL = "SELECT MAX(CUSTOMERCAMPAIGNID) AS MaxCustomerCampaignId FROM CUSTOMERCAMPAIGN";
	private String selectSQL = "SELECT * FROM CAMPAIGN WHERE SITEID=?";
	private String insertCustomerSQL = "INSERT INTO CUSTOMERCAMPAIGN(CUSTOMERCAMPAIGNID,CAMPAIGNID,CUSTOMERID) VALUES(?,?,?)";
	
	public void updateCampaign(Campaign campaign)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, campaign.getCampaignName());
			preparedStatement.setString(2, campaign.getCampaignText());
			preparedStatement.setInt(3, campaign.getCampaignId());
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
	
	public void deleteCampaign(Campaign campaign)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, campaign.getCampaignId());
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
	public List<Campaign> getCampaigns(int site)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		List<Campaign> campaignList = new ArrayList<Campaign>();
		
		try
		{
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, site);
			ResultSet resultSet = preparedStatement.executeQuery() ;
			
			while(resultSet.next())
			{
				int campaignId = resultSet.getInt("CampaignId");
				String campaignName = resultSet.getString("CampaignName");
				String campaignText = resultSet.getString("CampaignText");
				int siteId = resultSet.getInt("siteId");
				
				Campaign campaign = new Campaign();
				campaign.setCampaignId(campaignId);
				campaign.setCampaignName(campaignName);
				campaign.setCampaignText(campaignText);
				campaign.setSiteId(siteId);
				
				campaignList.add(campaign);
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
		return campaignList;
	}
	public void saveCampaign(Campaign campaign)
    {
    	Connection connection = JDBCManager.getConnection();
    	PreparedStatement preparedStatement = null;
    	try
    	{
    		preparedStatement = connection.prepareStatement(insertSQL);
    		preparedStatement.setInt(1, campaign.getCampaignId());
    		preparedStatement.setString(2, campaign.getCampaignName());
    		preparedStatement.setString(3, campaign.getCampaignText());
    		preparedStatement.setInt(4, campaign.getSiteId());
    		
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
	public void saveCustomerCampaign(CustomerCampaign customerCampaign)
    {
    	Connection connection = JDBCManager.getConnection();
    	PreparedStatement preparedStatement = null;
    	try
    	{
    		preparedStatement = connection.prepareStatement(insertCustomerSQL);
    		preparedStatement.setInt(1, customerCampaign.getCustomerCampaignId());
    		preparedStatement.setInt(2, customerCampaign.getCampaignId());
    		preparedStatement.setInt(3, customerCampaign.getCustomerId());
    		
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
    			highestId = resultSet.getInt("MaxCampaignId");
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
    public int getHighestCustomerCampaignId()
    {
    	Connection connection = JDBCManager.getConnection();
    	Statement statement = null;
    	int highestId =0;
    	try
    	{
    		statement = connection.createStatement();
    		ResultSet resultSet = statement.executeQuery(highestCustomerIDSQL);
    		
    		while(resultSet.next())
    		{
    			highestId = resultSet.getInt("MaxCustomerCampaignId");
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
}


