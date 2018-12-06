package day1206;

import java.util.Stack;

/**
 * @author owner<br>
 *         Stack : LIFO(last input first output)을 구현한 클래스.
 */
public class UseStack {

	public UseStack() {

		// Stack생성
		Stack<String> stk = new Stack<String>();

		// 값 할당)
		// 부모클래스가 제공하는 메소드는 스택의 고유성을 해칠수 있기 때문에 사용하지 않는다.
		stk.add("수퍼클래스의 메소드 add를 사용");
		stk.push("하셨습니다.");
		stk.push("수고");
		stk.push("오늘도");
		System.out.println(stk);

		for (int i = 0; i < stk.size(); i++) {
			System.out.println(stk.get(i));
		}

		// 사이즈 확인
		System.out.println("크기 : " + stk.size());

		// 값 얻기)
		// 스택에서 데이터를 꺼내면 다음번에는 그 데이터를 사용할 수 없습니다.
		while (!stk.empty()) {
			System.out.println(stk.pop());
		}
	}

	public static void main(String[] args) {
		new UseStack();
	}

}
