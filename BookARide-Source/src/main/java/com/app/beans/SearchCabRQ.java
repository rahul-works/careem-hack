package com.app.beans;

public class SearchCabRQ {
	private Long userId;
	private float lat;
	private float lng;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		return "CaptianStatusRQ [captianId=" + userId + ", lat=" + lat + ", lng=" + lng + "]";
	}

}
