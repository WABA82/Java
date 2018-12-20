package day1128;

/**
 * @author owner<br>
 *         �ึ�� ���� ������ �ٸ� ���� �迭
 *
 */
public class UseVarialbleArray {

	public UseVarialbleArray() {
		// 1.����) ��������[][] �迭�� = null;
		int[][] vArr = null;

		// 2.����) �迭�� = new ��������[*][];
		vArr = new int[4][];
		System.out.println("���� ���� : " + vArr.length + " - (���� ���̴� ���� �����ؾ� �մϴ�.)");

		// 3.�� ���� ���� ���� ����) �迭��[���� ���ȣ] = new ��������[���� ����];
		vArr[0] = new int[3];
		vArr[1] = new int[4];
		vArr[2] = new int[1];
		vArr[3] = new int[] { 1, 2, 3, 4, 5, 6 }; // �ʱ�ȭ�� []�ȿ� ���� ���� �������� �ʾƾ� �� �� �ִ�.

		// 4.���Ҵ�) vArr[���� �� ��ȣ][���� �� ��ȣ] = ��;
		vArr[0][2] = 10;
		vArr[1][3] = 20;
		vArr[2][0] = 30;

		// 5.�����)
		System.out.println(vArr[0][0] + " / " + vArr[0][1] + " / " + vArr[0][2]);

		// 6.for�� ���

		System.out.println("vArr�� �� ���� : \n");

		for (int i = 0; i < vArr.length; i++) {
			for (int j = 0; j < vArr[i].length; j++) {
				System.out.printf("vArr[%d][%d] = %-5d ", i, j, vArr[i][j]);
			}
			System.out.println();
		}

	}// �⺻������

//////////////////////////////////////////////////////////////�Ʒ��� �����迭�� �⺻�� ���� ����Դϴ�.///////////////////////////////////////////////////////

	/**
	 * ���� �迭�� �⺻�� ���� ���
	 */
	public void priType() {
		System.out.println(
				"--------------------------------�����迭�� �⺻�� ���� ����Դϴ�.-----------------------------------------");

		// ����) ��������[][] �迭�� = {{},{},{},,,,,};
		String[][] vArr = { { "����" }, { "����", "����", "����", "������" }, { "���", "��", "��" }, { "��" } };
		String[] title = { "��", "����", "����", "�ܿ�" };

		for (int i = 0; i < vArr.length; i++) {
			System.out.print(title[i] + " : ");
			for (int j = 0; j < vArr[i].length; j++) {
				System.out.print(vArr[i][j] + "\t");
			}
			System.out.println();
		}

	}// priType

	public static void main(String[] args) {
		new UseVarialbleArray().priType();
	}// ���� �޼ҵ�

}// Ŭ���� �ʵ�
