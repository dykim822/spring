package dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import logic.Member;
@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSession session;	
	public List<Member> getMemberList(int start) {
		return session.selectList("memberList",start);
	}
	public Member getMemberBymIdAndPassword(String mId, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mId", mId);
		map.put("password", password);
		return session.selectOne("selectMemberBymIdandPassword", map);
	}
	public int createMember(Member member) {
		return session.insert("createMember", member);
	}
	public int updateMember(Member member) {
		return session.update("updateMember", member);
	}
	public int deleteMember(String mId) {
		return session.delete("deleteMember", mId);
	}
	public int getTotalRecordMember() {
		return session.selectOne("getTotalMember");
	}
	public Member getMember(String mId) {
		return session.selectOne("selectMember", mId);
	}
	public String getMid(String mId) {
		return session.selectOne("selectmId", mId);
	}
}