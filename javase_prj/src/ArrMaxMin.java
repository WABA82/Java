
/**
 * @author owner<br>
 *         �ڹ��� ���� - �ڹټҽ����� : 2������<br>
 *
 */
public class ArrMaxMin {

	/* �ν��Ͻ� ���� - ����. */
	private int max;
	private int min;
	private int[] score;

	/* �⺻������ - �ʱⰪ ����. */
	public ArrMaxMin() {
		// �ְ� ������ ���� ������ ���� ������ ����
		max = 0;
		min = 101;
		score = new int[] { 79, 88, 91, 33, 100, 55, 95 };
	}

	/* set �޼ҵ� */

	/* get �޼ҵ� */

	/* ��¿� �ν��Ͻ��޼ҵ� */
	public void printScore() {

		for (int i = 0; i < score.length; i++) {
			/* for �ݺ������� �� �ε����� ���� ���Ͽ� �� ū ���� max������ ����ϴ�. */
			if (max < score[i]) {
				max = score[i];
			}
			/* for �ݺ������� �� �ε����� ���� ���Ͽ� �� ū ���� max������ ����ϴ�. */
			if (min > score[i]) {
				min = score[i];
			}
		} // end for

		// ���
		System.out.printf("�ְ��� max = [%d], ������ min = [%d]\n", max, min);
	}

	/* ���ϴ� ���� �޼ҵ� �Դϴ�. */
	public static void main(String[] args) {

		/* ��üȭ */
		ArrMaxMin arrmaxmin = new ArrMaxMin();

		/* �ν��Ͻ��޼ҵ� ���(���) */
		arrmaxmin.printScore();

	}// ���� �޼ҵ�

}// Ŭ���� �ʵ�
