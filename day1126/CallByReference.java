package day1126;

/**
 * @author owner �޼ҵ��� �Ű������� ��������������(class, ���ڿ�, array)�� ��� ���ڰ��� ������ �ϳ��� �ּҰ�
 *         �Ҵ�ȴ�.<br>
 *         (���� �����ϸ� ������ ��ü�� ���� ���� ����ȴ�)<br>
 *
 */
public class CallByReference {
	private int i;
	private int j;

	public void swap(CallByReference cbr) { //��üȭ�� ��ü�� �Ű������� �����Ѵ�. �ּҸ� �־��ش�.
		int temp = 0;
		temp = cbr.i;
		cbr.i = cbr.j;
		cbr.j = temp;
		System.out.println("swap �޼ҵ峻�� i = " + cbr.i + ", j =  " + cbr.j);
	}

	public static void main(String[] args) {
		CallByReference cbr = new CallByReference();

		cbr.i = 11;
		cbr.j = 26;
		System.out.println("���� �޼ҵ� �� �� i = " + cbr.i + ",  j = " + cbr.j);
		cbr.swap(cbr); //���ڰ����� �ּҰ� �״�� ����.
		System.out.println("���� �޼ҵ� �� �� i = " + cbr.i + ",  j = " + cbr.j);

	}

}
