package sample13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired	// setter method가 필요 없다 // 생성된 객체와 연결
	@Qualifier("pd2")
	private ProductDao pd;
	public Product getProduct() {
		return pd.getProduct("볼펜");
	}

}
