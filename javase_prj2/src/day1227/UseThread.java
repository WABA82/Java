package day1227;

/**
 * @author owner<br>
 *         쓰레드 사용연습 : 쓰레드 상속 받아서 사용.
 *
 */
/* 1. 쓰레드클래스 상속 받기 */
public class UseThread extends Thread {

	@Override /* 2. run메소드(Runnable인터페이스) 오버라이딩 */
	public void run() {
		/* 3. Thread로 동작되어야 할 코드 : 동시에 실행해야 할 코드 */
		for (int i = 0; i < 1000; i++) {
			System.out.println("run i-------------------> " + i);
		}
	}// run메소드

	/* 6. 비교용 코드 */
	public void test() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("main =============== i = " + i);
		}
	}

	public static void main(String[] args) {
		/* 4. 객체생성 */
		UseThread ut = new UseThread();
		/* 5. Thread클래스-start메소드 호출 : */
		ut.start(); // start메소드 호출시 -> 오버라이딩한 run메소드를 쓰레드로 사용할 수 있다.
		/* 주의 : run메소드를 사용할 경우 */
		// ut.run(); // run을 직접 호출하면 쓰레드를 사용할 수 없다.

		ut.test();

	} // main

}// class
