package day1218;

/**
 * @author owner<br>
 *         ������ ���� : byte code(.class����)�� �����ϱ� ���� ó���ؾ� �ϴ� ����.
 */
public class UseCompileException {

	public static void main(String[] args) {
		try {
			Object obj = Class.forName("java.lang.String");
			System.out.println(obj);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("�˼��մϴ�.");
			System.err.println("���ܸ޽��� ���" + cnfe.getMessage());
			System.err.println("���ܸ޽��� ��� 2�ܰ� " + cnfe);
			cnfe.printStackTrace();
//			System.out.println("****"); // println�� printStackTrace���� ������ ��� �ɼ� �ִ�. //
		} finally {
			System.out.println("����� �ּż� �����մϴ�.");
		}
	}

}// Ŭ���� //
