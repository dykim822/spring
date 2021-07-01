package dao;
import java.util.List;
import logic.CampSite;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CampSiteDaoImpl implements CampSiteDao {
	@Autowired
	private SqlSession session;	
	public List<CampSite> getCampSiteList(int start) {
		return session.selectList("campSiteList", start);
	}	
	public List<CampSite> getCampStieBylocCode(Integer locCode) {
		return session.selectList("selectCampSitebylocCode", locCode);
	}
	public CampSite getCampSiteBysId(Integer sId) {
		return session.selectOne("selectCampSite", sId);
	}
	public int insertCampSite(CampSite campsite) {
		return session.insert("insertCampSite", campsite);
	}
	public int updateCampSite(CampSite campsite) {
		return session.update("updateCampSite", campsite);
	}
	public int deleteCampSite(Integer sId) {
		return session.delete("deleteCampSite", sId);
	}
	public int getTotalRecordCampSite() {
		return session.selectOne("getTotalCampSite");
	}
	public int getTotalRecordCampSiteBylocCode(Integer locCode) {
		return session.selectOne("getTotalCampSitebylocCode", locCode);
	}
}