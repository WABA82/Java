package day1126;

/**
 * @author owner �޼ҵ��� �Ű������� �⺻������Ÿ������ ���ǵȴٸ� �Ű������� �Ҵ� �Ǵ� ���� ����Ǿ� ���޵ȴ�.<br>
 *         �Ű������� ���� �����ϴ��� ������ ���� ������� �ʴ´�.(call by value)<br>
 *
 */
public class CallByValue {

	public void swap(int i, int j) {
		int temp = 0; // �ԷµǴ� ������ ���� ���� ����.
		temp = i;
		i = j;
		j = temp;
		System.out.println("swap �޼ҵ� ������ i = " + i + ", j = " + j);
	}// �ν��Ͻ� �޼ҵ� - ������,

	public static void main(String[] args) {

		int i = 11, j = 26;
		System.out.println("swap ���� i =  " + i + ", j = " + j);

		CallByValue cbv = new CallByValue();
		cbv.swap(i, j); // ���� ����Ǿ� ����.
		System.out.println("swap ���� i =  " + i + ", j = " + j);
	}// ���� �޼ҵ�.

}
