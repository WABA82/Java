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
		System.out.println("�ڽ��� �⺻ ������");
	}
	
	public SubConstr(int i) {
//		super(300);
		this();
		System.out.println("�ڽ��� �⺻ ������" + i);
	}
}
