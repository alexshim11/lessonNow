package library.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseAction {
	
	void doSmth(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
