package day1129;

/*
���� 1.
��ȣ,�̸�,�ּ�,����,������  ������ �� �ִ� Ŭ������ ����� 
�Ʒ��� ���� ���� �Է��մϴ�.

�Է°�
1, ������, ����� ������ ���ﵿ, 28,����
2, ������, ����� ���빮�� ��ʸ���, 27,����
3, ������, ������ ���뱸 ���뵿, 26,����
4, ���ü�, ����� ���α� ���ε�,27, ����
5, ���ü�, ����� ���۱� �󵵵�,29,����
6, �����, ��⵵ ��õ�� ��õ��,26,����
7, �����, ����� ������ �����絿,27,����
 
1. ���ǰ��� �迭�� �Է��ϴ� method�� �ۼ��Ұ�.
2. �迭�� �Էµ� ���� ����ϴ� method �� �ۼ��Ұ�.
   2-1�� method ���� ����ÿ� ��� �ִ� �ο����� ��� �Ұ�.
   		ex)"����� ������ x��"
   2-2�� method ���� ������ ���� ��� �Ұ�.
   		ex)"���� �� x��"
   2-3�� method ���� ���� ���̰� ���� ����� �̸��� ��� �� ��.
   		ex)"�ְ���� "���ü�(����)"
*/
public class Work {

	private int num;
	private String name;
	private String address;
	private int age;
	private String gender;

	public Work() {

	}

	public Work(int num, String name, String address, int age, String gender) {
		this.num = num;
		this.name = name;
		this.address = address;
		this.age = age;
		this.gender = gender;
	}

//////////////////////////////set �޼ҵ�//////////////////////
	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
//////////////////////////////set �޼ҵ�//////////////////////

//////////////////////////////get �޼ҵ�//////////////////////
	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getAdrress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}
//////////////////////////////get �޼ҵ�//////////////////////

//////////////////////////////print �޼ҵ�////////////////////

//	2. �迭�� �Էµ� ���� ����ϴ� method �� �ۼ��Ұ�.
//	   2-1�� method ���� ����ÿ� ��� �ִ� �ο����� ��� �Ұ�.
//	   		ex)"����� ������ x��"
//	   2-2�� method ���� ������ ���� ��� �Ұ�.
//	   		ex)"���� �� x��"
//	   2-3�� method ���� ���� ���̰� ���� ����� �̸��� ��� �� ��.
//	   		ex)"�ְ���� "���ü�(����)"

	public void printClassArray(Work[] wk) { // ��ü �迭�� �ŰԺ����� �޴� �żҵ�
		System.out.println("--------------��� �޼ҵ� �Դϴ�.-------------------");

		// 2-1�� method ���� ����ÿ� ��� �ִ� �ο����� ��� �Ұ�. ex)"����� ������ x��"
		int addrTemp = 0;
		String addrData = null;
		for (int i = 0; i < wk.length; i++) {
			addrData = wk[i].getAdrress();
			System.out.println(addrData);

			if (addrData.startsWith("�����")) {
				addrTemp++;
			} // end if

		} // end for i
		System.out.println("����ÿ� ��� �ִ� �ο��� : " + addrTemp);

		// 2-2�� method ���� ������ ���� ��� �Ұ�. ex)"���� �� x��"

		int addAge = 0;
		int ageData = 0;
		for (int i = 0; i < wk.length; i++) {
			ageData = wk[i].getAge();
			addAge += ageData;
		}
		System.out.println("method �ο����� ������ �� : " + addAge);

//		2-3�� method ���� ���� ���̰� ���� ����� �̸��� ��� �� ��. ex)"�ְ���� "���ü�(����)"

		int maxAge = 0;
		int comAgeData = 0;
		String person = "";
		for (int i = 0; i < wk.length; i++) {
			comAgeData = wk[i].getAge();
			
			if (maxAge < comAgeData) {
				maxAge = comAgeData;
			}//end if
			
			if (maxAge == wk[i].getAge()) {
				person = wk[i].getName();
			}//end if
		
		}
		System.out.println("���̰� ���� ���� ����� �̸� ��� : " + person);

	}// print �޼ҵ� ��

	public static void main(String[] args) {
		Work[] wk = new Work[7]; // ��ü �迭 ����
		System.out.println(wk.length); // ������ ��ü�迭�� ���� Ȯ��

		wk[0] = new Work(1, "������", "����� ������ ���ﵿ", 28, "����");
		wk[1] = new Work(2, "������", "����� ���빮�� ��ʸ���", 27, "����");
		wk[2] = new Work(3, "������", "������ ���뱸 ���뵿", 26, "����");
		wk[3] = new Work(4, "���ü�", "����� ���α� ���ε�", 27, "����");
		wk[4] = new Work(5, "���ü�", "����� ���۱� �󵵵�", 29, "����");
		wk[5] = new Work(6, "�����", "��⵵ ��õ�� ��õ��", 26, "����");
		wk[6] = new Work(7, "�����", "����� ������ �����絿", 27, "����");

		new Work().printClassArray(wk);
	}

}
