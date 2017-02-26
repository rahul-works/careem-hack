package com.app.beans;

public class DistanceDuration {
	private GoogleDistance distance;
	private GoogleDuration duration;
	private String status;

	public GoogleDistance getDistance() {
		return distance;
	}

	public void setDistance(GoogleDistance distance) {
		this.distance = distance;
	}

	public GoogleDuration getDuration() {
		return duration;
	}

	public void setDuration(GoogleDuration duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DistanceDuration [distance=" + distance + ", duration=" + duration + ", status=" + status + "]";
	}

}
