package day1130;


/**
 * @author owner<br>
 *
 */
public class SubConstr extends SuperConstr {
	int i;
	
	public SubConstr() {
//		this(200);
		super();
		System.out.println("자식의 기본 생성자");
	}
	
	public SubConstr(int i) {
//		super(300);
		this();
		System.out.println("자식의 기본 생성자" + i);
	}
}
