package day1120;

/**
 * @author owner continue : �ݺ��� ���� �ݺ����� �ڵ��� ������ �ǳ� �ٴ� ��.<br>
 * 
 */
public class TestContinue {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				continue;
			} // end if
			System.out.println("i = " + i);
		} // end for

	}// main

}// class