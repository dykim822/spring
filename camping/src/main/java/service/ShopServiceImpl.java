package service;
import java.util.List;

import logic.Board;
import logic.CampSite;
import logic.Cart;
import logic.Loc;
import logic.Member;
import logic.Product;
import logic.ProductSet;
import logic.Sale;
import logic.SaleLine;
import logic.ShortBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import dao.CampSiteDao;
import dao.LocDao;
import dao.MemberDao;
import dao.ProductDao;
import dao.SaleDao;
import dao.SaleLineDao;
import dao.ShortBoardDao;
@Service
public class ShopServiceImpl implements ShopService{	
	@Autowired
	private ProductDao productDao;	
	@Autowired
	private CampSiteDao campSiteDao;	
	@Autowired
	private MemberDao memberDao;	
	@Autowired
	private BoardDao boardDao;	
	@Autowired
	private LocDao locDao;	
	@Autowired
	private ShortBoardDao shortDao;
	@Autowired
	private SaleDao saleDao;	
	@Autowired
	private SaleLineDao saleLineDao;
	
	//Board
	public List<Board> getBoardList(Board board) {
		return boardDao.getBoardList(board);
	}	
	public List<Board> getBoardBybCode(Board board) {
		return boardDao.getBoardBybCode(board);
	}
	public List<Board> getBoardByDate() {
		return boardDao.getBoardByDate();
	}
	public Board getBoardBybId(Integer bId) {
		return boardDao.getBoardBybId(bId);
	}
	public int insertBoard(Board board) {
		return boardDao.insertBoard(board);
	}
	public int updateBoard(Board board) {
		return boardDao.updateBoard(board);
	}
	public int deleteBoard(Integer bId) {
		return boardDao.deleteBoard(bId);
	}
	public int getTotalRecordBoard(Board board) {
		return boardDao.getTotalRecordBoard(board);
	}
	public int hitUpdateBoard(Integer bId) {
		return boardDao.hitUpdateBoard(bId);
	}
	public int totalBoardBybCode(Board board) {
		return boardDao.totalBoardBybCode(board);
	}
	//ProductImpl
	public List<Product> getProductList(int start) {
		return productDao.getProductList(start);
	}
	public List<Product> getProductListbyHit() {
		return productDao.getProductListbyHit();
	}
	public List<Product> getProductBymdCode(Integer mdCode) {
		return productDao.getProductBymdCode(mdCode);
	}
	public Product getProductBypId(Integer pId) {
		return productDao.getProductBypId(pId);
	}
	public int insertProduct(Product product) {
		return productDao.insertProduct(product);
	}
	public int updateProduct(Product product) {
		return productDao.updateProduct(product);
	}
	public int updateNull(Product product) {
		return productDao.updateNull(product);
	}
	public int deleteProduct(Integer pId) {
		return productDao.deleteProduct(pId);
	}
	public int getTotalRecordProduct() {
		return productDao.getTotalRecordProduct();
	}
	public int hitUpdateProduct(Integer pId) {
		return productDao.hitUpdateProduct(pId);
	}
	public int voteCodeUpdateProduct(Integer pId) {
		return productDao.voteCodeUpdateProduct(pId);
	}
	
	//campSiteImpl
	public List<CampSite> getCampSiteList(int start) {
		return campSiteDao.getCampSiteList(start);
	}
	public List<CampSite> getCampStieBylocCode(Integer locCode) {
		return campSiteDao.getCampStieBylocCode(locCode);
	}
	public CampSite getCampSiteBysId(Integer sId) {
		return campSiteDao.getCampSiteBysId(sId);
	}
	public int insertCampSite(CampSite campsite) {
		return campSiteDao.insertCampSite(campsite);
	}
	public int updateCampSite(CampSite campsite) {
		return campSiteDao.updateCampSite(campsite);
	}
	public int deleteCampSite(Integer sId) {
		return campSiteDao.deleteCampSite(sId);
	}

	public int getTotalRecordCampSite() {
		return campSiteDao.getTotalRecordCampSite();
	}
	public int getTotalRecordCampSiteBylocCode(Integer locCode) {
		return campSiteDao.getTotalRecordCampSiteBylocCode(locCode);
	}
	
	//MemberImpl
	public List<Member> getMemberList(int start) {
		return memberDao.getMemberList(start);
	}
	public Member getMemberBymIdAndPassword(String mId, String password) {
		return memberDao.getMemberBymIdAndPassword(mId, password);
	}
	public int createMember(Member member) {
		return memberDao.createMember(member);
	}
	public int updateMember(Member member) {
		return memberDao.updateMember(member);
	}
	public int deleteMember(String mId) {
		return memberDao.deleteMember(mId);
	}
	public String getMid(String mId) {
		return memberDao.getMid(mId);
	}
	public int getTotalRecordMember() {
		return memberDao.getTotalRecordMember();
	}
	public Member getMember(String mId) {
		return memberDao.getMember(mId);
	}
	
	//loc
	public String getLocName(Integer locCode) {
		return locDao.getLocName(locCode);
	}
	public String getPicUrl(Integer locCode) {
		return locDao.getPicUrl(locCode);
	}
	public List<Loc> locList() {
		return locDao.locList();
	}
	
	//CartService
	public Cart getCart() {
		return new Cart();
	}
	public Integer calculateTotalAmount(List<ProductSet> productList) {
		int totalAmount = 0;
		for (ProductSet productSet : productList) {
			int price = productSet.getProduct().getPrice().intValue();
			int quantity = productSet.getQuantity().intValue();
			totalAmount = totalAmount + (price * quantity);
		}
		return new Integer(totalAmount);
	}	
	//ShortBoard
	public List<ShortBoard> getShortBoard(Integer pId) {
		return shortDao.getShortBoard(pId);
	}
	public int getTotalShortBoard() {
		return shortDao.getTotalShortBoard();
	}
	public int insertShortBoard(ShortBoard shortBoard) {
		return shortDao.insertShortBoard(shortBoard);
	}
	public int updateShortBoard(ShortBoard shortBoard) {
		return shortDao.updateShortBoard(shortBoard);
	}
	public int deleteShortBoard(Integer sbId) {
		return shortDao.deleteShortBoard(sbId);
	}
	public void insert() {
		boardDao.insert();
	}
	
	// Sale
	public void insertSale(Member member) {
		// System.out.println("mId = "+member.getmId());
		saleDao.createSale(member.getmId());
	}
	public int selectMaxSale() {
		return saleDao.findMaxSaleId();
	}
	public void insertSaleLine(Cart cart) {
		int saleId = selectMaxSale();
		List<ProductSet> productList = cart.getProductList();
		for (ProductSet ps : productList) {
			SaleLine sl = new SaleLine();
			sl.setSaleId(saleId);
			int pId = ps.getProduct().getpId();
			int qty = ps.getQuantity();
			sl.setpId(pId);
			sl.setQuantity(qty);
			saleLineDao.create(sl);
			Product product = productDao.getProductBypId(pId);
			product.setQuantity(product.getQuantity() - qty);
			productDao.updateProduct(product);
		}
	}	
}