package day1120;


/**
 * 다양한 for의 형태
 * @author owner
 */
public class TestFor2 {
	
	public static void main(String[] args) {
		//무한루프
//		for ( ; ; ) {
//			System.out.println("무한루프");
//		}//end for
//		System.out.println(""); // ERR : 무한루프 다음에 오는 코드는 에러
		
		
		//증가하는 무한루프
		for (int i = 0 ; ; i++) {
			System.out.println(i + "번");
			if(i == 50 ) {
				break; // 이중 for문에서 break는 쓰여져 있는 for문만 빠져나간다.
			}
		}//증가하는 무한루프
		
		//여러개의 변수가 있는 for문
		for (int i = 0 , j = 10, k = 30 ; i < 10; i++, j++, k--) {
			System.out.println(i + " " + j + " " + k);
		}
		
		//조건식을 잘못 설정하면 무한loop
		//for (false) 이면 무한루프를 돈다. 
//		for (int i = 0 ; i  < 10 ; i--) {
//			
//		}
		
		int i = 0;
		for ( i = 0 ; i < 10 ; i ++); {
			System.out.println( "반복문 " + i );
		}
		
	}//main
	
}//class
