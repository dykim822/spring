package sample12;

public class BookDaoImpl implements BookDao {

	public Book getBook(String title) {
		return new Book(title, 30000);
	}

}
