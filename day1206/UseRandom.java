package day1206;

import java.util.Random;

/**
 * @author owner<br>
 *         Random Ŭ���� ��� : ������ ������� ��ü.
 *
 */
public class UseRandom {
	public UseRandom() {
		Random r = new Random();
		double d = r.nextDouble();

		// �Ǽ�����
		System.out.println(d);
		// ��������
		System.out.println(d * 5);
		// ��������
		System.out.println((int) (d * 5));

		// ��������
		int i = r.nextInt();
		System.out.println(i);
		System.out.println(i % 5);
		System.out.println(Math.abs(i % 5));

		int j = r.nextInt(5);
		System.out.println(j);

		/* �Ҹ��� ���� */
		Boolean b = r.nextBoolean();
		System.out.println(b);
	}

	public static void main(String[] args) {
		new UseRandom();
	}

}
