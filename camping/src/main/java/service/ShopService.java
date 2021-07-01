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
public interface ShopService {
	public List<Board> getBoardList(Board board);
	public List<Board> getBoardBybCode(Board board);
	public List<Board> getBoardByDate();
	int totalBoardBybCode(Board board);

	public Board getBoardBybId(Integer bId);
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public int deleteBoard(Integer bId);
	public int getTotalRecordBoard(Board board);
	public int hitUpdateBoard(Integer bId);
	
	//Product
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
	
	//ShortBoard
	public List<ShortBoard> getShortBoard(Integer pId);
	public int getTotalShortBoard();
	public int insertShortBoard(ShortBoard shortBoard);
	public int updateShortBoard(ShortBoard shortBoard);
	public int deleteShortBoard(Integer sbId);
	
	//CampSiteService	
	public List<CampSite> getCampSiteList(int start);
	public List<CampSite> getCampStieBylocCode(Integer locCode);
	public CampSite getCampSiteBysId(Integer sId);	
	public int insertCampSite(CampSite campsite);
	public int updateCampSite(CampSite campsite);
	public int deleteCampSite(Integer sId);
	public int getTotalRecordCampSite();
	public int getTotalRecordCampSiteBylocCode(Integer locCode);
	
	//Member
	public List<Member> getMemberList(int start);
	public Member getMemberBymIdAndPassword(String mId, String password);	
	public Member getMember(String mId);
	public String getMid(String mId);
	public int createMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String mId);	
	public int getTotalRecordMember();
		
	//loc
	public String getLocName(Integer locCode);
	public String getPicUrl(Integer locCode);
	public List<Loc> locList();
	
	//Cart	
	Cart getCart();
	Integer calculateTotalAmount(List<ProductSet> productList);

	// insert;
	void insert();
	
	// Sale
	public void insertSale(Member member); 
	public int selectMaxSale(); 
	public void insertSaleLine(Cart cart);	
		
}