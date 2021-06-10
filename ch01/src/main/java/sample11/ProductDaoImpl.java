package sample11;

public class ProductDaoImpl implements ProductDao {
	public Product getProduct(String name) {
		return new Product(name, 3000);
	}

}
