package day1218;

import java.util.Random;

/**
 * @author owner<br>
 *         ���ܸ� ������ �߻�
 */
public class TestThrow {

	/**
	 * ���� ���ٰ� ��踦 �ǿ�� �л��� ���� ���ǻ�ȸ�� �����Ѵ�.
	 */
	public void teacksung() throws Exception {
		String[] grade = { "�ʵ��л�", "���л�", "����л�" };
		String randomGrade = grade[new Random().nextInt(grade.length)];

		if (randomGrade.equals("�ʵ��л�")) {
			throw new Exception(randomGrade + "��Ե� �ݿ��ؾ��ϴ� �κ� ������?");
		} else {
			System.out.println(randomGrade + "��ô ��������.('' )( '')");
		}
	}

	/**
	 * ���� ���ٰ� ��踦 �ǿ�� �л��� ���� ���ǻ�ȸ�� �����Ѵ�.
	 */
	public void teacksung2() throws TobaccoException {
		String[] grade = { "�ʵ��л�", "���л�", "����л�" };
		String randomGrade = grade[new Random().nextInt(grade.length)];

		if (randomGrade.equals("�ʵ��л�")) {
			throw new TobaccoException("���");
		} else {
			System.out.println(randomGrade + "��ô ��������.('' )( '')");
		}
	}

	public static void main(String[] args) {
		TestThrow tt = new TestThrow();

		// �޼ҵ� 1 ȣ��� //
		try {
			tt.teacksung();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// �޼ҵ�2 ȣ��� //
		tt.teacksung2();

	}

}
