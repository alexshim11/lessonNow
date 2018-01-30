package library.dao;

import java.util.List;

import library.bean.Book;

public interface BookDao extends BaseAction<Book>{

	List<Book> readAll();
}
