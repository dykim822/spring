package com.ch.mybatis.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.mybatis.dao.MemberDao;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md;
}
