package com.personal.projects.sortingalgorithms;

import static com.personal.projects.controller.SortingController.hbox;
import static com.personal.projects.controller.SortingController.listR;
import static com.personal.projects.controller.SortingController.primaryCtr;
import static com.personal.projects.controller.SortingController.timemillis;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class BubbleSortImpl extends AbstractSort {
	boolean hadSwap;
	
	Timeline timeline;
	@Override
	public void sort() {

		primaryCtr = 0;        
		
		timeline = new Timeline(new KeyFrame(Duration.millis(timemillis), new EventHandler<ActionEvent>() {   
			
			
			@Override
		    public void handle(ActionEvent event) {
				hadSwap = false;
		    	for (int i = 0; i < listR.size() - primaryCtr -1; i++) {
		    		Rectangle current = (Rectangle) hbox.getChildren().get(i);
					animateCurrentIndex(i, timemillis/(listR.size()-primaryCtr-1), Color.RED);
		    		Rectangle toCompare = (Rectangle) hbox.getChildren().get(i+1);
		    		animateCurrentIndex(i+1, timemillis/(listR.size()-primaryCtr-1), Color.BLUE);
		    		if(current.getHeight() > toCompare.getHeight()) {
		    			swap(i,i+1, timemillis/(listR.size()-primaryCtr-1));
		    			hadSwap = true;
		    		}
		    	}
		    	
		    	if(hadSwap == false) {
		    		// forcefully interupt, means already sorted
		    		stopExecution();
		    	}
		    	
				primaryCtr++;
		    }
		}));
		
		timeline.setCycleCount(listR.size());
		timeline.play();
		
	}
	
	public void stopExecution() {
		timeline.stop();
	}
	
	

}
