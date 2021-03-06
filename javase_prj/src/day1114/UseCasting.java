package day1114;
/*
자동형변환 : 자바에서 int값 이하의 데이터형을 연산하면 자동으로 int데이터타입으로 변환해 주는 것.
강제형변환 : 변수의 데이터형을 일시적으로 변환하여 사용하는 것.
*/

class UseCasting {
	public static void main(String[] args) {
		
		//byte b1 = 10, b2 = 20; //자동형변환
		//int result = b1 + b2; //연산의 결과가 int로 자동형변환된다.
		//System.out.println(b1 + " + " + b2 + " = " + result);

		byte b1 = 10, b2 = 20; //강제형변환
		byte result = (byte)(b1 + b2); //연산의 결과가 int로 자동형변환된다.
		System.out.println(b1 + " + " + b2 + " = " + result);

		double d = 11.14;
		float f = (float)d;

		System.out.println("double : " + d + ", float : " + f);

		float f1 = (float)2018.11; //상수에 사용가능
		System.out.println("f1 : " + f1);

		//long l = (long)2147483648; - 상수값이 literal보다 크다면 casting을 실행하기전에 Error발생00.

		int i = (int)f1;
		System.out.println("int : " +i+ ", float : " + f1);

		char c = 'A';
		System.out.println(c + "의 unicode(ASCll code)값" + (int)c);
		
		//형이(기본형<->참조형) 다르면 강제변환이 되지 않는다.
	//	String s = "11";
	//	int i = (int)s;

	}//main
}//class
