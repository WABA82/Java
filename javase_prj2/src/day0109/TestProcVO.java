package day0109;

public class TestProcVO {
	private int empno, sal;
	private String ename, job;

	public TestProcVO() {
	}// 기본생성자

	public TestProcVO(int empno, int sal, String ename, String job) {
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
		this.job = job;
	}// 매개생성자

	public int getEmpno() {
		return empno;
	}

	public int getSal() {
		return sal;
	}

	public String getEname() {
		return ename;
	}

	public String getJob() {
		return job;
	}

}// class
