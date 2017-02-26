package com.app.beans;

public class BookCabRQ {
	private Long userId;
	private float lat;
	private float lng;
	private Long userMobileNumber;
	private Long captainId;
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(Long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	public Long getCaptainId() {
		return captainId;
	}

	public void setCaptainId(Long captainId) {
		this.captainId = captainId;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "BookCabRQ [userId=" + userId + ", userMobileNumber=" + userMobileNumber + ", captainId=" + captainId
				+ ", lat=" + lat + ", lng=" + lng + "]";
	}

}
