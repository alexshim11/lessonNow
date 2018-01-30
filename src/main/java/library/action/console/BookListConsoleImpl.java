package library.action.console;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.action.BaseAction;
import library.bean.Book;
import library.dao.BookDao;
import library.dao.db.BookDaoMySQLImpl;
import library.dao.file.simple.SimpleBookDaoImpl;

public class BookListConsoleImpl implements BaseAction{
	
	//private BookDao dao = new SimpleBookDaoImpl();
	
	private BookDao dao = new BookDaoMySQLImpl();


	@Override
	public void doSmth(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List <Book> books = dao.readAll();
		
		if(books != null){
		for (Book book : books){
			response.getWriter().println(book);
		}
		}else{
			System.out.println("Library is empty");
		}
	}

}
