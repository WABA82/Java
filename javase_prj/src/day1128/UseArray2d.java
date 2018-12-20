package day1128;

/**
 * @author owner<br>
 *         ��� ���� ������ 2���� �迭
 *
 */
public class UseArray2d {

	/**
	 * ������Ÿ������ 2���� �迭 ���
	 */
	public void refType() {
		// 1.����) �������� [][] �迭�� = null;
		int[][] arr = null;

		// 2.����) �迭�� = new �������� [���� ����][���� ����];
		arr = new int[3][4];
		System.out.println("���� �� : " + arr.length + ", ���� �� : " + arr[0].length);

		// ++���� + ����)
		int[][] arr1 = new int[4][5];
		System.out.println("���� �� : " + arr1.length + ", ���� �� : " + arr1[0].length);

		// 3.��) �迭�� [][] = ��;
		arr[0][0] = 10;
		arr[1][1] = 20;
		arr[2][2] = 30;

		// 4.�����) �迭��[���� ���ȣ][���� ���ȣ]
		System.out.println(arr[0][0] + " / " + arr[0][1] + " / " + arr[0][2]);

		// ��� ���� �� ���ϱ�) 2�� for���� ���

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("arr[%d][%d] = %-4d", i, j, arr[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("--------------------for ~ each ���� ����ϱ�----------------------");

		// 2���� �迭�� �� ���� �ٸ� �迭�� ���
		for (int[] temp : arr1) {
			// 1���� �迭�� �� ���ϱ�
			for (int val : temp) {
				System.out.print(val + "\t");
			}
			System.out.println();
		}

	}// refType

	////////////////////////////////////////////// �Ʒ��� �⺻�� �������� �ۼ��� 2���� �迭
	////////////////////////////////////////////// �Դϴ�.////////////////////////////////

	/**
	 * 2���� �迭
	 */
	public void priType() {
		// �� ���� ��ȣ�� ���� ���� ����.
		// 1.����+���Ҵ�) �������� [][] �迭�� = {{��,}{,,}{,,}};
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println("�� : " + arr.length + ", �� : " + arr[0].length);

		// 2.�� �Ҵ�)
		arr[0][0] = 100;

		// 3.�� ���)
		System.out.println(arr[0][0] + " / " + arr[0][1]);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("arr[%d][%d] = %-4d ", i, j, arr[i][j]);
			}
			System.out.println();
		}

	}// priType

	public static void main(String[] args) {
		UseArray2d ua2 = new UseArray2d();

		ua2.refType();
		System.out.println("---------------------------------------------------");
		ua2.priType();
	}

}
