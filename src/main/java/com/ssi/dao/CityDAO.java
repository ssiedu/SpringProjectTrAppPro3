package com.ssi.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entities.City;

@Component
public class CityDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void saveCity(City city) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(city);
		tr.commit();
		session.close();
	}

	public List<String> getAllCityNames() {
		Session session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(City.class);
		List<City> cities = cr.list();
		List<String> citynames = new ArrayList<String>();
		for (City city : cities) {
			citynames.add(city.getCityname());
		}
		session.close();
		return citynames;
	}

	public Set<String> getAllStateNames() {
		Session session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(City.class);
		List<City> cities = cr.list();
		Set<String> statenames=new HashSet<String>();
		for (City city : cities) {
			statenames.add(city.getState());
		}
		session.close();
		return statenames;
	}
}
