package com.ch.mybatis.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.mybatis.dao.MemberDao;
import com.ch.mybatis.model.Member;
import com.ch.mybatis.model.MemberPhoto;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md;
	@Override
	public Member select(String id) {
		return md.select(id);
	}
	@Override
	public int insert(Member member) {
		return md.insert(member);
	}
	@Override
	public int update(Member member) {
		return md.update(member);
	}
	@Override
	public int delete(String id) {
		return md.delete(id);
	}
	@Override
	public void insertPhoto(List<MemberPhoto> photos) {
		//첫번째 쉬운 방법
		for(MemberPhoto mp : photos) {
			md.insert(mp);
		}
		// 두번째 조금 어려운 방법(한꺼번에 입력) (권장하진 않음/ 유지, 보수 측면에서 어려울 수 있다)
		//md.insertPh(photos);
	}
	@Override
	public List<MemberPhoto> listPhoto(String id) {
		return md.listPhoto(id);
	}
}
