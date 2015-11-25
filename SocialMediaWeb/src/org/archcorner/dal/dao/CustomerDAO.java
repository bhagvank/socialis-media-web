package org.archcorner.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.archcorner.jdbc.util.JDBCManager;
import org.archcorner.pojo.Customer;
import org.archcorner.pojo.User;

import java.sql.ResultSet;

public class CustomerDAO {
	
	private String insertSQL = "INSERT INTO CUSTOMER(CUSTOMERID,CUSTOMERNAME,MOBILENO,ADDRESS,SITEID) VALUES(?,?,?,?,?)";
	private String updateSQL = "UPDATE CUSTOMER SET CUSTOMERNAME=?,MOBILENO=?,ADDRESS=? WHERE CUSTOMERID=? AND SITEID=?";
	private String deleteSQL = "DELETE CUSTOMER WHERE CUSTOMERID=?";
	private String highestIDSQL = "SELECT MAX(CUSTOMERID) AS MaxCustomerId FROM CUSTOMER";
	private String selectSQL = "SELECT * FROM CUSTOMER WHERE SITEID=?";
	private String selectCustomerSQL = "SELECT * FROM CUSTOMER WHERE CUSTOMERNAME=?";
	
	public void deleteCustomer(Customer customer)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, customer.getCustomerId());
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
	
	public void updateCustomer(Customer customer)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement =  null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getMobileNo());
			preparedStatement.setString(3, customer.getAddress());
			preparedStatement.setInt(4, customer.getCustomerId());
			preparedStatement.setInt(5, customer.getSiteId());
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
	
	public List<Customer> getCustomers(int site)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		List<Customer> customerList = new ArrayList<Customer>();
		
		try
		{
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, site);
			ResultSet resultSet = preparedStatement.executeQuery() ;
			
			while(resultSet.next())
			{
				int customerId = resultSet.getInt("CustomerId");
				String customerName = resultSet.getString("CustomerName");
				String mobileNo = resultSet.getString("MobileNo");
				String address = resultSet.getString("address");
				int siteId = resultSet.getInt("siteId");
				
				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				customer.setCustomerName(customerName);
				customer.setMobileNo(mobileNo);
				customer.setAddress(address);
				customer.setSiteId(siteId);
				
				customerList.add(customer);
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
		return customerList;
	}
	public Customer getCustomer(String customerNameStr)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		Customer customer = null;
		
		try
		{
			preparedStatement = connection.prepareStatement(selectCustomerSQL);
			preparedStatement.setString(1, customerNameStr);
			ResultSet resultSet = preparedStatement.executeQuery() ;
			
			while(resultSet.next())
			{
				int customerId = resultSet.getInt("CustomerId");
				String customerName = resultSet.getString("CustomerName");
				String mobileNo = resultSet.getString("MobileNo");
				String address = resultSet.getString("address");
				int siteId = resultSet.getInt("siteId");
				
				customer = new Customer();
				customer.setCustomerId(customerId);
				customer.setCustomerName(customerName);
				customer.setMobileNo(mobileNo);
				customer.setAddress(address);
				customer.setSiteId(siteId);
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
		return customer;
	}
	
    public void saveCustomer(Customer customer)
    {
    	Connection connection = JDBCManager.getConnection();
    	PreparedStatement preparedStatement = null;
    	try
    	{
    		preparedStatement = connection.prepareStatement(insertSQL);
    		preparedStatement.setInt(1, customer.getCustomerId());
    		preparedStatement.setString(2, customer.getCustomerName());
    		preparedStatement.setString(3, customer.getMobileNo());
    		preparedStatement.setString(4, customer.getAddress());
    		preparedStatement.setInt(5, customer.getSiteId());
    		
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
    			highestId = resultSet.getInt("MaxCustomerId");
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
