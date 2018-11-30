package day1120;


/**
 * for : 시작과 끝을 알 때 사용하는 반복문<br>
 * 문법)<br>
 * for ( 시작값; 조건; 증가할 단위 ) { <br>
 * }
 * 
 * @author owner
 */
public class TestFor {

	public static void main(String[] args) {
		
		//0~에서 부터 9까지 10보다 작을 때 까지 반복 수행하는 for
		for (int i = 0 ; i < 10 ; i++ ) {
			System.out.println(i + "번 안녕");
		}// end for
		
		//1~100까지 1씩 증가하는 for
		//i <= 100을 조건식에 사용할 경우 "작은지와 같은지를 확인"하는 로직이 2번 작용하기 때문에 미만으로 조건을 부여해 주는 것이 좋다.
		for ( int i = 1 ; i < 101 ; i ++) { 
			System.out.println( i );
		}//end for
		
		//1~100까지 출력하고 짝수만 옆으로 출력
		for ( int i = 1 ; i < 101 ; i ++) { 
			if (i%2 == 0 ) {
				System.out.println( "	"+i );
			} else {
				System.out.println(i);
			}
		}//end for
		
		//1에서 100까지 홀수만 출력
		int cnt = 0;
		for ( int i = 1 ; i < 101 ; i += 2) { 
			cnt++;
			System.out.print( "	"+i );
			System.out.println();
		}//end for
		System.out.println("\n" + cnt + "번");
		
		//1~100까지 출력하기 3의 배수마다 숫자대신 "짝"을 출력
		for (int i = 1 ; i < 101 ; i ++ ) {
			if ( (i%3) == 0) {
			 System.out.println("짝");
			} else {
			System.out.println( i );
			}
		}// end if
			
		//1~100까지의 합 출력 : 5050
			int sum = 0;
			for (int j = 1 ; j < 101 ; j++) {
				sum = sum + j;
			}// end if
			System.out.println(sum);
			
		//A(char 65)~Z(char 90)까지 출력
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
