package com.personal.projects.sortingalgorithms;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.personal.projects.controller.SortingController.*;

public class Test {

	public Task<Void> test() {
		Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
            	for(int i = 0; i < listR.size(); i++) {
        			Rectangle x = (Rectangle) hbox.getChildren().get(i);
        			changeColor(x, Color.RED,5);
        			for(int j = 0; j < listR.size(); j++) {
        				if (i == j) {
        					continue;
        				}
        				Rectangle y = (Rectangle) hbox.getChildren().get(j);
        				changeColor(y, Color.BLUE, 10);
        				changeColor(y, Color.BLACK, 10);
        			}
        			changeColor(x, Color.BLACK, 5);
        		}
                return null;
            }
            
            @Override protected void succeeded() {
                super.succeeded();
                // TODO
            }
            
        };
        
        new Thread(task).start();
        
        return task;
        
    
	}
	
	public void changeColor(Rectangle rect, Color color, long millis) {
		try {
			rect.setFill(color);
        	Thread.sleep(millis);
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
