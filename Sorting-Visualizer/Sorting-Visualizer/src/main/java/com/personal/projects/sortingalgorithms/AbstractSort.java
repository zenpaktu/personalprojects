package com.personal.projects.sortingalgorithms;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static com.personal.projects.controller.SortingController.hbox;

public abstract class AbstractSort {
	
	public abstract void sort();
	
	public void swap(int fromIndex, int toIndex, double time) {
		Node temp = new Rectangle(5, ((Rectangle)hbox.getChildren().get(toIndex)).getHeight());
        Node temp2 = (Rectangle)hbox.getChildren().get(fromIndex);
        hbox.getChildren().set(fromIndex, temp);
        hbox.getChildren().set(toIndex, temp2);
        
        FillTransition fromNode = new FillTransition(Duration.millis(time), (Rectangle)hbox.getChildren().get(fromIndex));
        fromNode.setFromValue(Color.RED);
        fromNode.setToValue(Color.BLACK);
        fromNode.setCycleCount(1);
        fromNode.setAutoReverse(false); 
        
        FillTransition toNode = new FillTransition(Duration.millis(time), (Rectangle)hbox.getChildren().get(toIndex));
        toNode.setFromValue(Color.BLACK);
        toNode.setToValue(Color.RED);
        toNode.setCycleCount(1);
        toNode.setAutoReverse(false); 
         
        ParallelTransition parTransition = new ParallelTransition();
        parTransition.getChildren().addAll(fromNode, toNode);
        parTransition.setCycleCount(1);
        parTransition.play(); 
	}
	
	public static void animateCurrentIndexByTimeline(int index, double time, Color color) {
    	Rectangle toCompare = (Rectangle) hbox.getChildren().get(index);
		FillTransition fillTransition = new FillTransition(Duration.millis(time), 
				toCompare);
        fillTransition.setFromValue(Color.BLACK);
        fillTransition.setToValue(color);
        fillTransition.setCycleCount(2);
        fillTransition.setAutoReverse(true);
        fillTransition.play(); 
    }
	
	public static void animateCurrentIndexByThreadSleep(Rectangle rect, long time, Color color) { 
			try {
				rect.setFill(color);
	        	Thread.sleep(time);
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
