package day0103;

/* ���ٽ��� �̿��� ������ ��� */
public class UseLambda3 {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println(i);
			} // end for i
		});
		t.start();
		for (int i = 0; i < 1000; i++) {
			System.out.println("main----- i = " + i);
		} // end for i
	}// main

}// class
