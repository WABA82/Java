package kr.co.sist.diary.vo;

public class DiaryRemoveVO {

	private int num;
	private String pass;

	public DiaryRemoveVO() {
	}// 奄沙 持失切.

	public DiaryRemoveVO(int num, String pass) {
		super();
		this.num = num;
		this.pass = pass;
	}// 持失切.

	/* getter */
	public int getNum() {
		return num;
	}

	public String getPass() {
		return pass;
	}
	/* getter */

	@Override
	public String toString() {
		return "DiaryRemoveVO [num=" + num + ", pass=" + pass + "]";
	}// toString

}// class
