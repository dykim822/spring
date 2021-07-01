package dao;

import java.util.List;

import logic.CampSite;

public interface CampSiteDao {
	
	public List<CampSite> getCampSiteList(int start);
	public List<CampSite> getCampStieBylocCode(Integer locCode);
	
	public CampSite getCampSiteBysId(Integer sId);	
	public int insertCampSite(CampSite campsite);
	public int updateCampSite(CampSite campsite);
	public int deleteCampSite(Integer sId);
	public int getTotalRecordCampSite();
	public int getTotalRecordCampSiteBylocCode(Integer locCode);

}
