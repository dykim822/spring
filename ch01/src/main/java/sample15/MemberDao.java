package sample15;

import java.util.Collection;

//MemberDao interface를 실행하기 위한 클래스 생성 필요
// MemberDaoImpl에서 구현
public interface MemberDao {

	Member select(String id);
	int insert(Member member);
	Collection<Member> list();
	int update(Member member);
	int delete(String id);
}
