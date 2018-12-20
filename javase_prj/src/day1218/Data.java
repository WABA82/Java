package day1218;

public class Data /* implements Cloneable*/ {

	private String school;

	public Data() {
		super();
	}

	public Data(String school) {
		super();
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Data getData() throws CloneNotSupportedException {
		/*
		 * 클론메소드는 protected접근지정자 이므로 외부클래스에서 다른 클래스의 클론을 호출할 수 없다. 반드시 복제하려고 하는 클래스에서
		 * 정의하여야 합니다.
		 */
		Data data = (Data) this.clone();
		return data;
	}

}
