package com.wazer;


import com.wazer.controller.Controller;
import com.wazer.controller.ViewController;
import com.wazer.view.PositionView;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;


public class WazerMain extends Application{
	private static boolean isInit = false;
	private static String[] argsVariable;
	private static Controller controller;
	private static Stage primaryStageView;

	public static void main(String[] args) {		
		argsVariable = args;
		controller = new Controller();			
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStageView = primaryStage;
		new ViewController(primaryStage);		
	}
	
	
	public static String[] getArgs() {
		return argsVariable;
	}

	public static boolean getIsInit() {
		return isInit;
	}

	public static void setIsInit(boolean isInit) {
		WazerMain.isInit = isInit;
	}

	public static Stage getPrimaryStageView() {
		return primaryStageView;
	}
	
}
