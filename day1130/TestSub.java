package day1130;


/**
 * @author owner<br>
 * testSuper�� �ڽ� Ŭ����
 *
 */
public class TestSub extends TestSuper {

	int p_j;

	@Override
	public void method() {
		p_i=400;//�ڵ��� ���뼺 //�θ��� ����
		super.p_j=500;//�ڽ��� ��
		
		System.out.println("�ڽ��� �޼ҵ� : " + this.p_i + " / " + this.p_j);
		super.method();
	}
	
	public static void main(String[] args) {
		TestSub ts = new TestSub();
		ts.method();
	}// main

}//class
