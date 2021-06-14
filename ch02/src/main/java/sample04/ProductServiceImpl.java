package sample04;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {
	private ProductDao pd;
	@Autowired
	public Product getProduct() {
		return pd.getProduct("볼펜");
	}

}
