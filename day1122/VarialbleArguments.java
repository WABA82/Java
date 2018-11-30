package day1122;

/**
 * @author owner ���������� : �Ű������� �ϳ��ε� �μ��� ������ ���� �� �ִ� ���.<br>
 *         �޼ҵ� �ȿ����� �迭�� ��޵ȴ�.
 */
public class VarialbleArguments {

	/**
	 * ���� ������������ �� �Է� ���� ������ ����� ��
	 * 
	 * @param param ���� ������
	 */
	public void test(int... param) {
		for (int val : param) {
			System.out.println(val);
		} // for ����\
		System.out.println("test �޼ҵ� ȣ��");
	}// test �޼ҵ�

	/**
	 * ���� �μ��� �ޱ����� �Ű������� ���� ���������� ����� �� �ִ�.
	 * 
	 * @param i
	 * @param d
	 * @param j
	 */
	public void test1(int i, double d, int... j) {
		System.out.println("ó�� �Ű����� : " + i);
		System.out.println("ó�� �Ű����� : " + d);
		System.out.println("�迭 �Ű����� : " + j);

		for (int idx = 0; idx < j.length; idx++) {
			System.out.println(j[idx]);
		}

	}
	
	public void printName(String name) {
		System.out.println(name+"�� �ȳ��ϼ���.");
	}
	
	public static void main(String[] args) {

		VarialbleArguments va = new VarialbleArguments();
		va.test1(1, 3.14, 10, 20, 30, 40, 50, 60);

		String name = new String();
		name = "������";
		va.printName(name);
		
		System.out.println("\"�ȳ��ϼ���.\" ");

		
		
	}// main �޼ҵ�

}// class �ʵ�
