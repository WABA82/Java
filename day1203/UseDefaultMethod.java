package day1203;

public class UseDefaultMethod implements UseDefault {

	@Override
	public void test() {
		System.out.println("�������̵��� �޼ҵ� �Դϴ�.");
	}

	public static void main(String[] args) {
//	����Ŭ���� ��üȭ

		UseDefaultMethod udm = new UseDefaultMethod();
		udm.test();

		// default�޼ҵ�
		udm.temp();

//	is a ������ ��üȭ

		UseDefault ud = new UseDefaultMethod();

		ud.test();
		// default�޼ҵ�
		ud.temp();
	}

}
