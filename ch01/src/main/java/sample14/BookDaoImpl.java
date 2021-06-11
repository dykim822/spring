package sample14;
import org.springframework.stereotype.Repository;

@Repository("bk1")
public class BookDaoImpl implements BookDao {
	public Book getBook(int price) {
		return new Book("노인과 바다", price);
	}

}
