package day1204;

/**
 * @author owner<br>
 */
public class Outter {
	int i;

	public Outter() {
		System.out.println("�ٱ� Ŭ������ ������");
	}

	public void outMethod() {

		// �ƿ�Ŭ������ �޼ҵ� �ȿ��� �̳�Ŭ���� ��üȭ
		Outter.Inner in = this.new Inner();
		in.j = 100;
		System.out.println("�ٱ� Ŭ������ �޼ҵ��Դϴ�. ���� i = " + in.j);
	}

	/*******************************************
	 * �̳�Ŭ���� ����
	 ******************************************/

	public class Inner {
		int j;

		public Inner() {
			System.out.println("���� Ŭ������ ������");
		}

		public void inMethod() {
			System.out.println("���� Ŭ������ �޼ҵ�, j = " + j + ", �ٱ�Ŭ������ �ڿ� i = " + i);
//			outMethod();
		}

		Outter out = new Outter();

	}

	/*******************************************
	 * �̳�Ŭ���� ��
	 *******************************************/

	public static void main(String[] args) {
		// 1. Outter Ŭ������ ��üȭ
		Outter out = new Outter();
		// 2. Inner Ŭ������ ��üȭ
		Outter.Inner in = out.new Inner();

		// �ڿ����.
		out.i = 10;
		in.j = 12;
	}

}
