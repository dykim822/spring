package dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import logic.Product;
@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SqlSession session;		
	public List<Product> getProductList(int start) {
		return session.selectList("productList", start);
	}
	public List<Product> getProductListbyHit() {
		return session.selectList("productListbyHit");
	}
	public List<Product> getProductBymdCode(Integer mdCode) {
		return session.selectList("selectProductbymdCode", mdCode);
	}
	public Product getProductBypId(Integer pId) {
		return session.selectOne("selectProduct", pId);
	}
	public int insertProduct(Product product) {
		return session.insert("insertProduct", product);
	}
	public int updateProduct(Product product) {
		return session.update("updateProduct", product);
	}	
	public int updateNull(Product product) {
		return session.update("updateNull", product);
	}
	public int deleteProduct(Integer pId) {
		return session.delete("deleteProduct", pId);
	}
	public int getTotalRecordProduct() {
		return session.selectOne("getTotalProduct");
	}
	public int hitUpdateProduct(Integer pId) {
		return session.update("hitUpdateProduct", pId);
	}
	public int voteCodeUpdateProduct(Integer pId) {
		return session.update("voteCodeUpdateProduct", pId);	
	}
}