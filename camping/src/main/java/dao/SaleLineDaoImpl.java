package dao;
import logic.SaleLine;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class SaleLineDaoImpl implements SaleLineDao{
	@Autowired
	private SqlSession session;		
	public void create(SaleLine saleLine) {
		session.insert("insertSaleLine", saleLine);
	}
}