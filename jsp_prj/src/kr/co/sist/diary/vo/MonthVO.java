package kr.co.sist.diary.vo;

public class MonthVO {
	private int num;
	private String subject;

	public MonthVO() {
	}// 奄沙持失切.

	public MonthVO(int num, String subject) {
		this.num = num;
		this.subject = subject;
	}// 持失切.

	/* getter */
	public int getNum() {
		return num;
	}

	public String getSubject() {
		return subject;
	}
	/* getter */

	@Override
	public String toString() {
		return "MonthVO [num=" + num + ", subject=" + subject + "]";
	}// toStirng

}// class
