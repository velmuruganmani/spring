package com.vel.springdemo.dao;
/*
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vel.springdemo.entity.Role;

@Repository
@Transactional(value = "myTransactionManagerOracle") 
public class CustomerDAOImplOracle implements CustomerDAOOracle {
	
	@Autowired
	@Qualifier(value="sessionFactoryOracle")
	private SessionFactory sessionFactoryOracle;

	@Override
	public List<Role> getRoles() {		
		System.out.println("getRoles: start");
		
		Session currentSession = sessionFactoryOracle.getCurrentSession();
		System.out.println("currentSession: "+currentSession);
		Query<Role> theQuery = currentSession.createQuery("from Role", Role.class);
		List<Role> roles = theQuery.getResultList();
		
		return roles;
	}

}
*/