package member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md;

	public int insert(Member member) {
		int result = 0;
		// member는 입력한 회원, mem은 조회한 회원
		// 입력하려는 데이터가 존재하는지 확인하여 중복 체크
		Member mem = md.select(member.getId());
		if(mem == null) {
			result = md.insert(member);
		} else {
			System.out.println("이미 존재하는 데이터입니다");
		}
		return result;
	}
	public void select(String id) {
		Member member = md.select(id);
		if(member == null) {
			System.out.println("데이터가 존재하지 않습니다");
		} else {
			print(member);
		}
	}
	private void print(Member member) {
		System.out.println("==========회원 정보==========");
		System.out.println("아이디 : "+member.getId());
		System.out.println("이름 : "+member.getName());
		System.out.println("이메일 : "+member.getEmail());
		System.out.println("등록일 : "+member.getRegdate());
	}
	public void list() {
		List<Member> list = md.list();
		if(list == null || list.size() == 0) {
			System.out.println("데이터가 존재하지 않습니다");
		} else {
			for(Member member:list) {
				print(member);
			}
		}
	}
	public int update(Member member) {
		int result = 0;
		// member는 입력한 회원, mem은 조회한 회원
		// 입력하려는 데이터가 존재하는지 확인하여 중복 체크
		Member mem = md.select(member.getId());
		if(mem != null) {
			result = md.update(member);
		} else {
			System.out.println("데이터가 존재하지 않아 수정할 수 없습니다");
		}
		return result;
	}
	public int delete(String id) {
		int result = 0;
		Member mem = md.select(id);
		if(mem != null) {
			result = md.delete(id);
		} else {
			System.out.println("데이터가 존재하지 않아 삭제할 수 없습니다");
		}
		return result;
	}
}
