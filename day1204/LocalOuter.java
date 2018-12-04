package day1204;

/**
 * @author owner<br>
 *         ����Ŭ������ ����� ����Դϴ�.<br>
 *
 */
public class LocalOuter {

	int i;

	public LocalOuter() {
		System.out.println("�ٱ�Ŭ������ ������");
	}

	public void method(int pram_i, final int param_j) {
		int local_i = 0;
		final int local_j = 0;

		/* ����Ŭ���� ���� */
		class Local {
			int loc_i;

			public Local() {
				System.out.println("����Ŭ������ ������ �Դϴ�.");
			}

			public void locMethod() {
				System.out.println("����Ŭ������ �޼ҵ� �Դϴ�. loc_i = " + this.loc_i);
				System.out.println("�ܺ�Ŭ������ �ν��Ͻ����� i = " + i);

				// final �Ű������� ����� �� ������ JDK1.7�̻� ���� �Ű������� ����� �� �ְ� �Ǿ���.
				System.out.println("�Ű����� ��� i = " + pram_i);
				System.out.println("�Ű����� ��� j = " + param_j);
				System.out.println("�������� local_i = " + local_i + ", local_j = " + local_j);
				
				//JDK1.8�������� ���������� ����� ���������� �� �Ҵ��� �Ұ��մϴ�. 
//				local_i = 2018;
			}
			

		}/* Ŭ���� ���� */
		Local lc = new Local();
		lc.locMethod();

		System.out.println("�޼ҵ尡 ȣ��Ǿ����ϴ�. loc_i = " + lc.loc_i);

	}

	public static void main(String[] args) {

		LocalOuter lo = new LocalOuter();

		lo.method(12, 4);
	}
}
