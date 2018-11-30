package day1115;
/*
 숙제
1. 변수에 할당된 값이 양수일때만 2진수로 출력하고 음수라면 ~를 사용하여
    양수로 변경하고 입력된 그대로의 10진수로 출력.
    출력 예)  " 양수 인경우"  10은  1010
                 "음수 인경우"  -10 은 10

2. 2147483647의 값에서 상위 2byte와 하위 2byte 값을 분리하여 출력해보세요. 
    출력 예) 상위 2byte -> 32767
                하위 2byte - > 65535

3. ||를 사용했을 때 전항이 true라면 후항을 연산하지 않는 것을 증명할 수 있는
     코드를 작성하세요.
*/
class Work {
	public static void main(String[] args) {
		
		int i = 10;
		int j = 2147483647;
		boolean flag1, flag2, flag3;


		
		/*
		1. 변수에 할당된 값이 양수일때만 2진수로 출력하고 음수라면 ~를 사용하여 양수로 변경하고 입력된 그대로의 10진수로 출력.
		출력 예)	"양수 인경우"  10은  1010
				"음수 인경우"  -10 은 10
		*/
		System.out.println( i >=0 ? "양수인 경우"+ i + "는(은)" + Integer.toBinaryString(i) : "음수인 경우"+ i + "는(은)" + (~i + 1) );
		
		System.out.println("-------------------------------------------"); // 줄바꿈
		

		/*
		2. 2147483647의 값에서 상위 2byte와 하위 2byte 값을 분리하여 출력해보세요. 
		출력 예) 상위 2byte -> 32767
                하위 2byte - > 65535
		*/
		System.out.println("상위 2byte -> " + (j>>16) + ", 하위 2byte -> " + (j>>47));
		System.out.println("상위 2byte -> " + (j>>16) + ", 하위 2byte -> " + (j&0x0000FFFF));
		
		System.out.println("-------------------------------------------"); // 줄바꿈

		/*
		3. ||를 사용했을 때 전항이 true라면 후항을 연산하지 않는 것을 증명할 수 있는 코드를 작성하세요.
		*/
		
		flag1 = true;
		flag2 = true;
		flag3 = true;

		flag3 =	(flag1 = 1>0) ||
				(flag2 = 1<0); // 후항은 false이나 전항이 true이므로 연산하지 않는다.

		System.out.println("전항 : " + flag1 + ", 후항 : " + flag2  + ", 전체연산 : " + flag3);

		
		
	}
}
