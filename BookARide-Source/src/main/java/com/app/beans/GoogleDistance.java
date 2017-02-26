package com.app.beans;

public class GoogleDistance {

	private String text;// "0,9 km"
	private float value;// 913

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "GoogleDistance [text=" + text + ", value=" + value + ", getText()=" + getText() + ", getValue()="
				+ getValue() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
