package day1203;

public class UseInstance {

	public TestSuper test1() {
		// is a ������ ��üȭ : ������ �ڿ��� �ڽ��� �������̵��� �޼ҵ带 ����� �� �ִ�.
		// ����Ŭ������ ��ü�� = new ����Ŭ����������();
		TestSuper ts = new TestSub();
		return ts;
	}// test1

	public TestSuper test2() {
		// is a ������ ��üȭ : ������ �ڿ��� �ڽ��� �������̵��� �޼ҵ带 ����� �� �ִ�.
		// ����Ŭ������ ��ü�� = new ����Ŭ����������();
		TestSuper ts = new TestSub2();
		return ts;
	}// test2

	// static�޼ҵ忡���� this / super�� ����� �� ����.
	public static void main(String[] args) {

//	�Ϲ����� ��üȭ
		// ����Ŭ������ ��ü�� �����Ͽ� ���.
		// ����Ŭ������ ��ü�� = new ������ ������();
		// ��ü�� ��� : ����Ŭ���� �ڿ�, ����Ŭ������ �ڿ�.
		TestSub ts = new TestSub();

		// �θ�� ���� �̸��� ������ �ڽ��� ���� ���.
		ts.i = 100;

		// ����Ŭ������ �޼ҵ� ���.
		ts.pMethod();

		// ����Ŭ������ �޼ҵ� ���.
		ts.subMethod();

		// ����Ŭ�������� �������̵��� �޼ҵ� ���.
		ts.printI();

//	��ü ������(is a����) : ����Ŭ������ �̸����� ��üȭ �ϱ�
		// ���� : ����Ŭ������ ����� �� ������ �ȴ�.

		UseInstance ui = new UseInstance();

		TestSuper ts1 = ui.test1();
		TestSuper ts2 = ui.test2();

		// �������̵� �� �޼ҵ� ȣ��
		ts1.printI();
		ts2.printI();

	}

}
