package com.app.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.app.beans.CaptianStatusRQ;
import com.app.entity.db1.Captain;
import com.app.entity.db1.CaptainUpdate;

@Repository
public class CaptianDaoImpl implements CaptianDao {

	@Autowired
	@Qualifier("db1SessionFactory")
	SessionFactory db1SessionFactory;

	@Override
	public Captain addCaptian(Captain addCaptianRQ) {
		Session session = db1SessionFactory.getCurrentSession();
		session.save(addCaptianRQ);
		return addCaptianRQ;
	}

	@Override
	public Captain updateCaptian(Captain addCaptianRQ) {
		Session session = db1SessionFactory.getCurrentSession();
		session.saveOrUpdate(addCaptianRQ);
		return addCaptianRQ;
	}

	@Override
	public CaptainUpdate updateCaptianStatus(CaptainUpdate captianUpdate) {
		Session session = db1SessionFactory.getCurrentSession();
		String hql = "update CaptianUpdate set lat = :userLat, lng =:userLng, etdMin =:etdMin where captianId =:captianId";
		
		Query query = session.createQuery(hql);
		query.setLong("captianId", captianUpdate.getCaptainId());
		query.setFloat("userLat", captianUpdate.getLat());
		query.setFloat("userLng", captianUpdate.getLng());
		query.setInteger("etdMin", captianUpdate.getEtdMin());
		
		query.executeUpdate();
		return captianUpdate;

	}

	@Override
	public Captain getCaptian(int captianId) {
		Session session = db1SessionFactory.getCurrentSession();
		String hql = "from Captian where captianId =:captianId";
		Query query = session.createQuery(hql);
		query.setInteger("captianId", captianId);

		return (Captain) query.uniqueResult();
	}

}
