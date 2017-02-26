package com.app.service;

import com.app.beans.CaptianRS;
import com.app.beans.CaptianStatusRQ;
import com.app.beans.CaptianUpdateRS;
import com.app.beans.ConfirmCabRQ;
import com.app.beans.ConfirmCabRS;
import com.app.beans.StartRideRQ;
import com.app.beans.StartRideRS;
import com.app.entity.db1.Captain;

public interface CaptianService {

	CaptianRS addCaptian(Captain addCaptianRQ);

	CaptianRS updateCaptian(Captain addCaptianRQ);

	CaptianUpdateRS updateCaptianStatus(CaptianStatusRQ captianStatusRQ);

	CaptianRS getCaptian(int captianId);

	ConfirmCabRS confirmRide(ConfirmCabRQ req);

	StartRideRS startARide(StartRideRQ req);

}
