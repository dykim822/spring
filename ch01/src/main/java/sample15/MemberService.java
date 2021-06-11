package sample15;

import java.util.Collection;

public interface MemberService {

	int insert(Member member);
	Member select(String string);
	Collection<Member> list();
	int update(Member member);
	int delete(String string);

}
