package day1127;

/**
 * @author owner <br>
 *         1���� �迭 : ���ϳ��� ���θ� ������ �迭<br>
 *         �迭 - �޸𸮿� ���ϵ����������� ������ ��������<br>
 *         ������ ������Ÿ��, �������� �� <br>
 *         �ϰ�ó���� ���<br>
 *         ���� �� ��� (�迭��.length)
 */
public class UseArray1d {

	public UseArray1d() {
		// 1. �迭 ����) ��������[] �迭�� = null;
		int[] arr = null;
		// 2. �迭 ����) �迭�� = new ��������[���ǰ���];
		arr = new int[6];
		// ����� ����) ��������[] �迭�� = new ��������[���� ����];
		int[] arr1 = new int[8];
		System.out.println(arr + " / " + arr1);

		System.out.println("arr �迭�� ���� ���� : " + arr.length);
		System.out.println("arr1 �迭�� ���� ���� : " + arr1.length);

		// 3.���Ҵ�) �迭��[���� �ε���] = ��;
		arr[0] = 11;
		arr[1] = 27;
		arr[2] = 14;
		arr[3] = 46;
		System.out.printf("arr[0] = %d, arr[1] = %d, arr[2] = %d\n", arr[0], arr[1], arr[2]);
		//
		System.out.println("arr[5] = " + arr[5]);

		// �ϰ�ó��
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d \n", i, arr[i]);
		}

	}// �⺻������

	/**
	 * 1���� �迭�� �⺻�� ������ ���.
	 */
	public void arrayPrimitive() {
		System.out.println("-----------------------�⺻�� ����---------------------------");

		// 1. ����) ��������[] �迭�� = {��,,,,,,,,,};
		int[] arr = { 2018, 11, 27, 15, 20 };
		System.out.println("���� ���� : " + arr.length);
		int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("arr1�� ���� �� : " + arr1.length);

		// 2. �� �Ҵ�)
		arr[0] = 2019;
		System.out.println(arr[0] + " / " + arr[1]);
		
		//�迭 �� ������
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println("arr[" + i + "] = " + arr[i] + " ");
		}
		
		//���� for : for(�迭���� ���� ������ ���� : �迭) { };
		// for ()
		
		for(int value : arr1) {
			System.out.println(value);
		}
		System.out.println("-----------------");
		
		//arr1�迭�� ������ ����� ó�� ����� ���
		for (int i = arr1.length-1 ; i > -1 ; i--) {
			System.out.println(arr1[i]);
		}
		
	}// �޼ҵ�

	public static void main(String[] args) {
		new UseArray1d().arrayPrimitive();

	}// ���θ޼ҵ�

}// Ŭ���� �ʵ�
