package kr.co.sist.lunch.user.vo;

public class LunchListVO {
	private String img, lunchCode, lunchName, lunchSpec;

	public LunchListVO(String img, String lunchCode, String lunchName, String lunchSpec) {
		this.img = img;
		this.lunchCode = lunchCode;
		this.lunchName = lunchName;
		this.lunchSpec = lunchSpec;
	}// 古鯵持失切

	public String getImg() {
		return img;
	}

	public String getLunchCode() {
		return lunchCode;
	}

	public String getLunchName() {
		return lunchName;
	}

	public String getLunchSpec() {
		return lunchSpec;
	}

	@Override
	public String toString() {
		return "LunchListVO [img=" + img + ", lunchCode=" + lunchCode + ", lunchName=" + lunchName + ", lunchSpec="
				+ lunchSpec + "]";
	}// toString

}// class
