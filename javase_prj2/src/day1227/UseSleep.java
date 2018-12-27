package day1227;

import java.util.Random;

/**
 * @author owner<br>
 *         쓰레드-Sleep메소드 사용연습 : running 상태에서 block상태로 상태 이전(생명주기)
 *
 */
public class UseSleep implements Runnable {

	@Override
	public void run() {
//		for (int i = 0; i < 10; i++) {
//			System.out.println("2 * " + i + " = " + 2 * i);
//			/* Thread.sleep메소드 호출 : static메소드 입니다. */
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		System.out.print("loading");
		Random r = new Random();
		for (int i = 0; i < 15; i++) {
			System.out.print(" . ");
			try {
				Thread.sleep(100 * r.nextInt(10) + 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("finish");
	}

	public static void main(String[] args) {
		/* 객체생성 */
		UseSleep us = new UseSleep();
		/* 쓰레드 Has A */
		Thread t = new Thread(us);
		/* start */
		t.start();

	}// main

}// class
