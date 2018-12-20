package day1113;

//지역변수 선언 사용
class UseLocalVariable{
	public static void main(String[] args){
		
		//1. 지역변수 선언 : 데이터형 변수명;
		int i;	
		int j = 11; // 변수의 초기화 : 변수를 선언하면서 값 할당

		//2. 값 할당 : 변수명 = 값;
		i=100;
		
		//3.값 사용 : 출력, 연산, 재할당
		System.out.println(i);
		System.out.println(j);

		//int i = 200; // error 같은 이름의 변수는 만들수 없다.

		//변수명은 한글로 가능하나 일반적으로 사용하지 않는다.
		int 변수=300;
		System.out.println(변수);
	
//		long l = 3000000000L ;
	}

}