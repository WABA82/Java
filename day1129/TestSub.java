package day1129;

/**
 * @author owner TestSutp
 */
public class TestSub extends TestSuper {

	public int i;

	public TestSub() {
		System.out.println("�ڽ��� ������");
	}

	public void subMethod() {
		System.out.println("�ڽ� method");
	}

	public static void main(String[] args) {
		// ��üȭ�� �ڽ�Ŭ������ ����Ѵ�.
		TestSub ts = new TestSub();

		// �ڽİ� �θ� ���� ��Ű�������ϸ� �θ� ����
		// ������ �޼ҵ��� ���������ڰ� public, protected, default��
		// �ڿ��� ����� �� �ִ�.
		ts.pub_i = 10;
		ts.pro_i = 20;
		ts.def_i = 30;
		ts.i = 100;
		System.out.println("�θ��� �ڿ� " + ts.pub_i + " / " + ts.pro_i + " / " + ts.def_i);
		ts.SuperMethod();
		System.out.println("�ڽ��� �ڿ�" + ts.i);
	
	}//���� �޼ҵ�
}//Ŭ���� �ʵ�
