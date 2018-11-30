package day1130;

public class SuperConstr {
	int i;
	
	// 기본 생성자
	public SuperConstr() {
		this(100);
		System.out.println("수퍼의 기본 생성자");
	}

	public SuperConstr(int i) {
		this.i = i;
		System.out.println("수퍼의 인자 생성자" + this.i);
	}

	
}
