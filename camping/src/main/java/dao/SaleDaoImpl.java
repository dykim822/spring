package dao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import logic.Sale;
@Repository
public class SaleDaoImpl implements SaleDao{
	@Autowired
	private SqlSession session;	
	public void createSale(String mId) {
		Sale sale = new Sale();
		sale.setmId(mId);
		session.insert("insertSale", sale);		
	}
	public Integer findMaxSaleId() {
		return  session.selectOne("selectMaxSale");
	}
}