package day0110;

public class TransactionVO {
	private String subject, writer;

	public TransactionVO() {
	}// �⺻������

	public TransactionVO(String subject, String writer) {
		this.subject = subject;
		this.writer = writer;
	}// �Ű�������

	public String getSubject() {
		return subject;
	}

	public String getWriter() {
		return writer;
	}

}// class
