package kr.co.sist.exam.vo;

public class TransactionVO {
	private String subject, writer;

	// �����ڰ� ���� �����ϱ� ���� ����ϴ� �����ִ� ������ //
	public TransactionVO(String subject, String writer) {
		super();
		this.subject = subject;
		this.writer = writer;
	}

	// ���̹�Ƽ���� ����ϴ� getter//
	public String getSubject() {
		return subject;
	}

	public String getWriter() {
		return writer;
	}
}
