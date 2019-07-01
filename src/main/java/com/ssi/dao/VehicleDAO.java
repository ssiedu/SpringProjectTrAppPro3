package com.ssi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entities.Vehicle;

@Component
public class VehicleDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Vehicle getVehicleByRegno(String regno){
		Session session=sessionFactory.openSession();
		Vehicle vehicle=session.get(Vehicle.class, regno);
		session.close();
		return vehicle;
	}
	
	public List<Vehicle> getAllVehicleByTransporter(String email){
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Vehicle.class);
		Criterion crt=Restrictions.eq("transporter.email", email);
		cr.add(crt);
		List<Vehicle> vehicles=cr.list();
		session.close();
		return vehicles;
	}
	public List<Vehicle> getAllVehicle(){
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Vehicle.class);
		List<Vehicle> vehicles=cr.list();
		session.close();
		return vehicles;
	}
	public void saveVehicle(Vehicle vehicle){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(vehicle);
		transaction.commit();
		session.close();
	}
	public void updateVehicle(Vehicle vehicle){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(vehicle);
		transaction.commit();
		session.close();
	}
	
	public Map<String,String> getAllRegnosMap(String email){
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Vehicle.class);
		Criterion crt=Restrictions.eq("transporter.email", email);
		criteria.add(crt);
		List<Vehicle> vlist=criteria.list();
		
		Map<String,String> map=new HashMap<String,String>();
		
		for(Vehicle vehicle:vlist){
			String key=vehicle.getRegno();
			String val=vehicle.getBrand()+"-"+key.substring(key.length()-4, key.length());
			map.put(key, val);
		}
		return map;
	}

	
	public List<String> getAllRegnos(String email){
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Vehicle.class);
		Criterion crt=Restrictions.eq("transporter.email", email);
		criteria.add(crt);
		List<Vehicle> vlist=criteria.list();
		List<String> regnos=new ArrayList<String>();
		for(Vehicle v:vlist){
			regnos.add(v.getRegno());
		}
		return regnos;
	}
}
