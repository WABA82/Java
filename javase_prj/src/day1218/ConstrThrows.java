package day1218;

/**
 * @author owner<br>
 *         �����ڿ��� ���� ������ ���
 *
 */
public class ConstrThrows {

	public ConstrThrows() throws ClassNotFoundException {
		Class.forName("java.lang.Object");
		System.out.println("��ü�� ���� �Ǿ����ϴ�.");
	}

	public static void main(String[] args) {

		try {
			ConstrThrows ct = new ConstrThrows();
			System.out.println("��üȭ ����" + ct);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("��üȭ�� ���� �߻�");
			cnfe.printStackTrace();
		}

	}

}
