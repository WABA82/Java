import java.util.Random;

public class work1205 {

	public static void main(String args[]) {
		int a[] = new int[6]; // int�� �迭 ����
		Random r = new Random(); // ��ü����
		System.out.print("�ߺ����� ���� 6���� ���ڴ� : ");
		for (int i = 0; i <= 5; i++) // ���� 6���� �̱����� for��
		{
			a[i] = r.nextInt(10) + 1; // 1~10������ �������� �ϳ��� �̾� a[0]~a[5]�� ����
			for (int j = 0; j < i; j++) // �ߺ����Ÿ� ���� for��
			{
				/*
				 * ���� a[]�� ����� �������ڿ� ������ a[]�� �� ���� �� �ؿ��� ��� �迭 a[3]�� ���� 6�� ������ ������ �ϼ��� �迭
				 * a[0],a[1],a[2]�� ���Ͽ� ���� 6�� �ߺ����� ������ ���� a[4]���� �Ѿ��, �ߺ��ȴٸ� �ٽ� a[3]�� �ߺ����� �ʴ�
				 * ���ڸ� �ֱ� ���Ͽ� i�� �ѹ� �������� ó�� for������ ���ư� �ٽ� a[3]�� ä���
				 */
				if (a[i] == a[j]) {
					i--;
				}
			}
		}
		for (int k = 0; k <= 5; k++) // ä���� �迭�� ����ϱ� ���� for��
		{
			if (k == 5) {
				System.out.print(a[k]);
			} else {
				System.out.print(a[k] + ",");
			}
		}
		System.out.print("�Դϴ�.");
	}
}
