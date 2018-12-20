package day1122;

/**
 * @author owner 
 * method�� 4���� ����
 */
public class MethodType {

	/**
	 * ��ȯ�� ���� �Ű����� ���� �� - ���� ��
	 */
	public void typeA() {
		System.out.println("�ȳ��ϼ���.");
	}// typeA method

	/**
	 * ��ȯ�� ���� �Ű����� �ִ� �� - ���� ��
	 * 
	 * @param i ����ϰ� ���� ��
	 */
	public void typeB(int i) {
		System.out.println(i + "�� �ȳ�");
	}// typeB method

	/**
	 * ��ȯ�� �ְ� �Ű����� ���� �� - ���� ��
	 * 
	 * @return ��.���� �Ǽ������� ��ȯ
	 */
	public double typeC() {
		return 2018.11;
	}// typeC method

	/**
	 * ��ȯ�� �ְ� �Ű����� �ִ� �� - ���� ��<>
	 *
	 * @param d ������ ����� �Ǽ� ��
	 * @return i �� ����
	 * 
	 */
	public int typeD(double d) {
		
		int i = (int)(d);
		
		return i;
	}// typeD method

	public static void main(String[] args) {

		MethodType mt = new MethodType();

		// 1. ���� �� method ȣ��
		mt.typeA();

		// 2. ���� �� method ȣ��
		mt.typeB(21);

		// 3. ���� �� method ȣ��
		double i = mt.typeC(); // typeC �޼ҵ�� ���� ������ �ִ� �޼ҵ� �̱� ������ ����ϱ� �� ���� ���� ������ ����ؾ� �Ѵ�.
		System.out.println( "������ : " + i);
		
		// 4. ���� �� method ȣ��
		int j = mt.typeD(300.003); // typeC �޼ҵ�� ���� ������ �ִ� �޼ҵ� �̱� ������ ����ϱ� �� ���� ���� ������ ����ؾ� �Ѵ�.
		System.out.println( "������ : " + j);
		

	}// main method

}// class field
