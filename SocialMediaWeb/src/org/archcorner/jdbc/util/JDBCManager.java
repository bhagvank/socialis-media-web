package org.archcorner.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCManager {
	
	public static Connection getConnection()
	{
		Connection connection = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		try
		{
		  connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/socialmediaweb","root","root");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			
		}
		
		return connection;

	}
	
	public static void closeConnection(Connection connection)
	{
		try
		{
			connection.close();
		}
		catch(Exception exception)
		{
			
		}
		finally
		{
			
		}
	}

}
