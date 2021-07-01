package dao;
import java.util.List;
import logic.Loc;
public interface LocDao {
	public String getLocName(Integer locCode);
	public String getPicUrl(Integer locCode);
	public List<Loc> locList();
}
