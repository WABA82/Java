package day1227;

/**
 * @author owner<br>
 *         Runnable interface를 구현하여 Thread를 사용.
 *
 */

/* 1. Runnable 인터페이스 받기 */
public class UseRunnable implements Runnable {

	@Override /* 2.run메소드 오버라이딩 */
	public void run() {
		/* 3.쓰레드로 동작해야 하는 코드 */
		for (int i = 0; i < 1000; i++) {
			System.out.println("run i ========== " + i);
		}

	} // run

	/* 비교용 코드 */
	public void test() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("test i ^^^^^^^^^ " + i);
		}

	}

	public static void main(String[] args) {
		long st = System.currentTimeMillis();
		/* 4. 객체생성 */
		UseRunnable ur = new UseRunnable();
		/* 5. 쓰레드클래스 생성 - Has A관계 : 매개변수로 ur을 받는다. */
		Thread th = new Thread(ur);
		/* 6. 쓰레드에 있는 start를 호출 */
		// ur.run();
		th.start(); // Has A관계가 설정되지 않으면 Thread의 run()호출된다. //
		/* 비교용 코드 호출 */
		ur.test();
		long et = System.currentTimeMillis();

		System.out.println((et - st) + " ms");
	}// main

}// class
