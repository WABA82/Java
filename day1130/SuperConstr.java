package day1130;

public class SuperConstr {
	int i;
	
	// �⺻ ������
	public SuperConstr() {
		this(100);
		System.out.println("������ �⺻ ������");
	}

	public SuperConstr(int i) {
		this.i = i;
		System.out.println("������ ���� ������" + this.i);
	}

	
}
