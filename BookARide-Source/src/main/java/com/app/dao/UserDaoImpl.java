package com.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.app.beans.SearchCabRQ;
import com.app.entity.db1.CaptainUpdate;
import com.app.entity.db1.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	@Qualifier("db1SessionFactory")
	SessionFactory db1SessionFactory;

	@Autowired
	@Qualifier("db2SessionFactory")
	SessionFactory db2SessionFactory;

	@Override
	public User addUser(User req) {
		Session session = db1SessionFactory.getCurrentSession();
		session.save(req);
		return req;
	}

	@Override
	public User updateUser(User req) {
		Session session = db1SessionFactory.getCurrentSession();
		session.saveOrUpdate(req);
		return req;
	}

	@Override
	public User getUser(Long userId) {
		Session session = db1SessionFactory.getCurrentSession();
		String hql = "from User where userId =:userId";
		Query query = session.createQuery(hql);
		query.setParameter("captianId", userId);

		return (User) query.uniqueResult();
	}

	@Override
	public List<CaptainUpdate> searchCab(SearchCabRQ req) {
		Session session = db1SessionFactory.getCurrentSession();
		String hql ="SELECT captain_update_id, captain_id,captain_status, captain_lng, captain_lat, captain_last_update,etd_min, ( 6371 * acos( cos( radians( :userLat) ) * cos( radians( captain_lat ) ) * cos( radians( captain_lng ) - radians( :userLng) ) + sin( radians( :userLat) ) * sin( radians( captain_lat ) ) ) ) AS distance FROM captainupdate where captain_status=:unenrollstatus or (captain_status=:status  and etd_min <:etdMin) ORDER BY distance LIMIT 0 , 5;";
		SQLQuery query = session.createSQLQuery(hql);
		
		query.addEntity(CaptainUpdate.class);
		query.setParameter("userLat", req.getLat());
		query.setParameter("userLng", req.getLng());
		query.setParameter("unenrollstatus", "UNENROLL");
		query.setParameter("status", "ENROLL");
		query.setParameter("etdMin", 5);
		//query.setMaxResults(5);
		List list = query.list();
		
			
		// TODO Auto-generated method stub
		return list;
	}

}
