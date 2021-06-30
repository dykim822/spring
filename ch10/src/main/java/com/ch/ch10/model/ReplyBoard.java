package com.ch.ch10.model;
import java.sql.Date;
import lombok.Data;
@Data
public class ReplyBoard {
	private int rno;	// 입력할 때마다 자동으로 1씩 증가
	private int bno;	// 원래 게시글 번호
	private String replytext;	// 댓글 내용
	private String replyer;		// 댓글 작성자
	private Date regdate;		// 작성일
	private Date updatedate;	// 수정일
	private String del;			// 삭제 여부 확인
}
