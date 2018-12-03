package day1203;

import org.omg.CORBA.Object;

/**
 * @author owner<br>
 *         �������̽��� �����ϴ� Ŭ����(����Ŭ���� �̰� �߻�޼ҵ带 �������̵��ϴ� Ŭ����)<br>
 *         �����������̽��� ����� �޴� ��Ȳ�̶�� ����Ŭ�������� ��Ӱ������������̽� ������ �����ؾ� �Ѵ�.
 */
public class InterfaceImpl implements SuperInterface {

	@Override
	public void method_A() {
		System.out.println("�޼ҵ�A");
	}

	@Override
	public void method_B(int i) {
		System.out.println("�޼ҵ�B" + ", �Ű����� i = " + i);
	}

	@Override
	public String msgB() {
		return "������ ������ �Դϴ�.";
	}

	@Override
	public String msg() {
		return "������ ȭ���� �Դϴ�.";
	}

	public void test() {

	}

	public static void main(String[] args) {
		InterfaceImpl ii = new InterfaceImpl();

		ii.method_A();
		ii.method_B(1);
		System.out.println(ii.msg());
		System.out.println(ii.msgB());

		// is a ������ ��üȭ
		// InterfaceImpl���� �������̵��� �Ǿ��ٸ� ��� ����� �� �ִ�.
		SuperInterface si = new InterfaceImpl();
		System.out.println(si.msg());

		InterA ia = new InterfaceImpl();
		System.out.println(ia.msg());

		InterB ib = new InterfaceImpl();
		System.out.println(ib.msgB());

	}

}
