package kr.co.sist.lunch.admin.vo;

public class LunchDetailVO {

	private int price;
	private String code, lunch_name, img, spec, input_date;

	public LunchDetailVO(String code, String lunch_name, String img, int price, String spec, String input_date) {
		this.code = code;
		this.lunch_name = lunch_name;
		this.img = img;
		this.price = price;
		this.spec = spec;
		this.input_date = input_date;
	}

	public String getCode() {
		return code;
	}

	public String getLunch_name() {
		return lunch_name;
	}

	public String getImg() {
		return img;
	}

	public int getPrice() {
		return price;
	}

	public String getSpec() {
		return spec;
	}

	public String getInput_date() {
		return input_date;
	}

	@Override
	public String toString() {
		return "LunchDetailVO [code=" + code + ", lunch_name=" + lunch_name + ", img=" + img + ", price=" + price
				+ ", spec=" + spec + ", input_date=" + input_date + "]";
	}

}// class
