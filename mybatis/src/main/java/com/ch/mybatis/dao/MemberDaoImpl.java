package com.ch.mybatis.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mybatis.model.Member;
import com.ch.mybatis.model.MemberPhoto;
@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSessionTemplate sst;
	@Override
	public Member select(String id) {
		return sst.selectOne("memberns.select", id);
	}
	@Override
	public int insert(Member member) {
		return sst.insert("memberns.insert", member);
	}
	@Override
	public int update(Member member) {
		return sst.update("memberns.update", member);
	}
	@Override
	public int delete(String id) {
		return sst.update("memberns.delete", id);
	}
	@Override
	public void insert(MemberPhoto mp) {
		sst.insert("memberns.insertPhoto", mp);
	}
	@Override
	public List<MemberPhoto> listPhoto(String id) {
		return sst.selectList("memberns.listPhoto", id);
	}
	@Override
	public void insertPh(List<MemberPhoto> photos) {
		sst.insert("memberns.insertPh", photos);
	}
}
