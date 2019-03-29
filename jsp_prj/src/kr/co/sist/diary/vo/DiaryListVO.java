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

	/* getter */

	/* getter */

	public void setNum(int num) {
		this.num = num;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setE_year(String e_year) {
		this.e_year = e_year;
	}

	public void setE_month(String e_month) {
		this.e_month = e_month;
	}

	public void setE_day(String e_day) {
		this.e_day = e_day;
	}

	public void setW_date(String w_date) {
		this.w_date = w_date;
	}

	@Override
	public String toString() {
		return "DiaryListVO [num=" + num + ", writer=" + writer + ", subject=" + subject + ", e_year=" + e_year + ", e_month=" + e_month + ", e_day=" + e_day + ", w_date=" + w_date + "]";
	}// toString

}// class
