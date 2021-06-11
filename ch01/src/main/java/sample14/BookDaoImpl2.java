package sample14;
import org.springframework.stereotype.Repository;

@Repository("bk2")
public class BookDaoImpl2 implements BookDao {
	public Book getBook(int price) {
		return new Book("나의 라임오렌지 나무", price);
	}

}
