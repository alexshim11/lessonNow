package library.dao.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import library.bean.Book;
import library.dao.BookDao;

public class BookDaoMySQLImpl implements BookDao {

	private static final String SQL_SELECT_BOOKS = "Select*from book";
	private static final String SQL_INSERT_BOOK = "insert into book (title, author, year) values (?, ?, ?)";

	{
		String driver = getConnectInitValues()[3];
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void create(Book entity) {

		if (entity != null) {
			String url = getConnectInitValues()[0];
			String user = getConnectInitValues()[1];
			String pass = getConnectInitValues()[2];
			

			try (Connection cn = DriverManager.getConnection(url, user, pass)) {

				
				PreparedStatement ps = cn.prepareStatement(SQL_INSERT_BOOK);
				
				ps.setString(1, entity.getTitle()); //title
				ps.setInt(2, entity.getAuthor().getId()); //author
				ps.setDate(3, new Date(0)); //year
				
				ps.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

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

	@Override
	public List<Book> readAll() {

		List<Book> list = new ArrayList<>();

		Connection cn = null;

		try {

			String url = getConnectInitValues()[0];
			String user = getConnectInitValues()[1];
			String pass = getConnectInitValues()[2];
	
			cn = DriverManager.getConnection(url, user, pass);
			System.out.println("connected");

			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKS);

			Book book = new Book();

			while (rs.next()) {
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				rs.getInt("authorId");
				// rs.getDate("year");
			}

			list.add(book);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;

	}

	private String[] getConnectInitValues() {

		ResourceBundle rb = ResourceBundle.getBundle("db_config");

		String dbURL = rb.getString("db_url");
		String user = rb.getString("db_login");
		String pass = rb.getString("db_pass");
		String driver = rb.getString("db.driver");

		return new String[] { dbURL, user, pass, driver };
	}
}
