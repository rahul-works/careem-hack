package com.app.dao;


import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.app.entity.db1.CaptainRides;

@Repository
public class CaptianRidesDaoImpl implements CaptainRidesDao {

	@Autowired
	@Qualifier("db1SessionFactory")
	SessionFactory db1SessionFactory;


	@Override
	public CaptainRides bookARide(CaptainRides captainRides) {
		Session session = db1SessionFactory.getCurrentSession();
		session.save(captainRides);
		return captainRides;
		
	}

	@Override
	public boolean confirmRide(Long rideId, boolean status) {
		Session session = db1SessionFactory.getCurrentSession();
		String hql = "update CaptainRides set status = :status where rideId =:rideId";
		
		Query query = session.createQuery(hql);
		query.setLong("rideId", rideId);
		query.setBoolean("status", status);
		
		query.executeUpdate();
		return true;

	}

	@Override
	public boolean startARide(Long rideId, Date pickupTime) {
		Session session = db1SessionFactory.getCurrentSession();
		String hql = "update CaptainRides set pickupTime = :pickupTime where rideId =:rideId";
		
		Query query = session.createQuery(hql);
		query.setLong("rideId", rideId);
		query.setDate("pickupTime", pickupTime);
		
		int n = query.executeUpdate();
		if (n >0) return true;
		else return false;
	}

}
