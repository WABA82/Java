package day1121;

/**
 * do ~ while : ���۰� ���� �� �� ����ϴ� �ݺ���, ������ 1���� �����ϰ� ������ �ִٸ� �ִ� ���Ǳ��� �����Ѵ�.<br>
 * ����)<br>
 * do { <br>
 * �ڵ�<br>
 * } while( ���ǹ�);
 *
 * @author owner
 */
public class DoWhile {

	public static void main(String[] args) {

		int i = 0;
		do {
			System.out.println("i = " + i);
			i++;
		} while (i < 10);
		
		//�ԷµǴ� ������ ������ ���
		//Wrapper Class : Integer, Float, Long.....
		i = Integer.parseInt(args[0]);
		
		if ( i > 1 && i <10 ) { //2~9�� ����
			int j = 1;
			do {
				System.out.println( i + " X " + j + " = " + i*j);
				j++;
			} while (j <10);
				
		} else {
			System.out.println("���� 2~9���� �Է� �� �� �ֽ��ϴ�.");
		}

	}// main

}// class
