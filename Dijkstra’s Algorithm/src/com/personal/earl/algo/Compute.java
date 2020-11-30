package com.personal.earl.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import com.personal.earl.entity.Route;
import com.personal.earl.entity.Node;

public class Compute {
	
	//List of All  unique nodes
	HashMap<String, Node> nodes = new HashMap<>();
	//List of All adjacent or directly accessible nodes from a certain node
	HashMap<String, HashSet<Node>> adjacencyList = new HashMap<>();
	// Stores the shortest path of nodes
	ArrayList<String> path = new ArrayList<>();

	public static void main(String args[])  {
		new Compute().execute();
	}
	
	// calculate shortest path
	public void execute() { 
		
		// manually create/input routes or connections of nodes
		Route[] listOfRoutes = {
				new Route("A","B",3),
				new Route("B","E",4),
				new Route("E","G",1),
				new Route("C","E",2),
				new Route("F","G",1),
				new Route("C","F",1),
				new Route("A","C",2)
				};
		
		createGraph(listOfRoutes);
		// set starting and end points
		computePath("A", "G");
	}
	
	public void computePath(String startNode, String endNode) {
		Queue<String> toVisitNodes = new LinkedList<>();
		String currentNodeName = startNode;
		//Set distance of starting node to 0 and previous node as null
		nodes.get(startNode).setDistance(0);
		
		do {
			if(!toVisitNodes.isEmpty())
				currentNodeName = toVisitNodes.poll();
			// traverse all adjacent nodes of current node
			for (Node adjacentEntity : adjacencyList.get(currentNodeName)) {
				
				Node adjacentNode = nodes.get(adjacentEntity.getNodeName());
				
				// check if it is visited == prevnodename is already set
				if (!startNode.equals(adjacentEntity.getNodeName()) && adjacentNode.getPrevNode() == null || (calculateDistance(adjacentNode, false) > (adjacentEntity.getDistance() + calculateDistance(nodes.get(currentNodeName), false)))) {
					//unvisited : set distance of current node from prev node
					if (!adjacentEntity.getNodeName().equals(endNode) && !adjacentEntity.getNodeName().equals(startNode)) {
						toVisitNodes.add(adjacentEntity.getNodeName());
					}
					adjacentEntity.setPrevNode(nodes.get(currentNodeName));
					nodes.put(adjacentEntity.getNodeName(), adjacentEntity);
					
				} else {
					// if visited then compare distance which is shorter
					continue;	
				}
			}
		} while(!toVisitNodes.isEmpty());
		
		Integer shortestDistance = calculateDistance(nodes.get(endNode), true);
		Collections.reverse(path);
		System.out.println("Shortest distance is: "+ shortestDistance + " " + path);
	}
	
	
	// calculate distance of shortest path and store the nodes that are passed by
	public Integer calculateDistance(Node node, boolean forPath) {
		if (forPath)
			path.add(node.getNodeName());
		return (node.getPrevNode() != null ? calculateDistance(node.getPrevNode(), forPath) : 0) + node.getDistance();
	}
	
	public void createGraph(Route[] listOfRoutes) {
		
		for(Route r: listOfRoutes) {
			
			// create node if it isn't created yet
			if(!nodes.containsKey(r.getToNode())) {
				nodes.put(r.getToNode(), new Node(r.getToNode()));
				adjacencyList.put(r.getToNode(), new HashSet<Node>());
			}
			
			if(!nodes.containsKey(r.getFromNode())) {
				nodes.put(r.getFromNode(), new Node(r.getFromNode()));
				adjacencyList.put(r.getFromNode(), new HashSet<Node>());
			}
			
			adjacencyList.get(r.getToNode()).add(new Node(r.getFromNode(),r.getDistance()));
			adjacencyList.get(r.getFromNode()).add(new Node(r.getToNode(),r.getDistance()));
			
			
		}
		
		System.out.println(adjacencyList.toString());
	}

}
