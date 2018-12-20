package homeWork1217;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import static java.lang.Integer.parseInt;

public class ScoreProcessSwing {

	private List<ScoreVO> listStudent;
	private int totalScore;

	public static final int INPUT_DATA = 1;
	public static final int VIEW_DATA = 2;
	public static final int EXit = 3;

	public ScoreProcessSwing() {
		listStudent = new ArrayList<ScoreVO>();
	}

	/* ���ø޴��� ���� */
	public void inputMenu() {
		String selectedMenu = "", inputResult = "";
		boolean exitFlag = false;
		do {
			selectedMenu = JOptionPane.showInputDialog("�޴�����\n 1.�Է�  2.���  3.����");
			try {
				switch (parseInt(selectedMenu)) {
				case INPUT_DATA:
					inputResult = "�������� ������ ���� �ʰų�, ������ ���������̾�� �մϴ�.";
					if (inputData()) {
						inputResult = "�߰�����";
					}
					JOptionPane.showMessageDialog(null, inputResult);
					break;
				case VIEW_DATA:
					printData();
					break;
				case EXit:
					exitFlag = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "�޴��� 1,2,3�� �ϳ� �̾�� �մϴ�.");
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�޴��� ���� �̾�� �մϴ�.");
			}

			/* ���ѷ����� �����Ű�� ��� */
//			exitFlag = selectedMenu.equals("3");
//			if (selectedMenu.equals("3")) {
//				exitFlag = true;
//				break;
//			}
		} while (!exitFlag);
	}

	/* ����ó���� �����͸� �Է� �ޱ� */
	public boolean inputData() {
		boolean flag = false;
		String inputData = JOptionPane.showInputDialog("�������Է�\n ��)�̸�,�ڹ�����,����Ŭ����");
		String[] data = inputData.replaceAll(" ", "").split(",");

		try {
			/* �Էµ� ������ ����)�� ���� �� */
			if (data.length == 3) {
				try {
					/* �������� ���� �̾���մϴ�. */
					ScoreVO sv = new ScoreVO(data[0], parseInt(data[1]), parseInt(data[2]));
					listStudent.add(sv); // ������ �����͸� list�� �߰� //
					flag = true; // ���� ����� ���� //
				} catch (NumberFormatException nfe) {
					flag = false;
//				JOptionPane.me
				}
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
		return flag;
	}

	/* �Է������� ����ϴ� �� */
	public void printData() {
		if (listStudent.size() == 0) {
			JOptionPane.showMessageDialog(null, "����� �����Ͱ� �����ϴ�.");
			return;
		}
		StringBuilder viewData = new StringBuilder();
		viewData.append("---------------------------------------\n").append("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���\n")
				.append("---------------------------------------\n");
		int tempTotal = 0;
		ScoreVO sv = null;
		for (int i = 0; i < listStudent.size(); i++) {
			sv = listStudent.get(i);
			tempTotal = sv.getJavaScore() + sv.getOracleScore();
			viewData.append(i + 1).append("\t").append(sv.getName()).append("\t").append(sv.getJavaScore()).append("\t")
					.append(sv.getOracleScore()).append("\t").append(tempTotal).append("\t").append(tempTotal / 2)
					.append("\n");

			/* �� �л��� �ڹ������� ����Ŭ ������ ���� ���� ���� �� */
			totalScore += tempTotal;

			/* ���� �л��� ����ϱ� ���� ���� �ʱ�ȭ */
			tempTotal = 0;
		}

		viewData.append("---------------------------------------\n").append("\t\t\t\t����").append(totalScore)
				.append("\t���").append(String.format("%5.2f", totalScore / (double) (listStudent.size() * 2)));

		JTextArea jtextrea = new JTextArea(7, 50);
		jtextrea.append(viewData.toString());
		JScrollPane jsp = new JScrollPane(jtextrea);
		JOptionPane.showMessageDialog(null, jsp);
	}

	public static void main(String[] args) {
		ScoreProcessSwing spw = new ScoreProcessSwing();
		spw.inputMenu();

	}

}
