package com.ch.ch10.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.ch10.dao.ReplyBoardDao;
import com.ch.ch10.model.ReplyBoard;
@Service
public class ReplyBoardServiceImpl implements ReplyBoardService {
	@Autowired
	private ReplyBoardDao rbd;
	@Override
	public List<ReplyBoard> list(int bno) {
		return rbd.list(bno);
	}
	@Override
	public void delete(ReplyBoard rb) {
		rbd.delete(rb);
	}
	@Override
	public void insert(ReplyBoard rb) {
		rbd.insert(rb);
	}
	@Override
	public void update(ReplyBoard rb) {
		rbd.update(rb);
	}
}
