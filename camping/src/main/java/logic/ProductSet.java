package logic;
import java.io.Serializable;
public class ProductSet implements Serializable {
	private static final long serialVersionUID = 1L;	
	private Product	product;
	private Integer quantity;
	public ProductSet(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	public void addQuantity(Integer addQuantity) {
		int addQuantityInt = addQuantity.intValue();
		int existQuantityInt = getQuantity().intValue();
		setQuantity(new Integer(addQuantityInt + existQuantityInt));
	}
	public void setProduct(Product product) {	
		this.product = product;	
	}
	public Product getProduct() {	return product;	}
	public Integer getQuantity() {	return this.quantity;	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}