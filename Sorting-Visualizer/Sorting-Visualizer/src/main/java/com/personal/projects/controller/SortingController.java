package com.personal.projects.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.personal.projects.sortingalgorithms.AbstractSort;
import com.personal.projects.sortingalgorithms.BubbleSortImpl;
import com.personal.projects.sortingalgorithms.SelectionSortImpl;
import com.personal.projects.sortingalgorithms.Test;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.effect.Glow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SortingController extends Application {
	
	public static List<Rectangle> listR;
	
	// var for time used in millis
	public static int timemillis = 1000;
	
	// timeline counter 
	public static int primaryCtr;
	public static int secondaryCtr;
	
	public static HBox hbox;
	
	public void initialize(Stage stage) {
		listR = IntStream.range(1, 100).boxed().map(height -> new Rectangle(5, height*1, Color.BLACK)).collect(Collectors.toList());
        Collections.shuffle(listR);
        hbox = new HBox();
        hbox.getChildren().addAll(listR);
        hbox.setSpacing(1);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        Scene scene = new Scene(hbox); 

        stage.setScene(scene);
	}
	
    @Override
    public void start(Stage stage) {
        
        initialize(stage);
        
        //  Creating a Scene 
        stage.show();
        
        AbstractSort sortingAlgo = new SelectionSortImpl();
//        AbstractSort sortingAlgo = new BubbleSortImpl();
        sortingAlgo.sort();

    }

    public static void main(String[] args) {
        launch();
    }

}