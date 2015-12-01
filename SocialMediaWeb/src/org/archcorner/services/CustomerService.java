package org.archcorner.services;

import java.util.List;

import org.archcorner.dal.dao.CustomerDAO;
import org.archcorner.pojo.Customer;

public class CustomerService {
	
	public List<Customer> getCustomers(int site)
	{
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.getCustomers(site);
	}

	public Customer getCustomer(String customerNameStr)
	{
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.getCustomer(customerNameStr);
	}
	 public void saveCustomer(Customer customer)
	 {
		 CustomerDAO customerDAO = new CustomerDAO();
	      customerDAO.saveCustomer(customer);
	 }
	 
	 public void updateCustomer(Customer customer)
	 {
		 CustomerDAO customerDAO =  new CustomerDAO();
		 customerDAO.updateCustomer(customer);
		 
	 }
	 public int getHighestId()
	  {
		 CustomerDAO customerDAO = new CustomerDAO();
	     return customerDAO.getHighestId();
		 
	  }
	 
	 public void deleteCustomer(Customer customer)
	 {
		 CustomerDAO customerDAO = new CustomerDAO();
		 customerDAO.deleteCustomer(customer);
	 }
}
