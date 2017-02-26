package com.app.beans;

public class ConfirmCabRQ {
	private Long rideId;
	private Long captainId;
	private boolean status;

	public Long getRideId() {
		return rideId;
	}

	public void setRideId(Long rideId) {
		this.rideId = rideId;
	}

	public Long getCaptainId() {
		return captainId;
	}

	public void setCaptainId(Long captainId) {
		this.captainId = captainId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ConfirmCabRQ [rideId=" + rideId + ", captainId=" + captainId + ", status=" + status + "]";
	}

}
