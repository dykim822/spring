package com.ch.ch14.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "dept")
public class Dept {
	@Id
	private int deptno;
	private String dname;
	private String loc;
}
