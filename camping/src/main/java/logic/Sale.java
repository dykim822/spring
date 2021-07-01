package logic;
import java.sql.Timestamp;
public class Sale  {
		private int saleId;		private String mId;
		private Timestamp updateTime;
		
		public int getSaleId() {
			return saleId;
		}
		public void setSaleId(int saleId) {
			this.saleId = saleId;
		}
		public String getmId() {
			return mId;
		}
		public void setmId(String mId) {
			this.mId = mId;
		}
		public Timestamp getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Timestamp updateTime) {
			this.updateTime = updateTime;
		}		
}