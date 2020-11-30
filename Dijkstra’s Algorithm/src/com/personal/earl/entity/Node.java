package com.personal.earl.entity;

import java.util.Objects;

public class Node {
	
	private String nodeName;
	
	public Integer distance;
	
	private Node prevNode;

	// initialize state of node
	public Node(String nodeName) {
		this.nodeName = nodeName;
		this.prevNode = null;
		this.distance = Integer.MAX_VALUE;
	}
	
	public Node(String nodeName, Integer distance) {
		this.nodeName = nodeName;
		this.prevNode = null;
		this.distance = distance;
	}

	public String getNodeName() {
		return nodeName;
	}

	public Node getPrevNode() {
		return prevNode;
	}
	
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
	
	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return nodeName +":"+ distance;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if(!(o instanceof Node)) {
			return false;
		}
		
		Node a = (Node) o;
		return nodeName.equals(a.nodeName) && distance.equals(a.distance) && prevNode.equals(a.prevNode) ;
	}
	
	@Override
	public int hashCode() {
        return Objects.hash(nodeName, distance, prevNode);
    }

}
