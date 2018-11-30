package day1128;

/**
 * @author owner<br>
 *         �л��� ����Ŭ,�ڹ�,JDBC ���� ������ ó���ϴ� ���α׷�
 *
 */
public class ScoreProcess2 {
	private int total;// ���ھ� 2���� �迭�� �� ���� ���� ��� ����
	private int subTotal; // �� ������ ������ ��� ����
	private int allSubTotal; // ������ ������ ������ ��� ����
	private int[] maxscore;


	public ScoreProcess2() {
		total = 0;// �ʱ�ȭ
		subTotal = 0;// �ʱ�ȭ
		allSubTotal = 0; // �ʱ�ȭ
		maxscore = new int[3]; //�ʱ�ȭ
	}// ������;

	/**
	 * ���� ����<br>
	 *
	 * @param score
	 */
	public void addTotal(int score) {
		total += score;
	}// addTotal

	/**
	 * ������ ��� ��<br>
	 *
	 * @return
	 */
	public int getTotal() {
		return total;
	}// getTotal

	/**
	 * ���� ���<br>
	 *
	 * @param score<br>
	 */
	public double avgTotal(int scoreleng) {
		return (double) total / scoreleng;
	}

	/**
	 * total���� �ʱ�ȭ<br>
	 */
	public void resetTotal() {
		total = 0;
	}// retTotal

	// 2. �� ����� ������ ������ ����////////////////////////////////////////////////

	/**
	 * �� ������ ������ ���� - �ν��Ͻ� ���� subTotal�� ��� �޼ҵ�
	 * 
	 * @param subScore - for���� ���� score[][] �迭�� �� [3]���� [6]����
	 */
	public void addSubTotal(int subScore) { // �� ������ ������ ���� subTotal������ ��� �޼ҵ�
		subTotal = subTotal + subScore;
	}

	public void resetSubTotal() { // for������ subTotal�� �ʱ�ȭ �ϴ� �޼ҵ�
		subTotal = 0;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public double avgSubTotal(int scoreleng) {
		return (double) subTotal / scoreleng;
	}

	public void addAllSubTotal(int subScore) { // ��� ������ ������ ���� allSubTotal������ ��� �޼ҵ�
		allSubTotal = allSubTotal + subScore;
	}

	public void resetAllSubTotal() {
		allSubTotal = 0;
	}

	public int getAllSubTotal() {
		return allSubTotal;
	}

	public double avgAllSubTotal(int scoreleng) {
		return (double) allSubTotal / scoreleng;
	}

/////////////////////////////////////////////�Ű� ���� �޼ҵ�////////////////////////////////////////////////

	public String[] nameData() {
		String[] name = { "������", "������", "���ü�", "������", "������", "�����" };
		return name;
	}// �̸� �迭) ������ �޼ҵ�

	public int[][] scoreData() {
		int[][] score = { { 85, 86, 81 }, { 95, 91, 100 }, { 89, 71, 59 }, { 97, 96, 91 }, { 78, 74, 77 },
				{ 100, 95, 68 } }; // 6�� 3��.
		return score;
	}// ���ھ� 2���� �迭) ������ �޼ҵ�

////////////////////////////////////////////////��� �޼ҵ�////////////////////////////////////////////////

	public void printScore(String[] name, int[][] score) {

		// ����. - ��� ���� �մ��� �Ű������� ��ȭ���� ����Ͽ� �޼ҵ�� �����Ͽ� ȣ���ϰ� ���� ������ ����� ����Ѵ�.
		// 1. �� �л��� ��� ���Ͽ� ���(�Ҽ� ���� 1�ڸ� ���� ���).
		System.out.println("----------------------------------------------------\n");

		System.out.println("��ȣ\t�̸�\tOracle\tJava\tJDBC\t����\t���");
		System.out.println("----------------------------------------------------");
		for (int i = 0; i < score.length; i++) { // score.length - 6�� ��� (����)
			System.out.printf("[%d]\t[%s]\t", i + 1, name[i]); // [��ȣ] [�̸�]
			for (int j = 0; j < score[i].length; j++) { // score[i].length - [i]���� 3�� ���(����)
				System.out.printf("[%d]\t", score[i][j]); // score[3��][6��] - [����Ŭ] [�ڹ�] [JDBC]
				addTotal(score[i][j]); // �������ϴ� �޼ҵ�
			}
			System.out.printf("[%d]\t[%.1f]\n", getTotal(), avgTotal(score[i].length));
			resetTotal();
		} // for ����
		System.out.println("----------------------------------------------------\n");

		// 2. �� ����� ������ ������ ����////////////////////////////////////////////////////
		System.out.println("----------------------�� ������ ����--------------------\n");

		System.out.println("[Orcle]\t[Java]\t[JDBC]\t[������ ����]");
		for (int i = 0; i < score[0].length; i++) { // ��
			for (int j = 0; j < score.length; j++) {// ��
				addSubTotal(score[j][i]); // subTotal ������ �� ���
				addAllSubTotal(score[j][i]); // allSubTotal ������ �� ���
			} // end for j
			System.out.printf("[%4d] \t", getSubTotal()); // �� ������ ���� ���
			resetSubTotal(); // ���� ������ ����ϱ� ���� ������ �ʱ�ȭ �Ѵ�.
		} // end for i
		System.out.printf("[%8d] \n", getAllSubTotal()); // ������ ���� ���
		resetAllSubTotal(); // ����� ���� �� ���� ���� allSubTotal�� �ʱ�ȭ ���ش�.

		System.out.println(); // 2. �� ����� ������ ������ ���� ��////////////////////////////

		// 3. �� ����� ��հ� ��ü�� ���(��ü ����� �Ҽ����� ���ڸ����� ���)
		System.out.println("----------------------�� ������ ���--------------------\n");

		System.out.println("[Orcle���]\t[Java���]\t[JDBC���]\t[���� ���]");

		for (int i = 0; i < score[0].length; i++) {
			for (int j = 0; j < score.length; j++) {
				addSubTotal(score[j][i]);
				addAllSubTotal(score[j][i]);
			}
			System.out.printf("[%7.2f]\t", avgSubTotal(score.length));
			resetSubTotal();
		} // end for i
		System.out.printf("[%7.2f]", avgAllSubTotal(score.length));

		System.out.println(); // 3. �� ����� ��հ� ��ü�� ��� ��////////////////////////////

		// 4. �� ����� �ְ� ������ ���
		System.out.println("----------------------�� ������ �ְ���--------------------\n");

		System.out.println("[Orcle�ְ�]\t[Java�ְ�]\t[JDBC�ְ�]");

		for (int i = 0; i < score[i].length; i++) { // �� 1�� ���� �� 6�� ������ for
			for (int j = 0; j < score.length; j++) { // �� ���� for
				if (maxscore[i] < score[j][i]) {
					maxscore[i] = score[j][i];
				}
			}
		}

		System.out.printf("[Ora : %d]\t[Java : %d]\t [JDBC : %d] \n", maxscore[0], maxscore[1], maxscore[2]);

		System.out.println(); // 4. �� ����� �ְ� ������ ��� �� /////////////////////////////

		// 5. �ϵ��л��� �̸� ���� ��ȣ
		System.out.println("----------------------�ϵ��л� ���ϱ�--------------------\n");
		int top = 0;
		for (int i = 0; i < score.length; i++) { // ��
			for (int j = 0; j < score[i].length; j++) { // ��
				addTotal(score[i][j]);
				if(top < score[i][j]) {
					top = score[i][j];
				}
			}
		}
		
		System.out.println(top);
		
		System.out.println(); // 5. �� ����� �ְ� ������ ��� �� /////////////////////////////
		
		
		// 6. �ڹ������� �������� �����Ͽ� ���.

	}// ����Ʈ �޼ҵ�
//      2.����)2���� �迭�� ����� ������ �������� ����� �Ʒ��� ���� ���� �־� ����ϴ� �޼ҵ� �ۼ�.
//      1 1 1 1 1 1 1 1 1<br>
//      1 0 0 0 0 0 0 0 1<br>
//      1 0 0 0 0 0 0 0 1<br>
//      1 0 0 0 0 0 0 0 1<br>
//      1 0 0 0 0 0 0 0 1<br>
//      1 1 1 1 1 1 1 1 1<br>
///////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		ScoreProcess2 sp2 = new ScoreProcess2();
		// ó���� ������ �ޱ�
		String[] name = sp2.nameData();
		int[][] score = sp2.scoreData();
		// ó��
		sp2.printScore(name, score);
	}// ���� �޼ҵ�
}// Ŭ���� �ʵ�