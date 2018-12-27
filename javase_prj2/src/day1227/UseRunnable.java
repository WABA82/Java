package day1227;

/**
 * @author owner<br>
 *         Runnable interface�� �����Ͽ� Thread�� ���.
 *
 */

/* 1. Runnable �������̽� �ޱ� */
public class UseRunnable implements Runnable {

	@Override /* 2.run�޼ҵ� �������̵� */
	public void run() {
		/* 3.������� �����ؾ� �ϴ� �ڵ� */
		for (int i = 0; i < 1000; i++) {
			System.out.println("run i ========== " + i);
		}

	} // run

	/* �񱳿� �ڵ� */
	public void test() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("test i ^^^^^^^^^ " + i);
		}

	}

	public static void main(String[] args) {
		long st = System.currentTimeMillis();
		/* 4. ��ü���� */
		UseRunnable ur = new UseRunnable();
		/* 5. ������Ŭ���� ���� - Has A���� : �Ű������� ur�� �޴´�. */
		Thread th = new Thread(ur);
		/* 6. �����忡 �ִ� start�� ȣ�� */
		// ur.run();
		th.start(); // Has A���谡 �������� ������ Thread�� run()ȣ��ȴ�. //
		/* �񱳿� �ڵ� ȣ�� */
		ur.test();
		long et = System.currentTimeMillis();

		System.out.println((et - st) + " ms");
	}// main

}// class
