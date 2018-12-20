package day1126;

/**
 * @author owner �޼ҵ带 ȣ���ϴ� ��ü�� �ּҷ� ����Ǿ� ���Ǵ� this.
 *
 */
public class ThisKeyword {

	private int i;

	/**
	 * this�� ������� ���� �޼ҵ�
	 * 
	 * @param i - ������
	 * @param t - ������������Ÿ��
	 */
	public void useInstance(int i, ThisKeyword tk) {
		tk.i = i; // �Ķ����(���ø޸�) ������ ���� �ν��Ͻ�(���޸�) ������ �ø�.
		System.out.println("���޵� ��ü : " + tk);
	}//

	/**
	 * this�� ����ϴ� �޼ҵ�
	 * 
	 * @param i - ������
	 */
	public void useThis(int i) {
		this.i = i; // *�߿�*) this�� method�� ȣ���ϴ� ��ü�� �ּҷ� ��ȯ�Ǵ� Ű����.
		System.out.println("�޼ҵ带 ȣ���� ��ü�� �ּ� : " + this);
	}//

	public static void test() {
		System.out.println("static method");
	}

	public static void main(String[] args) {
		ThisKeyword tk = new ThisKeyword();
		System.out.println("������ ��ü : " + tk);

		tk.useInstance(300, tk);
		System.out.println("������ ��ü�� �ν��Ͻ� ������ �� : " + tk.i);

		System.out.println("========================================");

		tk.useThis(900);
		System.out.println("this�� ����Ͽ� ������ �ν��Ͻ� ������ �� : " + tk.i);

		System.out.println("========================================");

		ThisKeyword.test();

	}// ���� �޼ҵ�

}// Ŭ����
