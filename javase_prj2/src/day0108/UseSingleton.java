package day0108;

public class UseSingleton {

	public static void main(String[] args) {
		// Singleton Pattern���� ������� ��ü ���.
		// �����ڶ� private�� ������� ���� ������ Ŭ���� �ܺο��� ��üȭ�� ���� �ʴ´�.
		// Singleton s = new Singleton();

		Singleton s = Singleton.getInstance();
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();

		/* ��ü�� �ּҰ� ���ƾ� �̱����̴� */
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}// main

}// class
