package com.personal.earl.entity;

public class Route {
	private String fromNode;
	private String toNode;
	private Integer distance;
	
	public Route(String fromNode, String toNode, Integer distance) {
		this.fromNode = fromNode;
		this.toNode = toNode;
		this.distance = distance;
	}

	public String getFromNode() {
		return fromNode;
	}

	public String getToNode() {
		return toNode;
	}

	public Integer getDistance() {
		return distance;
	}
}
