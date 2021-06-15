package sample05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bd;
	public Book getBook() {
		return bd.getBook("노인과 바다");
	}

}
