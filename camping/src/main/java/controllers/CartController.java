package controllers;
import java.util.List;
import javax.servlet.http.HttpSession;
import logic.Cart;
import logic.Member;
import logic.Product;
import logic.ProductSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import exception.LoginRequiredException;
import service.ShopService;
import utils.WebConstants;
@Controller
public class CartController {
	@Autowired
	private ShopService shopService;
	@RequestMapping(value = "cartAdd")
	public String add(Integer pId, Integer quantity, HttpSession session, Model model) {
		// 추가 상품 정보를 취득
		Product selectedProduct = this.shopService.getProductBypId(pId);
		// 카트를 취득
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if (cart == null) {
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}
		// 카트에 상품을 추가
		cart.push(new ProductSet(selectedProduct, quantity));
		// 카트 정보와 메시지를 설정
		model.addAttribute("message", selectedProduct.getpName() + "을" + quantity + "개 카트에 담았습니다.");
		model.addAttribute("cart", cart);
		// 로그인 유저를 취득
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			model.addAttribute("loginUser", loginUser);
		}
		return "cart/cart" ;
	}
	@RequestMapping(value = "cartClear")
	public String  clear(HttpSession session, Model model) {
		// 카트를 취득
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if (cart == null) {
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}
		// 카트를 클리어
		cart.clearAll();
		model.addAttribute("message", "카트를 비웠습니다.");
		// 로그인 유저를 취득
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			model.addAttribute("loginUser", loginUser);
		}
		return "cart/cart";
	}
	@RequestMapping(value = "cartConfirm")
	public String confirm(HttpSession session, Model model) {
		// 카트를 취득
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if (cart == null) {
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}
		// 카트 정보를 설정
		model.addAttribute("cart", cart);
		// 로그인 유저를 취득
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			model.addAttribute("loginUser", loginUser);
		}
		return "cart/cart";
	}
	@RequestMapping(value = "checkout")
	public String checkOut(HttpSession session, Model model) {
		// 로그인을 확인
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser == null) {
			throw new LoginRequiredException("로그인을 하셔야 합니다.");
		}
		// 카트를 취득
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if (cart == null || cart.isEmpty()) {
			System.out.println("카트가 비워있습니다."); 
		} 
		// 유저 정보와 카트 안의 상품 정보를 설정
		model.addAttribute("loginUser", loginUser);
		List<ProductSet> productList = cart.getProductList();
		model.addAttribute("productList", productList);
		// 합계 금액을 설정
		Integer totalAmount = this.shopService.calculateTotalAmount(productList);
		model.addAttribute("totalAmount", totalAmount);

		return "cart/checkout";
	}
}