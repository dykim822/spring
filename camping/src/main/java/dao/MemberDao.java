package dao;
import java.util.List;
import logic.Member;
public interface MemberDao {	
	public List<Member> getMemberList(int start);
	public Member getMemberBymIdAndPassword(String mId, String password);
	public Member getMember(String mId);
	public String getMid(String mId);
	
	public int createMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String mId);
	
	public int getTotalRecordMember();
	
}
