package day1227;

import java.util.Random;

/**
 * @author owner<br>
 *         ������-Sleep�޼ҵ� ��뿬�� : running ���¿��� block���·� ���� ����(�����ֱ�)
 *
 */
public class UseSleep implements Runnable {

	@Override
	public void run() {
//		for (int i = 0; i < 10; i++) {
//			System.out.println("2 * " + i + " = " + 2 * i);
//			/* Thread.sleep�޼ҵ� ȣ�� : static�޼ҵ� �Դϴ�. */
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
		/* ��ü���� */
		UseSleep us = new UseSleep();
		/* ������ Has A */
		Thread t = new Thread(us);
		/* start */
		t.start();

	}// main

}// class
