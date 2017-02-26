package com.app.beans;

import java.io.Serializable;

import org.json.JSONObject;

import com.app.entity.db1.CaptainUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SearchCabRS implements Serializable{

	private static final long serialVersionUID = 1L;
	private CaptainUpdate captian;
	@JsonIgnore
	private String object;
	private GoogleMatrixDistanceRS googleMatrixDistanceRS;

	public CaptainUpdate getCaptian() {
		return captian;
	}

	public void setCaptian(CaptainUpdate captian) {
		this.captian = captian;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "SearchCabRS [captian=" + captian + ", object=" + object + "]";
	}

	public GoogleMatrixDistanceRS getGoogleMatrixDistanceRS() {
		return googleMatrixDistanceRS;
	}

	public void setGoogleMatrixDistanceRS(GoogleMatrixDistanceRS googleMatrixDistanceRS) {
		this.googleMatrixDistanceRS = googleMatrixDistanceRS;
	}

}
