package com.sist.web.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
/*
 *      EMPNO int 
		ENAME text 
		JOB text 
		MGR text 
		HIREDATE text 
		SAL int 
		COMM text 
		DEPTNO int
		csv = null 이 있는 경 => text
 */
@Entity
@Data
public class Emp {
  @Id
  private int empno;
  private int sal,deptno;
  private String ename,job,mgr,hiredate,comm;
}
