package com.wazer;


import com.wazer.controller.Controller;


public class WazerMain {
	private static String[] argsVariable;

	public static void main(String[] args) {
		new Controller();
		argsVariable = args;
	}

	public static String[] getArgs() {
		return argsVariable;
	}
	
}
