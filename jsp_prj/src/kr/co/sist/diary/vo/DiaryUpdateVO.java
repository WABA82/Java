package kr.co.sist.diary.vo;

public class DiaryUpdateVO {

	private int num;
	private String contents, pass;

	public DiaryUpdateVO() {
	}// �⺻ ������.

	public DiaryUpdateVO(int num, String contents, String pass) {
		super();
		this.num = num;
		this.contents = contents;
		this.pass = pass;
	}// ������.

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

	@Override
	public String toString() {
		return "DiaryUpdateVO [num=" + num + ", contents=" + contents + ", pass=" + pass + "]";
	}// toString

}// class
