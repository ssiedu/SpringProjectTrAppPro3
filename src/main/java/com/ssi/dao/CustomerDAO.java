package com.ssi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entities.Customer;

@Component
public class CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveCustomer(Customer customer){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(customer);
		transaction.commit();
		session.close();
	}
	public void updatCustomer(Customer customer){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(customer);
		transaction.commit();
		session.close();
	}
	public Customer verifyCustomer(Customer customer){
		Session session=sessionFactory.openSession();
		Customer customer1=session.get(Customer.class, customer.getEmail());
		if(customer1==null){
			return null;
		}else{
			if(customer.getPassword().equals(customer1.getPassword())){
				return customer1;
			}else{
				return null;
			}
		}
	}
	
}
