package logic;
import java.sql.Timestamp;
public class SaleLine {
	private int saleId;			private int saleLineId;
	private int pId;			private int quantity;
	private Timestamp updateTime;
	
	public int getSaleId() {	return saleId;	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public int getSaleLineId() {		return saleLineId;	}
	public void setSaleLineId(int saleLineId) {
		this.saleLineId = saleLineId;
	}
	public int getpId() {		return pId;	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getQuantity() {		return quantity;	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Timestamp getUpdateTime() {	return updateTime;	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}