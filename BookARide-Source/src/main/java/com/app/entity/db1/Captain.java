package com.app.entity.db1;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "captain")
public class Captain {

	@Id
	@Column(name = "captian_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int captianId;

	@Column(name = "captian_name")
	private String captianName;

	@Column(name = "captian_address")
	private String captianAddress;

	@Column(name = "captian_city")
	private String captianCity;

	@Column(name = "last_update")
	private Date lastUpdated = new Date(System.currentTimeMillis());

	public int getCaptianId() {
		return captianId;
	}

	public void setCaptianId(int captianId) {
		this.captianId = captianId;
	}

	public String getCaptianName() {
		return captianName;
	}

	public void setCaptianName(String captianName) {
		this.captianName = captianName;
	}

	public String getCaptianAddress() {
		return captianAddress;
	}

	public void setCaptianAddress(String captianAddress) {
		this.captianAddress = captianAddress;
	}

	public String getCaptianCity() {
		return captianCity;
	}

	public void setCaptianCity(String captianCity) {
		this.captianCity = captianCity;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "Captian [captianId=" + captianId + ", captianName=" + captianName + ", captianAddress=" + captianAddress
				+ ", captianCity=" + captianCity + ", lastUpdated=" + lastUpdated + "]";
	}

}
