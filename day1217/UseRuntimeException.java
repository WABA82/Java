package day1217;

/**
 * @author owner<br>
 *         RuntimeException : JVM���� �ڵ����� ����ó���� ���ִ� Exception�� �����Դϴ�.
 *
 */
public class UseRuntimeException {

	public static void main(String[] args) {

		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int result = 0;
			result = num1 / num2;
			System.out.println(num1 + " / " + num2 + " = " + result);
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.err.println("�迭�� �ε����� �߸� �Ǿ����ϴ�.");
			/* ���� ���� */
			System.err.println("ó�� 1�ܰ�" + aioobe.getMessage());
			/* ���� ���� + ���� ��ü */
			System.err.println("ó�� 2�ܰ�" + aioobe);
			/* �ڼ��� ���� */
			aioobe.printStackTrace();
		} catch (NumberFormatException nfe) {
			System.err.println("�Է°��� ���� ���°� �ƴմϴ�.");
			/* ���� ���� */
			System.err.println("ó�� 1�ܰ�" + nfe.getMessage());
			/* ���� ���� + ���� ��ü */
			System.err.println("ó�� 2�ܰ�" + nfe);
			/* �ڼ��� ���� */
			nfe.printStackTrace();
		} catch (ArithmeticException ae) {
			System.err.println("���ڸ� 0���� ���� �� �����ϴ�.");
			/* ���� ���� */
			System.err.println("ó�� 1�ܰ�" + ae.getMessage());
			/* ���� ���� + ���� ��ü */
			System.err.println("ó�� 2�ܰ�" + ae);
			/* �ڼ��� ���� */
			ae.printStackTrace();
		} catch (Exception e) { /* ���� �ֻ��� ��ü�� �� �������� ���;� �մϴ�. */
			System.err.println("�������� ���� ���� �Դϴ�.");
			e.printStackTrace();
		} finally {
			System.out.println("�ݵ�� ����Ǿ�� �� �ڵ�");
		}

	}
}
