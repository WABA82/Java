package day0104;

public class CpDeptVO {
	private int deptno;
	private String dname, loc;

	public CpDeptVO() {
	}// 持失切

	public CpDeptVO(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}// 持失切

	public int getDeptno() {
		return deptno;
	}

	public String getDname() {
		return dname;
	}

	public String getLoc() {
		return loc;
	}

}// class
