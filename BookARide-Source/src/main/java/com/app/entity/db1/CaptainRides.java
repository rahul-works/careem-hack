package com.app.entity.db1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "captain_rides")
public class CaptainRides {

	@Id
	@Column(name = "ride_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rideId;
	
	@Column(name = "captain_id")
	private Long captainId;

	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "src_lat")
	private float srcLat;

	@Column(name = "src_lng")
	private float srcLng;

	@Column(name = "dst_lat")
	private float dstLat;

	@Column(name = "dst_lng")
	private float dstLng;

	@Column(name = "src_address")
	private String srcAddress;

	@Column(name = "dst_address")
	private String dstAddress;

	@Column(name = "pickup_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date pickupTime ;

	@Column(name = "drop_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dropTime  ;

	@Column(name = "eta")
	@Temporal(TemporalType.TIMESTAMP)
	private Date eta  ;

	@Column(name = "status")
	private boolean status;
	
	public Long getRideId() {
		return rideId;
	}

	public void setRideId(Long rideId) {
		this.rideId = rideId;
	}

	public float getSrcLat() {
		return srcLat;
	}

	public void setSrcLat(float srcLat) {
		this.srcLat = srcLat;
	}

	public float getSrcLng() {
		return srcLng;
	}

	public void setSrcLng(float srcLng) {
		this.srcLng = srcLng;
	}

	public float getDstLat() {
		return dstLat;
	}

	public void setDstLat(float dstLat) {
		this.dstLat = dstLat;
	}

	public float getDstLng() {
		return dstLng;
	}

	public void setDstLng(float dstLng) {
		this.dstLng = dstLng;
	}

	public String getSrcAddress() {
		return srcAddress;
	}

	public void setSrcAddress(String srcAddress) {
		this.srcAddress = srcAddress;
	}

	public String getDstAddress() {
		return dstAddress;
	}

	public void setDstAddress(String dstAddress) {
		this.dstAddress = dstAddress;
	}

	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	public Date getDropTime() {
		return dropTime;
	}

	public void setDropTime(Date dropTime) {
		this.dropTime = dropTime;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	@Override
	public String toString() {
		return "CaptianRides [rideId=" + rideId + ", srcLat=" + srcLat + ", srcLng=" + srcLng + ", dstLat=" + dstLat
				+ ", dstLng=" + dstLng + ", srcAddress=" + srcAddress + ", dstAddress=" + dstAddress + ", pickupTime="
				+ pickupTime + ", dropTime=" + dropTime + ", eta=" + eta + ", getRideId()=" + getRideId()
				+ ", getSrcLat()=" + getSrcLat() + ", getSrcLng()=" + getSrcLng() + ", getDstLat()=" + getDstLat()
				+ ", getDstLng()=" + getDstLng() + ", getSrcAddress()=" + getSrcAddress() + ", getDstAddress()="
				+ getDstAddress() + ", getPickupTime()=" + getPickupTime() + ", getDropTime()=" + getDropTime()
				+ ", getEta()=" + getEta() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Long getCaptainId() {
		return captainId;
	}

	public void setCaptainId(Long captainId) {
		this.captainId = captainId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
