package com.ch.shopping2.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.shopping2.dao.ItemDao;
import com.ch.shopping2.model.Item;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao id;
	@Override
	public List<Item> list() {
		return id.list();
	}
	@Override
	public Item select(int itemId) {
		return id.select(itemId);
	}
}
