package kr.co.sist.lunch.admin.vo;

public class LunchUpdateVO {
	private String lunch_code, lunch_name, img, spec;
	private int price;

	public LunchUpdateVO(String lunch_code, String lunch_name, String img, String spec, int price) {
		super();
		this.lunch_code = lunch_code;
		this.lunch_name = lunch_name;
		this.img = img;
		this.spec = spec;
		this.price = price;
	}// 古鯵持失切

	public String getLunch_code() {
		return lunch_code;
	}

	public String getLunch_name() {
		return lunch_name;
	}

	public String getImg() {
		return img;
	}

	public String getSpec() {
		return spec;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "LunchUpdateVO [lunch_code=" + lunch_code + ", lunch_name=" + lunch_name + ", img=" + img + ", spec="
				+ spec + ", price=" + price + "]";
	}

}// class
