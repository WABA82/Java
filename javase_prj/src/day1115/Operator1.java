package day1115;
class Operator1 {
	public static void main(String[] args) {
		int i = 11;
		int j = -11;
		//~(tilde) : 1의 보수연산
		System.out.println("~(tilde) : " + "~" +i+ " = " + ~i);
		System.out.println("~(tilde) : " + "~" +j+ " = " + ~j);
		
		System.out.println(); // 줄바꿈 출력

		//!(NOT) : true <--> false
		boolean	b = true; //!b = false
		boolean c = false; //!c = true

		System.out.println("!(NOT) : " + !b); // true --> false
		System.out.println("!(NOT) : " + !c);	// false --> true
		System.out.println("!(NOT) : " + !(11>15)); // 11>15 = false --> !(11>15) = true

		System.out.println(); // 줄바꿈 출력

		// + : 양수 표현부호 - 생략가능
		System.out.println("+(양수 표현부호) : "+ "+" +i+ " = " + +i); // +11 = 11과 같다.

		System.out.println(); // 줄바꿈 출력

		// - : 부호바꿈연산 부호
		System.out.println("-(음수 표현부호) : " + "-" +i+ " = " + -i); // +11 => -11과 같다.
		System.out.println("-(음수 표현부호) : " + "-" +j+ " = " + -j); // -11 => 11과 같다.

		System.out.println(); // 줄바꿈 출력

		// ++ : 증가연산부호(1씩 증가)
		
		//전위연산
			i = 0;
			j = 10;
			++i;
			--j;
			System.out.println("전위연산 : i = " + i + ", j = " + j);
			
		
		//후위연산
			i = 0;
			j = 10;
			i++;
			j--;
			System.out.println("후위연산 : i = " + i + ", j = " + j);

			//증가연산자와 감소연산자는 대입연산자와 함께 사용되면 전위와 후위가 다른 값을 대입한다.
		
		i = 0;

		//전위 : 내껏 먼저
			j = 0;
			j = ++i;
			System.out.println("전위연사 : " + i + ", 대입 j : " + j);
			
		//후위 : 남의 것 먼저
			j = 0;
			j = i++;
			System.out.println("후위연산 : " + i + ", 대입 j : " + j);
			
	}//main method
}//class Operator1
