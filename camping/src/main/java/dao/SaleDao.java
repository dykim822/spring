package dao;

import logic.Sale;

public interface SaleDao {
	
	public void createSale(String mId);
	public Integer findMaxSaleId();
}
