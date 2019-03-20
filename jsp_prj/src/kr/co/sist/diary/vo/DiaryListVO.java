package kr.co.sist.diary.vo;

public class DiaryListVO {

	private int num;
	private String writer, subject, e_year, e_month, e_day, w_date;

	public DiaryListVO() {
	}// 奄沙 持失切.

	public DiaryListVO(int num, String writer, String subject, String e_year, String e_month, String e_day, String w_date) {
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.e_year = e_year;
		this.e_month = e_month;
		this.e_day = e_day;
		this.w_date = w_date;
	}// 持失切.

	/* gettter */

	public int getNum() {
		return num;
	}

	public String getWriter() {
		return writer;
	}

	public String getSubject() {
		return subject;
	}

	public String getE_year() {
		return e_year;
	}

	public String getE_month() {
		return e_month;
	}

	public String getE_day() {
		return e_day;
	}

	public String getW_date() {
		return w_date;
	}

	/* gettter */

	@Override
	public String toString() {
		return "DiaryListVO [num=" + num + ", writer=" + writer + ", subject=" + subject + ", e_year=" + e_year + ", e_month=" + e_month + ", e_day=" + e_day + ", w_date=" + w_date + "]";
	}// toString

}// class
