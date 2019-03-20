package kr.co.sist.diary.vo;

public class DiaryDetailVO {

	private String writer, subject, contents, w_date, ip;

	public DiaryDetailVO() {
	}// 奄沙 持失切.

	public DiaryDetailVO(String writer, String subject, String contents, String w_date, String ip) {
		super();
		this.writer = writer;
		this.subject = subject;
		this.contents = contents;
		this.w_date = w_date;
		this.ip = ip;
	}// 持失切.

	/* getter */

	public String getWriter() {
		return writer;
	}

	public String getSubject() {
		return subject;
	}

	public String getContents() {
		return contents;
	}

	public String getW_date() {
		return w_date;
	}

	public String getIp() {
		return ip;
	}

	/* getter */

	@Override
	public String toString() {
		return "DiaryDetailVO [writer=" + writer + ", subject=" + subject + ", contents=" + contents + ", w_date=" + w_date + ", ip=" + ip + "]";
	}// toString

}// class
