package library.controller;

import library.action.BaseAction;
import library.action.util.ActionManager;

public class ConsoleMainController {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		BaseAction action = ActionManager.defineAction(1);
	//	action.doSmth();

	}

}
