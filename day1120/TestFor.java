package day1120;


/**
 * for : ���۰� ���� �� �� ����ϴ� �ݺ���<br>
 * ����)<br>
 * for ( ���۰�; ����; ������ ���� ) { <br>
 * }
 * 
 * @author owner
 */
public class TestFor {

	public static void main(String[] args) {
		
		//0~���� ���� 9���� 10���� ���� �� ���� �ݺ� �����ϴ� for
		for (int i = 0 ; i < 10 ; i++ ) {
			System.out.println(i + "�� �ȳ�");
		}// end for
		
		//1~100���� 1�� �����ϴ� for
		//i <= 100�� ���ǽĿ� ����� ��� "�������� �������� Ȯ��"�ϴ� ������ 2�� �ۿ��ϱ� ������ �̸����� ������ �ο��� �ִ� ���� ����.
		for ( int i = 1 ; i < 101 ; i ++) { 
			System.out.println( i );
		}//end for
		
		//1~100���� ����ϰ� ¦���� ������ ���
		for ( int i = 1 ; i < 101 ; i ++) { 
			if (i%2 == 0 ) {
				System.out.println( "	"+i );
			} else {
				System.out.println(i);
			}
		}//end for
		
		//1���� 100���� Ȧ���� ���
		int cnt = 0;
		for ( int i = 1 ; i < 101 ; i += 2) { 
			cnt++;
			System.out.print( "	"+i );
			System.out.println();
		}//end for
		System.out.println("\n" + cnt + "��");
		
		//1~100���� ����ϱ� 3�� ������� ���ڴ�� "¦"�� ���
		for (int i = 1 ; i < 101 ; i ++ ) {
			if ( (i%3) == 0) {
			 System.out.println("¦");
			} else {
			System.out.println( i );
			}
		}// end if
			
		//1~100������ �� ��� : 5050
			int sum = 0;
			for (int j = 1 ; j < 101 ; j++) {
				sum = sum + j;
			}// end if
			System.out.println(sum);
			
		//A(char 65)~Z(char 90)���� ���
			for ( char i = 65 ; i < 91 ; i ++ ) {
				System.out.println(i);
			}//end for
			
			for( char c = 'A' ; c < 'Z' ; c++) {
				System.out.println(c);
			}//end for
		
		//2~9 
			for (int i = 2 ; i < 10 ; i++) {
				for (int j = 1 ; j <10 ; j++) {
					System.out.print(i*j);
				}
				System.out.println();
			}
	

			
	}//main

}//class
