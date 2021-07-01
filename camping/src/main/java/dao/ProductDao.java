package dao;

import java.util.List;

import logic.Product;

public interface ProductDao {
	
	public List<Product> getProductList(int start);
	public List<Product> getProductListbyHit();
	public List<Product> getProductBymdCode(Integer mdCode);
	public Product getProductBypId(Integer pId);
			
	public int insertProduct(Product product);
	public int updateProduct(Product product);
	public int updateNull(Product product);
	
	public int deleteProduct(Integer pId);
	public int getTotalRecordProduct();
	public int hitUpdateProduct(Integer pId);
	public int voteCodeUpdateProduct(Integer pId);
	
	
}
