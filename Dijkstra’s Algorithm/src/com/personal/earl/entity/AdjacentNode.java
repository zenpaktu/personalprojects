package com.personal.earl.entity;

import java.util.Objects;

public class AdjacentNode {
	public Integer distance;
	public String nodeName;
	
	public AdjacentNode(String nodeName, Integer distance) {
		this.distance = distance;
		this.nodeName = nodeName;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}  
	
	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if(!(o instanceof AdjacentNode)) {
			return false;
		}
		
		AdjacentNode a = (AdjacentNode) o;
		return nodeName.equals(a.nodeName) && distance.equals(a.distance);
	}
	
	@Override
	public int hashCode() {
        return Objects.hash(nodeName, distance);
    }
	
	@Override 
	public String toString() {
		return nodeName;
	}

}
