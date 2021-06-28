package com.ch.ch09.service;
import lombok.Data;
@Data
public class PagingBean {
	private int currentPage;
	private int rowPerPage;
	private int total;
	private int totalPage;
	private int pagePerBlock = 10;
	private int startPage;
	private int endPage;
//	시작번호 = (페이지번호 -1) * 페이지당 갯수 + 1
//	끝번호 = 시작번호 + 페이지당 갯수 - 1
//	페이지 갯수 = 올림(전체 글 갯수 / 페이지당 갯수) ex) 265/10 => 연산 결과 26이므로 페이지는 27개 필요하다!
//	시작 페이지 = 현재 페이지 - (현재 페이지 - 1) % 10
	public PagingBean(int currentPage, int rowPerPage, int total) {
		this.currentPage = currentPage;
		this.rowPerPage = rowPerPage;
		this.total = total;
		totalPage = (int)Math.ceil((double)total / rowPerPage);
		startPage = currentPage - (currentPage - 1) % pagePerBlock;
		endPage = startPage + pagePerBlock - 1;
		// 27 startPage 21, endPage 30/ endPage <= totalPage 조건이 필요하다
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	}

}
