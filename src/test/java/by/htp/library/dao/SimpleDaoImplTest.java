package by.htp.library.dao;

import library.dao.BookDao;
import library.dao.db.BookDaoMySQLImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleDaoImplTest {
	
	private BookDao dao = null;
	
	@Before
	public void initData(){

		dao = new BookDaoMySQLImpl();
		//dao = new SimpleBookDaoImpl();
	}
	
	@Test
	public void testReadAllNotNull(){
		Assert.assertNotNull(dao);
		Assert.assertNotNull(dao.readAll());
		
	}

}
	

