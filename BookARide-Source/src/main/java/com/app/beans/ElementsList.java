package com.app.beans;

import java.util.List;

public class ElementsList {
	private List<DistanceDuration> elements;


	public List<DistanceDuration> getElements() {
		return elements;
	}

	public void setElements(List<DistanceDuration> elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		return "ElementsList [elements=" + elements  + "]";
	}

}
