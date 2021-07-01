package dao;
import java.util.List;
import logic.ShortBoard;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ShortBoardDaoImpl implements ShortBoardDao{
	@Autowired
	private SqlSession session;	
	public List<ShortBoard> getShortBoard(Integer pId) {
		return session.selectList("selectShortBoardbypId", pId);
	}
	public int insertShortBoard(ShortBoard shortBoard) {
		return session.insert("insertShortBoard", shortBoard);
	}
	public int updateShortBoard(ShortBoard shortBoard) {
		return session.insert("updateShortBoard", shortBoard);
	}
	public int deleteShortBoard(Integer sbId) {
		return session.insert("deleteShortBoard", sbId);
	}
	public int getTotalShortBoard() {
		return session.insert("getTotalShortBoard");
	}	
}