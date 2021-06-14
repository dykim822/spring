package sample04;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

	public Product getProduct(String name) {
		return new Product(name, 2000);
	}

}
