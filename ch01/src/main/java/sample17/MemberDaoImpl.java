package sample17;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public class MemberDaoImpl implements MemberDao {
	private Map<String, Member> map = new HashMap<String, Member>();
	public Member select(String id) {
		// map에서 id가 같은 데이터 읽기
		return map.get(id);
	}
	public int insert(Member member) {
		map.put(member.getId(), member);
		return 1;
	}
	public Collection<Member> list() {
		return map.values();
	}
	public int update(Member member) {
		map.put(member.getId(), member);
		return 1;
	}
	public int delete(String id) {
		map.remove(id);
		return 1;
	}
}
