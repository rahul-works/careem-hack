package com.app.beans;

public class CaptianStatusRQ {
	private Long captianId;
	private float lat;
	private float lng;
	private int etdMin;

	public Long getCaptianId() {
		return captianId;
	}

	public void setCaptianId(Long captianId) {
		this.captianId = captianId;
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

	public int getEtdMin() {
		return etdMin;
	}

	public void setEtdMin(int etdMin) {
		this.etdMin = etdMin;
	}

	@Override
	public String toString() {
		return "CaptianStatusRQ [captianId=" + captianId + ", lat=" + lat + ", lng=" + lng + ", etdMin=" + etdMin + "]";
	}

}
