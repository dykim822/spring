package com.ch.ch14.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "emp")
@Data
public class Emp {
	@Id
	private int empno;		
	private String ename;
	private String job;		
	private Integer mgr;
	private Date hiredate;	
	private int sal;
	private Integer comm;		
	private int deptno;
	// join용
	private Dept dept;
	@Id // id가 primary key
	@Column(name = "empno")
	public int getEmpno() {		return empno;	}
	@ManyToOne
	@JoinColumn(name = "deptno",referencedColumnName="deptno",insertable=false, updatable=false)
	public Dept getDept() {		return dept;	}
	public void setDept(Dept dept) {		this.dept = dept;	}
}