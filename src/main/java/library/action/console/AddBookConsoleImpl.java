package library.action.console;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.action.BaseAction;
import library.bean.Author;
import library.bean.Book;
import library.dao.BookDao;
import library.dao.db.BookDaoMySQLImpl;

public class AddBookConsoleImpl implements BaseAction {
	
	private BookDao dao = new BookDaoMySQLImpl();

	@Override
	public void doSmth(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String year = request.getParameter("year");
		
		int authorId = Integer.parseInt(author);
		
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(new Author(authorId));
		
		//setyear
		
		dao.create(book);
		

	}

}
