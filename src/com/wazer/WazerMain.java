package com.wazer;


import com.wazer.controller.Controller;
import com.wazer.controller.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * <h1> WazerMain </h1>
 * Main class. Extends Application.
 * Initiates Controller.
 * @author Beatrice
 *
 */
public class WazerMain extends Application{
	private static boolean isInit = false;
	private static String[] argsVariable;
	private static Stage primaryStageView;

	public static void main(String[] args) {		
		argsVariable = args;
		new Controller();			
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
