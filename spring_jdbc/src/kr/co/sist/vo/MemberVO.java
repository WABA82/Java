package kr.co.sist.vo;

public class MemberVO {

	private String name, img, loc, highSchool;

	public MemberVO() {
	}

	public MemberVO(String name, String img, String loc, String highSchool) {
		this.name = name;
		this.img = img;
		this.loc = loc;
		this.highSchool = highSchool;
	}

	/* getter & setter */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}

	/* getter & setter */

}// class
