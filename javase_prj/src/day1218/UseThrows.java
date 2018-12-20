package day1218;

import java.util.Random;

/**
 * @author owner<br>
 *         throws : �޼ҵ� ������ �߻��� ���ܸ� �޼ҵ带 ȣ���� ������ ó���ϴ� throws�� ���.
 */
public class UseThrows {

	public void test() throws ClassNotFoundException {
		String className = "day1217.UseRuntimeException";

		if (new Random().nextBoolean()) {
			className = "java.lang.Integer";
		}

		Object obj = Class.forName(className);
		System.out.println("Ŭ���� �ε� : " + obj);
	}

	public static void main(String[] args) {
		UseThrows ut = new UseThrows();
		try {
			ut.test(); // �޼ҵ带 ȣ���Ͽ� ���� �����ϴٺ��� ������ �߻��� ���� �ִ�. //
		} catch (ClassNotFoundException e) {
			System.err.println("�˼��մϴ�.");
			e.printStackTrace();
//			System.out.println("�������"); //printStackTrace ���� �߰��� ��� �ɼ� �ִ�.
		}
	}
}
