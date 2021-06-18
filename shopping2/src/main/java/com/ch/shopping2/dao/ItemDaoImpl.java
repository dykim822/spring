package com.ch.shopping2.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ch.shopping2.model.Item;
@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private JdbcTemplate jt;
	@Override
	public List<Item> list() {
		List<Item> list = jt.query("select * from item order by itemId",
				new BeanPropertyRowMapper<Item>(Item.class));
		return list;
	}
	@Override
	public Item select(int itemId) {
		Item item = jt.queryForObject("select * from item where itemId=?",
				new BeanPropertyRowMapper<Item>(Item.class), itemId);
		return item;
	}
}
