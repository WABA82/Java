package day1114;
/*
1. 아래의 값을 저장할 변수를 만들고 출력해 보세요.

   이니셜 : 'K', 나이 : 자신의나이, 왼눈시력 : 1.5, 오른눈 시력 : 0.8

   출력 : 나의 이니셜은 'K'이고, xx살입니다. 시력은 왼눈 xx, 오른눈 xx입니다.

2. 기본형 데이터형에 대응되는 클래스를 Wrapper Class라고 한다. 
   Java Document에서 Wrapper클래스의 상수가 존재하는지 찾아보고 
   그에 대한 최소값과 최대값을 출력 한다. 
 
   출력 :  byte의 최소값 :  -128  최대값 : 127 
*/
class Work {
	public static void main(String[] args) {
		char initial = 'L';
		int age = 26;
		double l_eye, r_eye;
		l_eye = 1.5;
		r_eye = 0.8;

		System.out.println("나의 이니셜은 "+ initial +"이고, " + age + "살입니다. " + 
							"시력은 왼눈 " + l_eye + ", 오른눈 "+ r_eye + " 입니다.");

		//Wrapper class : Byte
		System.out.println("byte의 최소값 : " + Byte.MIN_VALUE + " 최대값 : " + Byte.MAX_VALUE);

		//Wrapper class : Short
		System.out.println("Short의 최소값 : " + Short.MIN_VALUE + " 최대값 : " + Short.MAX_VALUE);

		//Wrapper class : Integer
		System.out.println("Integer의 최소값 : " + Integer.MIN_VALUE + " 최대값 : " + Integer.MAX_VALUE);

		//Wrapper class : Long
		System.out.println("Long의 최소값 : " + Long.MIN_VALUE + " 최대값 : " + Long.MAX_VALUE);

		//Wrapper class : Float
		System.out.println("Float의 최소값 : " + Float.MIN_VALUE + " 최대값 : " + Float.MAX_VALUE);

		//Wrapper class : Double
		System.out.println("Double의 최소값 : " + Double.MIN_VALUE + " 최대값 : " + Double.MAX_VALUE);

		//Wrapper class : Character
		System.out.println("Character의 최소값 : " + (int)Character.MIN_VALUE + " 최대값 : " + (int)Character.MAX_VALUE);

		//Wrapper class : Boolean
//		System.out.println("Character의 최소값 : " + (char)Boolean.TRUE + " 최대값 : " + (char)Boolean.FALSE);
	}
}
