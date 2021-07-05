package com.ch.ch15.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "dept")
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	@Id
	@Column(name = "deptno")	// 실제 table의 key와 이름이 같으면 생략 가능
	public int getDeptno() {
		return deptno;
	}
}
