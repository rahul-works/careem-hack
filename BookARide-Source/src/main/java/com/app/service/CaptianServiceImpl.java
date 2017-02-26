package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.beans.CaptianRS;
import com.app.beans.CaptianStatusRQ;
import com.app.beans.CaptianUpdateRS;
import com.app.beans.ConfirmCabRQ;
import com.app.beans.ConfirmCabRS;
import com.app.beans.StartRideRQ;
import com.app.beans.StartRideRS;
import com.app.dao.CaptainRidesDao;
import com.app.dao.CaptianDao;
import com.app.entity.db1.Captain;
import com.app.entity.db1.CaptainRides;
import com.app.entity.db1.CaptainUpdate;

@Service
public class CaptianServiceImpl implements CaptianService {

	@Autowired
	CaptianDao captianDao;
	
	@Autowired
	CaptainRidesDao captainRidesDao;

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db1SessionFactory")
	public CaptianRS addCaptian(Captain addCaptianRQ) {
		Captain resp = captianDao.addCaptian(addCaptianRQ);
		CaptianRS response = new CaptianRS();
		response.setCaptian(resp);
		response.setStatusCode(200);
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db1SessionFactory")
	public CaptianRS updateCaptian(Captain addCaptianRQ) {
		Captain resp = captianDao.updateCaptian(addCaptianRQ);
		CaptianRS response = new CaptianRS();
		response.setCaptian(resp);
		response.setStatusCode(200);
		
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db1SessionFactory")
	public CaptianUpdateRS updateCaptianStatus(CaptianStatusRQ captianStatusRQ) {
		CaptainUpdate captianUpdate =new CaptainUpdate();
		captianUpdate.setCaptainId(captianStatusRQ.getCaptianId());
		captianUpdate.setLat(captianStatusRQ.getLat());
		captianUpdate.setLng(captianStatusRQ.getLng());
		captianUpdate.setEtdMin(captianStatusRQ.getEtdMin());
		CaptainUpdate resp = captianDao.updateCaptianStatus(captianUpdate);
		CaptianUpdateRS response = new CaptianUpdateRS();
		
		response.setCaptianUpdate(resp);
		response.setStatusCode(200);
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db1SessionFactory")
	public CaptianRS getCaptian(int captianId) {
		Captain resp = captianDao.getCaptian(captianId);
		CaptianRS response = new CaptianRS();
		response.setCaptian(resp);
		response.setStatusCode(200);
		
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db1SessionFactory")
	public ConfirmCabRS confirmRide(ConfirmCabRQ req) {
		
		boolean isConfirm = captainRidesDao.confirmRide(req.getRideId(), req.isStatus());
		if(isConfirm && !req.isStatus()) {
			//Send Notification to user for unsucessfull booking
		}
		else if(isConfirm && req.isStatus()) {
			//Send Notificatio to user for confirmation booking
		}
		ConfirmCabRS resp = new ConfirmCabRS();
		resp.setStatus(isConfirm);
		resp.setStatusCode(200);
		return resp;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db1SessionFactory")
	public StartRideRS startARide(StartRideRQ req) {
		CaptainRides captainRides = new CaptainRides();
		boolean status = captainRidesDao.startARide(req.getRideId(), req.getPickupTime());
		
		StartRideRS resp = new StartRideRS();
		resp.setStatus(status);
		resp.setStatusCode(200);
		return resp;
	}

}
