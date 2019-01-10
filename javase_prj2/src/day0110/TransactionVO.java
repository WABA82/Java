package day0110;

public class TransactionVO {
	private String subject, writer;

	public TransactionVO() {
	}// 기본생성자

	public TransactionVO(String subject, String writer) {
		this.subject = subject;
		this.writer = writer;
	}// 매개생성자

	public String getSubject() {
		return subject;
	}

	public String getWriter() {
		return writer;
	}

}// class
