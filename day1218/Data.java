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
		 * Ŭ�и޼ҵ�� protected���������� �̹Ƿ� �ܺ�Ŭ�������� �ٸ� Ŭ������ Ŭ���� ȣ���� �� ����. �ݵ�� �����Ϸ��� �ϴ� Ŭ��������
		 * �����Ͽ��� �մϴ�.
		 */
		Data data = (Data) this.clone();
		return data;
	}

}
