package com.vel.springdemo.dao;

import java.util.List;
//import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vel.springdemo.entity.Customer;

@Repository
@Transactional(value = "myTransactionManager") 
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory sessionFactory;
	
		
	@Override
	//@Transactional --added in service layer
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query (Sort by last name)
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		//currentSession.save(theCustomer); // INSERT new record
		currentSession.saveOrUpdate(theCustomer); //INSERT or UPDATE the record
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// now delete from database using the primary key
		//currentSession.delete(theCustomer);
				
		//return theCustomer;
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId").setParameter("customerId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public Customer getCustomerInfo(Customer theCustomer) {
		Customer customer = new Customer();
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer where firstName=:firstName and email=:email", Customer.class)
				.setParameter("firstName", theCustomer.getFirstName())
				.setParameter("email", theCustomer.getEmail());
		try {
			customer = theQuery.getSingleResult();
		}catch(Exception e) {
			System.out.println("getCustomerInfo: No Result");
			return customer=null;
		}
		
		return customer;			
		
	}

	

}
