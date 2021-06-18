package com.ch.shopping2.service;
import java.util.List;
import com.ch.shopping2.model.Item;
public interface ItemService {
	List<Item> list();
	Item select(int itemId);
}
