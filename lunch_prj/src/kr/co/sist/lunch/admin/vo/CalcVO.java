package kr.co.sist.lunch.admin.vo;

public class CalcVO {
	private String lunchCode, LunchName;
	private int price, total;

	public CalcVO(String lunchCode, String lunchName, int price, int total) {
		this.lunchCode = lunchCode;
		LunchName = lunchName;
		this.price = price;
		this.total = total;
	}// 古鯵持失切

	public String getLunchCode() {
		return lunchCode;
	}// getLunchCode

	public String getLunchName() {
		return LunchName;
	}// getLunchName

	public int getPrice() {
		return price;
	}// getPrice

	public int getTotal() {
		return total;
	}// getTotal

	@Override
	public String toString() {
		return "CalcVO [lunchCode=" + lunchCode + ", LunchName=" + LunchName + ", price=" + price + ", total=" + total
				+ "]";
	}

}// class
