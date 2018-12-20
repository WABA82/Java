package day1115;
/*
대입연산자
=,
+=,-=,*=,/=,%=
<<=, >>= , >>>=
&=, |=, ^=
*/
class Operator7 {
	public static void main(String[] args) {
		int i = 3; // 대입연산자

		//삼항대입
		i += 2; // i = i + 2; 5
		i -= 1; // i = i - 1; 4
		i *= 2; // i = i * 2; 8
		i /= 3; // i = i / 2; 4 (자바는 정수/정수 = 정수 때문에 값손실이 발생한다.)
		i %= 3; // i = i % 3; 2 
		System.out.println(i);

		//쉬프트 대입
		i<<=4; // i = i << 4; 
		i>>=1; // i = i >> 1;
//		System.out.println(i);// 디버깅용 : 변수에 들어간 값 확인용
		i>>>=2; // i = i >>> 2;
		System.out.println(i);

		//비트논리 대입
		i &= 12; // i = i & 12;
		i |= 11; // i = i | 11;
		i ^= 5; // i = i ^ 5;
		System.out.println(i);

		

	}
}
