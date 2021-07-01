package dao;

import java.util.List;

import logic.ShortBoard;

public interface ShortBoardDao {
	public List<ShortBoard> getShortBoard(Integer pId);
	public int getTotalShortBoard();
	public int insertShortBoard(ShortBoard shortBoard);
	public int updateShortBoard(ShortBoard shortBoard);
	public int deleteShortBoard(Integer sbId);
}
