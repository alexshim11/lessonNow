package library.dao.file.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import library.bean.Author;
import library.bean.Book;
import library.dao.BookDao;

public class SimpleBookDaoImpl implements BookDao {

	@Override
	public void create(Book t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Book t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Book t) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public List<Book> readAll() {
//		List<Book> books = new ArrayList<>();
//		
//		books.add(new Book(1, "Book1", null));
//		books.add(new Book(2, "Book2", null));
//		books.add(new Book(3, "Book3", null));
//		
//		return books;
//	}
	
	@Override
	public List<Book> readAll() {
		
		List<Book> books = new ArrayList<>();
		
//		books.add(new Book(1, "Book1", null));
//		books.add(new Book(2, "Book2", null));
//		books.add(new Book(3, "Book3", null));

		List<String> fileData = new ArrayList<>();	
		
		String dataLine = null;
		InputStream booksArr = getClass().getResourceAsStream("/Books.txt");
		
		try(BufferedReader booksFilePath = new BufferedReader(new InputStreamReader(booksArr))) {
			while((dataLine = booksFilePath.readLine()) != null) {
				fileData.add(dataLine.trim());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		for (String info : fileData) {
			Book book = new Book();
			String[] bookInfo = info.split(", ");
			book.setId(Integer.parseInt(bookInfo[0]));
			book.setTitle(bookInfo[1]);
			book.setAuthor(new Author(bookInfo[2], bookInfo[3], new Date()));
			books.add(book);
		}
		
		return books;
	}
	
	

}
