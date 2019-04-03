package day0403;

/**
 * 조회하는 컬럼이 값을 저장하는 VO를 Domain
 * 
 * @author owner
 *
 */
public class DeptDomain {
	private int deptno;
	private String dname, loc;
/*
	public DeptDomain() {
		System.out.println("DeptDomain의 기본생성자.");
	}// 기본생성자.

	public DeptDomain(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		System.out.println("DeptDomain의 인자생성자.");
	}// 생성자
*/	
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}// class
