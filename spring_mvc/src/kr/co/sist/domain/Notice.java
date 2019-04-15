package kr.co.sist.domain;

public class Notice {

	private int num;
	private String subject;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Notice [num=" + num + ", subject=" + subject + "]";
	}

}
