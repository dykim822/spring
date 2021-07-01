package dao;
import java.util.Date;
import java.util.List;

import logic.Board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository 
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSession session;	
	public List<Board> getBoardList(Board board) {
		return session.selectList("Boardlist", board);
	}
	public List<Board> getBoardBybCode(Board board) {
		return session.selectList("selectBoardBybCode", board);
	}
	public List<Board> getBoardByDate() {
		return session.selectList("selectBoardByDate");
	}
	public Board getBoardBybId(Integer bId) {
		return session.selectOne("selectBoard", bId);
	}
	public int insertBoard(Board board) {
		return session.insert("insertBoard", board);
	}
	public int updateBoard(Board board) {
		return session.update("updateBoard", board);
	}
	public int deleteBoard(Integer bId) {
		return session.delete("deleteBoard", bId);
	}
	public int getTotalRecordBoard(Board board) {
		return session.selectOne("getTotalBoard", board);
	}
	public int hitUpdateBoard(Integer bId) {
		return session.update("hitUpdateBoard", bId);
	}
	public int totalBoardBybCode(Board board) {
		return session.selectOne("totalBoardBybCode", board);
	}

	public void insert() {
		Board board = new Board();
		for (int i = 1 ; i <= 35; i++) {
			board.setWriter("길동"+i);
			board.setTitle("졸리다"+i);
			board.setContent("왜불러 " + i);
			board.setbCode("free");
			session.insert("insertBoard", board);
			board.setbCode("tip");
			session.insert("insertBoard", board);
			board.setbCode("question");
			session.insert("insertBoard", board);
			board.setbCode("review");
			session.insert("insertBoard", board);
		}		
	}
}