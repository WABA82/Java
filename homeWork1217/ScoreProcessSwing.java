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

	/* 선택메뉴를 제공 */
	public void inputMenu() {
		String selectedMenu = "", inputResult = "";
		boolean exitFlag = false;
		do {
			selectedMenu = JOptionPane.showInputDialog("메뉴선택\n 1.입력  2.출력  3.종료");
			try {
				switch (parseInt(selectedMenu)) {
				case INPUT_DATA:
					inputResult = "데이터의 갯수가 맞지 않거나, 점수는 숫자형태이어야 합니다.";
					if (inputData()) {
						inputResult = "추가성공";
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
					JOptionPane.showMessageDialog(null, "메뉴는 1,2,3중 하나 이어야 합니다.");
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "메뉴는 숫자 이어야 합니다.");
			}

			/* 무한루프를 종료시키는 방법 */
//			exitFlag = selectedMenu.equals("3");
//			if (selectedMenu.equals("3")) {
//				exitFlag = true;
//				break;
//			}
		} while (!exitFlag);
	}

	/* 정보처리할 데이터를 입력 받기 */
	public boolean inputData() {
		boolean flag = false;
		String inputData = JOptionPane.showInputDialog("데이터입력\n 예)이름,자바점수,오라클점수");
		String[] data = inputData.replaceAll(" ", "").split(",");

		try {
			/* 입력된 형식이 예시)와 같을 때 */
			if (data.length == 3) {
				try {
					/* 점수들은 숫자 이어야합니다. */
					ScoreVO sv = new ScoreVO(data[0], parseInt(data[1]), parseInt(data[2]));
					listStudent.add(sv); // 정제된 데이터를 list에 추가 //
					flag = true; // 실행 결과를 저장 //
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

	/* 입력정보를 출력하는 일 */
	public void printData() {
		if (listStudent.size() == 0) {
			JOptionPane.showMessageDialog(null, "출력할 데이터가 없습니다.");
			return;
		}
		StringBuilder viewData = new StringBuilder();
		viewData.append("---------------------------------------\n").append("번호\t이름\t자바\t오라클\t총점\t평균\n")
				.append("---------------------------------------\n");
		int tempTotal = 0;
		ScoreVO sv = null;
		for (int i = 0; i < listStudent.size(); i++) {
			sv = listStudent.get(i);
			tempTotal = sv.getJavaScore() + sv.getOracleScore();
			viewData.append(i + 1).append("\t").append(sv.getName()).append("\t").append(sv.getJavaScore()).append("\t")
					.append(sv.getOracleScore()).append("\t").append(tempTotal).append("\t").append(tempTotal / 2)
					.append("\n");

			/* 한 학생의 자바점수와 오라클 점수를 더한 값을 누적 합 */
			totalScore += tempTotal;

			/* 다음 학생을 출력하기 위해 변수 초기화 */
			tempTotal = 0;
		}

		viewData.append("---------------------------------------\n").append("\t\t\t\t총점").append(totalScore)
				.append("\t평균").append(String.format("%5.2f", totalScore / (double) (listStudent.size() * 2)));

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
