package com.wazer;


import com.wazer.controller.Controller;
import com.wazer.controller.ViewController;
import com.wazer.view.PositionView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;


public class WazerMain extends Application{
	private static String[] argsVariable;
	private static Controller controller;

	public static void main(String[] args) {		
		argsVariable = args;
		controller = new Controller();	
		
	}

	public static String[] getArgs() {
		return argsVariable;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new ViewController(primaryStage);
	
	}
	
}
