package com.app.entity.db1;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.util.EnumUtil.CaptianStatus;

@Entity
@Table(name = "captainUpdate")
public class CaptainUpdate {

	@Id
	@Column(name = "captain_update_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long captainUpdateId;

	@Column(name = "captain_id")
	private Long captainId;

	@Column(name = "captain_lat")
	private float lat;

	@Column(name = "captain_lng")
	private float lng;

	private float distance;

	@Column(name = "etd_min")
	private int etdMin;

	@Column(name = "captain_status", nullable = false, columnDefinition = "varchar(9) default 'UNENROLL'")
	@Enumerated(EnumType.STRING)
	private CaptianStatus captain_status;

	@Column(name = "captain_last_update")
	private Date lastUpdated  = new Date(System.currentTimeMillis());

	public Long getCaptainUpdateId() {
		return captainUpdateId;
	}

	public void setCaptainUpdateId(Long captainUpdateId) {
		this.captainUpdateId = captainUpdateId;
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

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public int getEtdMin() {
		return etdMin;
	}

	public void setEtdMin(int etdMin) {
		this.etdMin = etdMin;
	}

	public CaptianStatus getCaptain_status() {
		return captain_status;
	}

	public void setCaptain_status(CaptianStatus captain_status) {
		this.captain_status = captain_status;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "CaptianUpdate [captainUpdateId=" + captainUpdateId + ", captainId=" + captainId + ", lat=" + lat
				+ ", lng=" + lng + ", distance=" + distance + ", ETDMin=" + etdMin + ", captain_status="
				+ captain_status + ", lastUpdated=" + lastUpdated + "]";
	}

}
