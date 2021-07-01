package logic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
@Repository
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<ProductSet> productList = new ArrayList<ProductSet>();
	public List<ProductSet> getProductList() {
		return productList;
	}
	public boolean isEmpty() {
		if (this.productList == null || this.productList.isEmpty()) {
			return true;
		}
		return false;
	}	
	public void push(ProductSet pushedProductSet) {	
		// 추가 상품이 카트에 이미 존재하는지 확인하는 플래그
		boolean productExistInCart = false;
		// 추가된 상품의 상품ID를 취득
		Product pushedProduct = pushedProductSet.getProduct();
		int pushedProductId = pushedProduct.getpId().intValue();
		// 카트의 상품 수만큼 반복 실행
		for (ProductSet cartProductSet : this.productList) {	
			// 카트에 있는 상품의 ID를 취득
			Product cartProduct = cartProductSet.getProduct();
			int cartProductId = cartProduct.getpId().intValue();
			if (cartProductId == pushedProductId) {
				// 동일ID의 상품이 카트에 존재하는 경우, 수량만 가산
				cartProductSet.addQuantity(pushedProductSet.getQuantity());
				// 추가 상품이 카트 안에 이미 존재함
				productExistInCart = true;
				break;
			}
		}
		if (!productExistInCart) {
			// 카트에 동일 상품이 없으므로 추가
			this.productList.add(pushedProductSet);
		}
	}
	public void clearAll() {
		this.productList = new ArrayList<ProductSet>();
	}
}