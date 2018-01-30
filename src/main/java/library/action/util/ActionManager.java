package library.action.util;

import library.action.BaseAction;
import library.action.console.AddBookConsoleImpl;
import library.action.console.BookListConsoleImpl;

public class ActionManager {
	
	public static BaseAction defineAction(int action){
		
		BaseAction act = null;
		
		switch(action){
		case 1:
			act = new BookListConsoleImpl();
			break;
		case 2:
			act = new AddBookConsoleImpl();
			break;
		}
		return act;
	}
}
