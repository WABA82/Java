package day1121;

public class Work {

	public void gugudan() { //�ν��Ͻ� �޼ҵ�� �ν��Ͻ� ������ ����� �� ����Ѵ�.
		int i = 2;
		while (i < 10) {

			int j = 1;
			while (j < 10) {
				System.out.println(i + " X " + j + " = " + i * j);
				j++;
			} ////

			i++;
		} // end while

	}// instM gugudan

	public static void byul() {

	}// method 'byul'

	public static void main(String[] args) {
		Work wk = new Work();
		wk.gugudan();

		///////////////////////////////////////

		// 2�� -- �����

		int i = 0;
		do {
			System.out.print("*");
			int j = 0;
			while (j < i) {
//								System.out.print(i + " " + j + " ");
				System.out.print(i+"*");
				j++;
			} // end while
			System.out.println();
			i++;
		} while (i < 4);

	}// method 'main'

}// class filed
