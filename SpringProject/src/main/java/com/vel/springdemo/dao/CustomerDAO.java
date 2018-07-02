package com.vel.springdemo.dao;

import java.util.List;
import com.vel.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public Customer getCustomerInfo(Customer theCustomer);

}
