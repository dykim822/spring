package sample05;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	public Book getBook(String title) {
		return new Book(title, 30000);
	}

}
