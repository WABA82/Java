package day1115;
class Operator1 {
	public static void main(String[] args) {
		int i = 11;
		int j = -11;
		//~(tilde) : 1�� ��������
		System.out.println("~(tilde) : " + "~" +i+ " = " + ~i);
		System.out.println("~(tilde) : " + "~" +j+ " = " + ~j);
		
		System.out.println(); // �ٹٲ� ���

		//!(NOT) : true <--> false
		boolean	b = true; //!b = false
		boolean c = false; //!c = true

		System.out.println("!(NOT) : " + !b); // true --> false
		System.out.println("!(NOT) : " + !c);	// false --> true
		System.out.println("!(NOT) : " + !(11>15)); // 11>15 = false --> !(11>15) = true

		System.out.println(); // �ٹٲ� ���

		// + : ��� ǥ����ȣ - ��������
		System.out.println("+(��� ǥ����ȣ) : "+ "+" +i+ " = " + +i); // +11 = 11�� ����.

		System.out.println(); // �ٹٲ� ���

		// - : ��ȣ�ٲ޿��� ��ȣ
		System.out.println("-(���� ǥ����ȣ) : " + "-" +i+ " = " + -i); // +11 => -11�� ����.
		System.out.println("-(���� ǥ����ȣ) : " + "-" +j+ " = " + -j); // -11 => 11�� ����.

		System.out.println(); // �ٹٲ� ���

		// ++ : ���������ȣ(1�� ����)
		
		//��������
			i = 0;
			j = 10;
			++i;
			--j;
			System.out.println("�������� : i = " + i + ", j = " + j);
			
		
		//��������
			i = 0;
			j = 10;
			i++;
			j--;
			System.out.println("�������� : i = " + i + ", j = " + j);

			//���������ڿ� ���ҿ����ڴ� ���Կ����ڿ� �Բ� ���Ǹ� ������ ������ �ٸ� ���� �����Ѵ�.
		
		i = 0;

		//���� : ���� ����
			j = 0;
			j = ++i;
			System.out.println("�������� : " + i + ", ���� j : " + j);
			
		//���� : ���� �� ����
			j = 0;
			j = i++;
			System.out.println("�������� : " + i + ", ���� j : " + j);
			
	}//main method
}//class Operator1
