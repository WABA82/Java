
public class Practice {
	public static void main(String[] args) {

		int value = 0; // 1~10������ ���ڸ� �����ϱ� ���� ����

		for (int i = 0; i < 10; i++) { // *** i�� ���θ� ����ϱ� ���� �ݺ���

			value = i; // i ������ �� ���ڵ��� ����ϱ� ���� ����
			for (int j = i; j < 10 + i; j++) { // *** j�� ���θ� ����ϱ� ���� �ݺ���.
				System.out.print((j < 10) ? ++value : --value); // ���������� 1�� ���� ���� �� �����Ѵ�.
																// ( j < 10 )? (value = value + 1) : (value = value - 1)
																// ����.
			}
			System.out.println();// �ٹٲ�

		} // for

		System.out.println("=================================================================");

		System.out.println("3+4 = " + (3 + 4));

	}// main
}// class
