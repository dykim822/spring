package com.ch.shopping2.dao;
import java.util.List;
import com.ch.shopping2.model.Item;
public interface ItemDao {
	List<Item> list();
	Item select(int itemId);
}
