package com.ch.shopping1;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.shopping1.dao.ItemDao;
import com.ch.shopping1.model.Item;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao id;
	@Override
	public List<Item> list() {
		return id.list();
	}
}
