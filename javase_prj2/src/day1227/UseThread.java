package day1227;

/**
 * @author owner<br>
 *         ������ ��뿬�� : ������ ��� �޾Ƽ� ���.
 *
 */
/* 1. ������Ŭ���� ��� �ޱ� */
public class UseThread extends Thread {

	@Override /* 2. run�޼ҵ�(Runnable�������̽�) �������̵� */
	public void run() {
		/* 3. Thread�� ���۵Ǿ�� �� �ڵ� : ���ÿ� �����ؾ� �� �ڵ� */
		for (int i = 0; i < 1000; i++) {
			System.out.println("run i-------------------> " + i);
		}
	}// run�޼ҵ�

	/* 6. �񱳿� �ڵ� */
	public void test() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("main =============== i = " + i);
		}
	}

	public static void main(String[] args) {
		/* 4. ��ü���� */
		UseThread ut = new UseThread();
		/* 5. ThreadŬ����-start�޼ҵ� ȣ�� : */
		ut.start(); // start�޼ҵ� ȣ��� -> �������̵��� run�޼ҵ带 ������� ����� �� �ִ�.
		/* ���� : run�޼ҵ带 ����� ��� */
		// ut.run(); // run�� ���� ȣ���ϸ� �����带 ����� �� ����.

		ut.test();

	} // main

}// class
