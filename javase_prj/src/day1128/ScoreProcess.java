package day1128;

/**
 * @author owner<br>
 *         �迭�� �̿��� ����ó�� ���α׷�
 *
 */
public class ScoreProcess {

	private int[] scoreArr = { 89, 76, 99, 64, 50 };
	private String[] nameArr = { "������", "���ü�", "������", "��ǿ�", "������" };

	public ScoreProcess() {

		System.out.println("��ȣ\t�̸�\t����");
		System.out.println("-----------------------");
		int totalScore = 0; // ���� ���� ��
		int maxScore = 0; // �ְ���
		int minScore = 101;// ������ : 100���� �������� �� ���� �ִٴ� �����Ͽ� 101�� �־���
		for (int i = 0; i < nameArr.length; i++) {
			System.out.printf("%d\t%s\t%d\n", i + 1, nameArr[i], scoreArr[i]);
			totalScore += scoreArr[i];

			if (maxScore < scoreArr[i]) {
				// if�� ���ǹ��� true�̸�, ���� ��ȯ���� ���� ������ ����
				maxScore = scoreArr[i];
			} // ���ǹ� ��

			if (minScore > scoreArr[i]) {
				// if�� ���ǹ��� true�̸�, ���� ��ȯ���� ���� ������ ����
				minScore = scoreArr[i];
			} // ���ǹ� ��

		}
		System.out.println("-----------------------");
		System.out.println("�����ο� : " + nameArr.length + "�� �Դϴ�.");
		
		// '��� [%.2f]'�� �ۼ� - �Ǽ�, �������� �ֱ� ���ؼ���'��� [%d]'��
		System.out.printf("���� [%5d] ��� [%.2f] \n", totalScore, (double) totalScore / nameArr.length); 
		System.out.printf("�ְ��� [%3d], ������ [%3d] \n", maxScore, minScore);

//		-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println();
		System.out.println("������ ��������(�𼾵�)���� �����غ���-------------------------------�ڹ��� �������� �迭�� ũ�� �ٲٴ� �κ� �о��");

		int temp = 0;//���İ��� �ӽ÷� ����
		for (int i = 0; i < scoreArr.length-1; i++) {
			for (int j = i+1; j < scoreArr.length; j++) {
				if (scoreArr[i] < scoreArr[j]) { //�� �ε��� ���� �ٷ� ���� �ε��� ������ �۴ٸ�...
					temp = scoreArr[i];
					scoreArr[i] = scoreArr[j];
					scoreArr[j] = temp;
				}//if ��
			}//�߰� for ��
		}//for ��
		
		for(int i = 0 ; i < scoreArr.length ; i++) {
			System.out.printf("%4d",scoreArr[i]);
		}

	}// ������

	public static void main(String[] args) {

		new ScoreProcess();

	}// ���� �޼ҵ� ��

}// Ŭ���� �ʵ� ��
