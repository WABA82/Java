package day1205;

/**
 * @author owner<br>
 *         MathŬ������ ��� : ��� �޼ҵ尡 ����ƽ�̱� ������ ��üȭ�� ���� �ʴ´�.
 *
 */
public class UseMath {

	public UseMath() {

		int i = -12;

		// ���밪 �޼ҵ�
		System.out.println(i + "�� ���밪 " + Math.abs(i));

		// �ø� �޼ҵ�
		System.out.println(Math.ceil(10.1));

		// �ݿø� �޼ҵ�
		System.out.println(Math.round(10.5));

		// ���� �޼ҵ�
		System.out.println(Math.floor(10.5));

		double d = Math.random();
		System.out.println(d);
		System.out.println("������ ������ ���� " + d * 5);
		System.out.println("������ ������ �������� ����" + (int) (d * 10));

		// A(65)~Z(90), a(97)~z(122)�� �ϳ��� ���ڸ� ��ȯ�ϴ� ��.
		System.out.println((char) ((int) (d * 26) + 65));

	}

	// �����ڴ빮��, �ҹ���, ���ڷ� �̷���� ������ ��й�ȣ 8�ڸ��� �����Ͽ� ��ȯ�ϴ� ��
	public char[] createPassword() {
		char[] tempPass = new char[8];
		String flag = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		for (int i = 0; i < tempPass.length; i++) {
			tempPass[i] = flag.charAt((int) (Math.random() * flag.length()));
			System.out.print(tempPass[i]);
		}
		return tempPass;
	}

	public static void main(String[] args) {
		new UseMath().createPassword();
	}

}
