package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//Injecct the session factory 
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		//Get the current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query and sort
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",
						Customer.class);
		
		//execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return the results 
		
		
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//Get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/update the customer
		currentSession.saveOrUpdate(theCustomer);
		
		
	}


	@Override
	public Customer getCustomer(int theId) {
		
		//get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve/read from db using primary key 
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		//Delete code goes here 
		
		//get the current hibernate session 
		Session curreSession = sessionFactory.getCurrentSession();
		
		
		//delete object with primary key 
		Query theQuery = curreSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		
		theQuery.executeUpdate();
				
	}

}
