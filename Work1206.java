
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Work1206 {
	//�ʿ��� �ν��Ͻ� ���� ����
	String m_name;
	int m_score;
	List<String> m_nameList;
	List<Work1206> m_resultList;
	
	//�����ڿ��� �ν��Ͻ� ���� �ʱ�ȭ �� nameList�� �̸� �Ҵ�
	public Work1206() {
		m_name = "";
		m_score = 0;
		m_nameList = new ArrayList<String>();
		m_resultList = new ArrayList<Work1206>();
		
		m_nameList.add("������");
		m_nameList.add("�̺���");
		m_nameList.add("������");
		m_nameList.add("���ü�");
		m_nameList.add("������");
		m_nameList.add("������");
	}
	
	//��������� �̾� �̸��� ������ ����Ʈ�� �����ϴ� �޼���  
	public List<Work1206> setNameAndScore(List<String> nameList) {
		List<Work1206> resultList = new ArrayList<Work1206>();//��� ��ȯ(�̸� + ����)�� ���� ����Ʈ
		Random r = new Random();
		int randPeopleTotal = r.nextInt(nameList.size()-2)+2; // 2�� ~ 6���� ����ó������� �������� �̴´�.
		Work1206 hw = null; //�������� ������ n���� ��� ��ŭ �ο���ŭ ��ȯ�� �迭�� �Ҵ��Ѵ�.
		
		int randPeople = 0; //��� ��ȯ ����Ʈ�� ������ 
		int randScore = 0;
		
		for(int i=0; i<randPeopleTotal; i++) {//���� �������� ������ n���� ��� ��ŭ �ο��� �̴���.
			hw = new Work1206();
			randPeople = r.nextInt(nameList.size()); //��ü�ο� �� �������� 1���� �̴´�.
			randScore = r.nextInt(100); //������ �������� �����Ѵ�.
			
			hw.m_name = nameList.get(randPeople); //Ŭ������ ��������� ��� ���� �̸��� ����
			nameList.remove(randPeople); //���� �̸��� �����.
			hw.m_score = randScore;
			
			resultList.add(hw); //��ȯ�� Ŭ������������ ����Ʈ�� �̸��� ������ ����� Ŭ������ �־��ش�.
		}
		return resultList;
	}
	
	//����� �̸��� ������ ����Ʈ���� ������ �Բ� ����ϴ� �޼���
	public void printNameAndScore(List<Work1206> resultList) {
		int totalScore = 0;//���� ������ ���� ����

		for(int i=0; i<resultList.size(); i++) {
			System.out.print(resultList.get(i).m_name + " " + resultList.get(i).m_score);
			totalScore += resultList.get(i).m_score;
			System.out.println();
		}
		System.out.println("���� " + totalScore + "��");
	}
	
	public static void main(String[] args) {
		Work1206 hw = new Work1206();
		
		hw.m_resultList = hw.setNameAndScore(hw.m_nameList);//��� List�� �̸��� ���� ����
		hw.printNameAndScore(hw.m_resultList);

	}

}
