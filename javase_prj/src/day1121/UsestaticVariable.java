package day1121;

/**
 * @param args static (class) ���� : Ŭ������ ����Ǹ� ���� ó�� �޸�(method����)�� �ö󰡰�, ��� ��ü��
 *             �ϳ��� ������ �����Ͽ� ����ϴ� ����.<br>
 * 
 */
public class UsestaticVariable {
	public static int i; // static ����(����).

	int j;// �ν��Ͻ� ���� : ��üȭ�ؼ� ��밡��.

	public void test() {
		i = 100;
		j = 200;
		System.out.println(i + " / " + j);
	}// test method

	public static void main(String[] args) {
		UsestaticVariable.i = 2000; // static(class) ������ ��� : Ŭ������.������
		System.out.println(UsestaticVariable.i);

		// ��üȭ
		UsestaticVariable usv = new UsestaticVariable();
		UsestaticVariable usv1 = new UsestaticVariable();
		usv.j = 5000; // �ν��Ͻ� ������ ������ ��ü�� ���� ����Ѵ�.
		usv1.j = 10000;
		
//		usv.i=20; -- ��ü������ ����ϸ� Ư�� ��ü�� ���� (member����)�� �ƴϹǷ� ����� ���������� �����ϴ� ������ �ƴϴ�.
		UsestaticVariable.i = 20;
		System.out.println("usv��ü �ν��Ͻ����� : " + usv.j + ", ����ƽ���� : " + UsestaticVariable.i);
		System.out.println("usv1��ü �ν��Ͻ����� : " + usv1.j + ", ����ƽ���� : " + UsestaticVariable.i);
		


//		j=200;
//		System.out.println(i+" / "+j);
	}// main method

}// class field
