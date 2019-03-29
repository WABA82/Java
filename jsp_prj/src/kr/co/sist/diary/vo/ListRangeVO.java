package kr.co.sist.diary.vo;

public class ListRangeVO {

	private int startNum, endNum;

	public ListRangeVO() {
	}

	public ListRangeVO(int startNum, int endNum) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
	}// »ı¼ºÀÚ.

	public int getStartNum() {
		return startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	@Override
	public String toString() {
		return "ListRangeVO [startNum=" + startNum + ", endNum=" + endNum + "]";
	}

}// class
