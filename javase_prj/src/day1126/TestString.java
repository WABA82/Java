package day1126;

/**
 * @author owner ���ڿ��� ���� ��
 *
 */
public class TestString {

	public static void main(String[] args) {
		String str = "ABC"; // �⺻�� �������� ������ ���ڿ��� ���ڿ� ������� �ּҸ� �����ϱ� ������ ==�񱳸� ����� �� �ִ�.
		if (str == "ABC") {
			System.out.println("�⺻�� : ==��� : ����");
		} else {
			System.out.println("�⺻�� : ==��� : �ٸ�");
		} // if ����

		String str1 = new String("ABC"); // ������ �������� ����ϸ� ������ heap�ּҸ� �����ϰ� heap�� ������� ��ü�� ���ڿ� ������� �ּҸ� �����Ѵ�.
		if (str1 == "ABC") {
			System.out.println("������ : ==��� : ����");
		} else {
			System.out.println("������ : ==��� : �ٸ�");
		} // if ����

		System.out.println("equals �޼ҵ� =====================================================");

		// .equals() : ���ڿ��� ��������� ������ ��� ���� ���ڿ��� �����ִ� �޼ҵ�.
		if (str.equals("ABC")) {
			System.out.println("�⺻�� : equals��� : ����");
		} else {
			System.out.println("�⺻�� : equals��� : �ٸ�");
		}

		if (str1.equals("ABC")) {
			System.out.println("�⺻�� : equals��� : ����");
		} else {
			System.out.println("�⺻�� : equals��� : �ٸ�");
		}

	}// ���� �޼ҵ�

}// Ŭ���� �ʵ�
