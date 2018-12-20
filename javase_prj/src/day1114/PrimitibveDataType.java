package day1114;
/*
변수 - 기본형 데이터형
정수형 : byte, short, int, long
문자형 : char
실수형 : float, double
Boolean : boolean
*/

class PrimitibveDataType {
	public static void main(String[] args) {
		//정수형
		byte a = 10;
		byte b1=10, b2=20;
		int result = b1 + b2;
		short b = 20;
		int c = 30;
		long d = 40; //할당되는 값이 4byte이므로 literal을 변환할 필요가 없다.
//		long e = 2147483648L; // 4byte가 literal에 저장이 되지 않으므로 literal의 크기를 변경 - 형명시를 해줘야 한다.
		
		System.out.println("byte : " + a + ", short : " + b + ", int : " + c + ", long : " + d);
		System.out.println(result);
		
		//문자형 : unicode 값 : \u0000
		char f = 66; // 66은 대문자B에 대한 유니코드이다.
		char g = '0';
		char h = '가';
		
		System.out.println("char : " + f +", "+ g +", "+ h);

		//실수형 : 
		float j = 3.14F; //형명시 - 우항(실수의 literal은 8byte)이고 좌항(float 데이터형은 4byte이므로) 값 할당을 위해 형명시를 한다.
		double k = 3.14D; //우항의 값과 좌항의 literal이 같으므로 생략이 가능하다.

		System.out.println("float : " + j);
		System.out.println("double : " +k);

		//불린형
		boolean l = true;
		boolean m = false;

		System.out.println("BOOLEAN : " + l +", " + m );
	}//main
}//class
