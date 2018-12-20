package day1115;
/*
Java프로그램 외부에서 Java프로그램 내부로 값을 전달할 때 main method의 Arguments 사용.
실행) java bytecode명 값 값 값
*/
class MainArguments {
	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[0] + args[1]);
		
		//문자열 정수로 변환
		//Integer.parseint(문자열); 문자열을 구분하여 int형으로 변환한 후 그 값을 반환하는 일.
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		
		System.out.println( i * j );
		System.out.println(Integer.parseInt("1111"));
		//메인 메소드 args에 값을 입력할 때는 띄어쓰기로 구분한다.
//		System.out.println(agrs[2]+"님 안녕하세요"); 
	}
}
