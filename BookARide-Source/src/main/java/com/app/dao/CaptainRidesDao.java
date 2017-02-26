package com.app.dao;


import java.util.Date;

import com.app.entity.db1.CaptainRides;

public interface CaptainRidesDao {

	CaptainRides bookARide(CaptainRides captainRides);

	boolean confirmRide(Long rideId, boolean status);

	boolean startARide(Long rideId, Date pickupTime);

}
