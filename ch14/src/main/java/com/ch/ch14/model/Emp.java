package com.ch.ch14.model;
import java.sql.Date;
import lombok.Data;
@Data
public class Emp {
	// hibernate or JPA에서 숫자부분에 null이 있으면 에러
	// Interger형은 정상처리가 가능하다
	// 정수형은 값이 없는 변수들은 무조건 0으로 지정해야 한다. Null로 처리하면 X
	private int empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private int sal;
	private Integer comm;
	private int deptno;
	// 관리자 이름(원하는 데이터 추가 가능)
	private String mgrName;
	// join용
	private Dept dept;
}
