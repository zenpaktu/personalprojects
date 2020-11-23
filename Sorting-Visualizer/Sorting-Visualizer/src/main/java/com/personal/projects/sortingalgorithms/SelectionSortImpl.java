package com.personal.projects.sortingalgorithms;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static com.personal.projects.controller.SortingController.*;

public class SelectionSortImpl extends AbstractSort{

	@Override
	public void sort() {
		
		primaryCtr = 0;

        
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(timemillis), new EventHandler<ActionEvent>() {   
			
			
			@Override
		    public void handle(ActionEvent event) {
				Rectangle current = (Rectangle) hbox.getChildren().get(primaryCtr);
				animateCurrentIndex(primaryCtr, timemillis, Color.RED);
		    	double smallestIndex = primaryCtr;
		    	for (int i = primaryCtr+1; i < listR.size(); i++) {
		    		Rectangle toCompare = (Rectangle) hbox.getChildren().get(i);
		    		animateCurrentIndex(i, timemillis/(listR.size()-primaryCtr-1), Color.BLUE);
		    		if(current.getHeight() > toCompare.getHeight()) {
		    			current = toCompare;
		    			smallestIndex = i;
		    		}
		    	}
		    	
		    	if(smallestIndex != primaryCtr) {
		    		swap(primaryCtr,(int)smallestIndex, timemillis);
		    	}
		    	
				primaryCtr++;
		    }
		}));
		timeline.setCycleCount(listR.size()-1);
		timeline.play();
		
	}

}
