package dao;

import java.util.List;

import logic.Board;

public interface BoardDao {
	
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
	void insert();
}
