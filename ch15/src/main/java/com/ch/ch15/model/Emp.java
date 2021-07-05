package com.ch.ch15.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "emp")
public class Emp {
//	hibernate 또는 JPA에서 숫자부분에 null이 있으면 에러이고 Integer가 정상처리 됨
	private int empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private int sal;
	private Integer comm;
	private int deptno;
	// 관리자 이름
	private String mgrName;
	// join용
	private Dept dept;
	
	@Id // pk
	@Column(name = "empno")
	public int getEmpno() {
		return empno;
	}
	@ManyToOne    // Emp Data여러건에 Dept 데이터 한 건
	@JoinColumn(name = "deptno")
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}