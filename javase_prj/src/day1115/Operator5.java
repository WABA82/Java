package day1115;
/*
논리연산자 : 
	-일반논리
		&& : 전항과 후항이 모두 참일때만 참이다.

		|| : 전항과 후항이 모두 거짓일때만 거짓을 반환한다.
	
	-비트논리
		& : 상위비트와 하위비트 모두 1인 경우 1을 내보냄.
		
		| : 상위비트와 하위비트 모두 0인 경우 0을 내보냄.
		
		^ : 상위비트와 하위비트 중에서 둘중 하나만 1인 경우에 1을 내보냄.
*/
class Operator5 {
	public static void main(String[] args) {
		boolean flag1 = true, 
				flag2 = false, 
				flag3 = true, 
				flag4 = false;

		int i = 0, j = 0;

		//앤드 연산
		System.out.println("-------------&&-------------");
		System.out.println(flag1 + "&&" + flag3 + " = " + (flag1 && flag3));
		System.out.println(flag1 + "&&" + flag2 + " = " + (flag1 && flag2));
		System.out.println(flag2 + "&&" + flag1 + " = " + (flag2 && flag1));
		System.out.println(flag2 + "&&" + flag4 + " = " + (flag2 && flag4));

		//오어 연산
		System.out.println("-------------||-------------");
		System.out.println(flag1 + "||" + flag3 + " = " + (flag1 || flag3));
		System.out.println(flag1 + "||" + flag2 + " = " + (flag1 || flag2));
		System.out.println(flag2 + "||" + flag1 + " = " + (flag2 || flag1));
		System.out.println(flag2 + "||" + flag4 + " = " + (flag2 || flag4));


		System.out.println("----------------------------");
		flag1 = false;
		flag2 = false;
		flag3 = false;
		// AND에서 전항이 false이면 후항의 연산을 하지 않는다.
		flag3 = (flag1 = 3>4) && (flag2 = 5>4); //flag2는 true 이지만 flag1이 false이기 때문에 후항까지 연산을 하지 않는다.
		System.out.println("전항 : " + flag1 + ", 후항 : " + flag2 + ", 전체판정 : " + flag3 );

		//비트논리 
		System.out.println("----------------------------");

		i = 28; // 0001 1100
		j = 48; // 0011 0000
		System.out.println(i + " & " + j + " = " + (i&j)); // 16

		i = 16; // 0001 0000
		j = 3;	// 0000 0011
		System.out.println(i + " | " + j + " = " + (i|j)); // 19
		
		i = 10; // 0000 1010
		j = 12; // 0000 1100
		System.out.println(i + " ^ " + j + " = " + (i^j)); // 6



	}
}
