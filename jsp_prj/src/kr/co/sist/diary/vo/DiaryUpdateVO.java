package kr.co.sist.diary.vo;

public class DiaryUpdateVO {

	private int num;
	private String contents, pass;

	public DiaryUpdateVO() {
	}// 奄沙 持失切.

	public DiaryUpdateVO(int num, String contents, String pass) {
		super();
		this.num = num;
		this.contents = contents;
		this.pass = pass;
	}// 持失切.

	/* getter */

	public int getNum() {
		return num;
	}

	public String getContents() {
		return contents;
	}

	public String getPass() {
		return pass;
	}

	/* getter */

	/* setter */

	public void setNum(int num) {
		this.num = num;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	/* setter */

	@Override
	public String toString() {
		return "DiaryUpdateVO [num=" + num + ", contents=" + contents + ", pass=" + pass + "]";
	}// toString

}// class
