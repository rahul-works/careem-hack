package com.app.beans;

import java.util.Date;

public class StartRideRQ {

	private Long rideId;
	private Long pickupTime;

	public Long getRideId() {
		return rideId;
	}

	public void setRideId(Long rideId) {
		this.rideId = rideId;
	}

	public Date getPickupTime() {
		return new Date(pickupTime);

	}

	public void setPickupTime(Long pickupTime) {
		this.pickupTime = pickupTime;
	}

	@Override
	public String toString() {
		return "StartRideRQ [rideId=" + rideId + ", pickupTime=" + pickupTime + "]";
	}

}
