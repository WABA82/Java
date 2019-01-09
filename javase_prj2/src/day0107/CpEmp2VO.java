package day0107;

public class CpEmp2VO {

	private int empno, sal;
	private String ename;

	public CpEmp2VO() {
	}// 기본생성자

	public CpEmp2VO(int empno, int sal, String ename) {
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
	}// 인자생성자

	public int getEmpno() {
		return empno;
	}

	public int getSal() {
		return sal;
	}

	public String getEname() {
		return ename;
	}

}// class
