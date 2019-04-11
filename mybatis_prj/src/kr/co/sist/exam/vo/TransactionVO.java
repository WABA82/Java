package kr.co.sist.exam.vo;

public class TransactionVO {
	private String subject, writer;

	// 개발자가 값을 설정하기 위해 사용하는 인자있는 생성자 //
	public TransactionVO(String subject, String writer) {
		super();
		this.subject = subject;
		this.writer = writer;
	}

	// 마이바티스가 사용하는 getter//
	public String getSubject() {
		return subject;
	}

	public String getWriter() {
		return writer;
	}
}
