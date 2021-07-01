package controllers;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.Cart;
import logic.Member;
import logic.PagingBean;
import logic.Product;
import logic.ShortBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ShopService;
import utils.WebConstants;
import exception.CartEmptyException;
@Controller
public class ProductController {	
	@Autowired
	private ShopService shopService;	
	//ADMIN
	@RequestMapping(value="proList")
	public String proList(Model model, HttpServletRequest request, HttpSession session, String currentPage){			
		int total = shopService.getTotalRecordProduct();
		int start = 1;		
		if (currentPage != null && !currentPage.equals(""))
			start = Integer.parseInt(currentPage);
		List<Product> productList = shopService.getProductList(start);
		PagingBean pb = new PagingBean(request, total);
		model.addAttribute("productList", productList);
		model.addAttribute("pb", pb);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "admin/product/proList";	
	}	
	@RequestMapping(value="proDetail")
	public String proDetail(Integer pId, Model model, HttpSession session){
		Product product = shopService.getProductBypId(pId);
		model.addAttribute("product", product);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "admin/product/proDetail";
	}	
	
	@RequestMapping(value={"proReg"}, method=RequestMethod.GET)
	public String proReg(Model model, HttpSession session){
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "admin/product/proReg";
	}	
	@RequestMapping(value="proReg", method=RequestMethod.POST)
	public String proReg(Product product, HttpServletRequest request) throws IOException{	
		
		if(!product.getFile1().isEmpty()){		
			String fname = product.getFile1().getOriginalFilename();			
			String path = request.getSession().getServletContext().getRealPath("/admin/upload");
			String fpath = path + "\\" + fname;
			
			FileOutputStream fs = new FileOutputStream(fpath);
			fs.write(product.getFile1().getBytes());
			fs.close();
			
			product.setPicUrl(fname);
		} 
		shopService.insertProduct(product);	
		// redirect 또는 forward는 jsp가 아니라 콘트롤러에 있는 다른 mapping호출
		return "redirect:proList.html";
	}	
	@RequestMapping(value={"proEdit"}, method=RequestMethod.GET)
	public String proEdit(Integer pId, Model model, HttpSession session){
		Product product = shopService.getProductBypId(pId);
		model.addAttribute("product", product);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "admin/product/proEdit";
	}	
	@RequestMapping(value={"proEdit"}, method=RequestMethod.POST)
	public String proEdit(Product product, HttpServletRequest request) throws IOException{	
		if(!product.getFile1().isEmpty()){		
			String fname = product.getFile1().getOriginalFilename();			
			String path = request.getSession().getServletContext().getRealPath("/admin/upload");
			String fpath = path + "\\" + fname;
			
			FileOutputStream fs = new FileOutputStream(fpath);
			fs.write(product.getFile1().getBytes());
			fs.close();
			
			product.setPicUrl(fname);				
		}	
		shopService.updateProduct(product);			
		return "redirect:proList.html";
	}	
	@RequestMapping(value="proDelete")
	public String proDelete(Integer pId){		
		shopService.deleteProduct(pId);
		return "redirect:proList.html";
	}	
	//CUSTOMER
	@RequestMapping(value="productList")
	public String productList(Model model, HttpServletRequest request, HttpSession session, String currentPage){
		int total = shopService.getTotalRecordProduct();
		int mdCode = 1;
		int start = 1;		
		if (currentPage != null && !currentPage.equals(""))
			start = Integer.parseInt(currentPage);
		List<Product> productList = shopService.getProductList(start);
		List<Product> productListBymdCode = shopService.getProductBymdCode(mdCode);
		PagingBean pb = new PagingBean(request, total);
		model.addAttribute("productList", productList);
		model.addAttribute("productListBymdCode", productListBymdCode);
		model.addAttribute("pb", pb);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "product/productList";
	}	
	@RequestMapping(value="productDetail")
	public String productDetail(Integer pId, Model model, HttpSession session){
		Product product = shopService.getProductBypId(pId);
		shopService.hitUpdateProduct(pId);
		List<ShortBoard> sBoard = shopService.getShortBoard(pId);
		model.addAttribute("sBoard", sBoard);
		model.addAttribute("product", product);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "product/productDetail";
	}	
	@RequestMapping(value="shortBoard")
	public String shortProduct(Integer pId, Model model, ShortBoard shortBoard, HttpSession session){
		shopService.insertShortBoard(shortBoard);
		Product product = shopService.getProductBypId(pId);		
		List<ShortBoard> sBoard = shopService.getShortBoard(pId);		
		model.addAttribute("product", product);
		model.addAttribute("sBoard", sBoard);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "product/productDetail";
	}	
	@RequestMapping(value="checkproduct")
	public String checkItem(Model model, HttpServletRequest request,HttpSession session){
		Enumeration<String> checkedProduct = request.getParameterNames();
		String[] paramName = new String[2];
		int i =0;
		while(checkedProduct.hasMoreElements()){
			paramName[i] = checkedProduct.nextElement();
		//	System.out.println("paramName" + i + " : " + paramName[i]);
			i++;
		}
		Integer Id1 = Integer.parseInt(paramName[0]);
		Integer Id2 = Integer.parseInt(paramName[1]);
		Product checkItem1 = shopService.getProductBypId(Id1);
		Product checkItem2 = shopService.getProductBypId(Id2);
		model.addAttribute("checkItem1", checkItem1);
		model.addAttribute("checkItem2", checkItem2);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "product/checkproduct";
	}	
	@RequestMapping(value="end")
	public String end(Model model, HttpSession session){
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if (cart == null || cart.isEmpty()) {
			System.out.println("카트가 비워있습니다.");
		}
		// shopService.sal(sale,saleLine);		
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		shopService.insertSale(loginUser);
		shopService.insertSaleLine(cart);
		cart.clearAll();
		if (loginUser != null) {
			model.addAttribute("loginUser", loginUser);
		}
		return "cart/end";
	}	
}