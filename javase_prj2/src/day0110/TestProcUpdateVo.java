package day0110;

public class TestProcUpdateVo {
	private int empno, sal;
	private String job;

	public TestProcUpdateVo() {
	}// �⺻������

	public TestProcUpdateVo(int empno, int sal, String job) {
		this.empno = empno;
		this.sal = sal;
		this.job = job;
	}// �Ű�������

	public int getEmpno() {
		return empno;
	}

	public int getSal() {
		return sal;
	}

	public String getJob() {
		return job;
	}

}// class
