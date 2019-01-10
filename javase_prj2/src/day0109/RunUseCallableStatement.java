package day0109;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import day0110.TestProcAllVO;
import day0110.TestProcOneVO;
import day0110.TestProcUpdateVo;

public class RunUseCallableStatement {

	public void addTestProc() {
		String tempData = JOptionPane.showInputDialog("사원정보 추가\n입력 예) 사원번호,사원명,연봉, 직무");

		if (tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");
			if (data.length != 4) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;
			} // end if

			int empno = 0;
			int sal = 0;
			String ename = "";
			String job = "";
			try {
				empno = Integer.parseInt(data[0]);
				ename = data[1].trim();
				sal = Integer.parseInt(data[2]);
				job = data[3].trim();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호 숫자 입니다.");
				return;
			} // end catch

			// 처리된 입력데이터를 VO에 설정하고
			TestProcVO tp_vo = new TestProcVO(empno, sal, ename, job);
			// VO의 값을 DB에 insert 한다.
			try {
				String msg = "";
				msg = UseCallableStatementDAO.getInstance().insertProc(tp_vo);
				System.out.println(msg);
				JOptionPane.showMessageDialog(null, empno + "번 사원정보 추가");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DBMS에 사소한 문제발생");
			} // end switch
		} // end catch

	}// addTestProc

	public void modifyTestProc() {
		String tempData = JOptionPane.showInputDialog("사원정보 변경\n 사원번호에 일치하는 연봉과 직무를 변경합니다.\n입력 예) 사원번호,직무,연봉");

		if (tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");
			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;
			} // end if

			int empno = 0;
			int sal = 0;
			String job = "";
			try {
				empno = Integer.parseInt(data[0].trim());
				job = data[1].trim();
				sal = Integer.parseInt(data[2].trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호와 연봉은 숫자 입니다.");
				return;
			} // end catch

			// 처리된 입력데이터를 VO에 설정하고
			TestProcUpdateVo tpu_vo = new TestProcUpdateVo(empno, sal, job);
			// VO의 값을 DB에 Update 한다.
			try {
				String msg = "";
				msg = UseCallableStatementDAO.getInstance().updateProc(tpu_vo);
				JOptionPane.showMessageDialog(null, msg);

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "죄송합니다. 잠시후 다시 시도해 주세요.");
				e.printStackTrace();
			} // end catch
		}
	}// modifyTestProc

	public void removeTestProc() {
		String inputData = JOptionPane.showInputDialog("사원삭제\n삭제할 사원번호 입력");
		if (inputData != null && !inputData.equals("")) {

			int empno = 0;
			try { /* NumberFormatException */
				empno = Integer.parseInt(inputData.trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "부서번호는 숫자 이어야 합니다.");
				return;
			} // end catch

			try { /* SQLException */
				String msg = "";
				msg = UseCallableStatementDAO.getInstance().deleteProc(empno);
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "죄송합니다.문제가 발생하였습니다.");
			} // end catch

		} // end if
	}// removeTestProc

	public void searchAllTestProc() {
		StringBuilder viewTestProc = new StringBuilder();
		viewTestProc.append("-------------------------------------------------------\n");
		viewTestProc.append("번호    사원번호    사원명    연봉    직무    입사일   \n");
		viewTestProc.append("-------------------------------------------------------\n");

		int rowCnt = 0;
		try {
			// DB에서 조회한 결과 받기
			List<TestProcAllVO> list = UseCallableStatementDAO.getInstance().selectProcAll();

			TestProcAllVO tpa_vo = null;
			rowCnt = list.size();
			for (int i = 0; i < list.size(); i++) {
				tpa_vo = list.get(i);
				viewTestProc.append(i + 1).append("    ");
				viewTestProc.append(tpa_vo.getEmpno()).append("    ");
				viewTestProc.append(tpa_vo.getEname()).append("    ");
				viewTestProc.append(tpa_vo.getSal()).append("    ");
				viewTestProc.append(tpa_vo.getJob()).append("    ");
				viewTestProc.append(tpa_vo.getHiredate()).append("    \n");

			} // end for i

			if (list.isEmpty()) { // list.size() == 0
				viewTestProc.append("입력된 사원정보가 존재하지 않습니다.\n");
			} // end if

		} catch (SQLException e) {
			viewTestProc.append("DBMS에서 문제가 발생했습니다.\n");
			e.printStackTrace();
		} // end catch

		viewTestProc.append("-------------------------------------------------------\n");
		viewTestProc.append("\t\t총").append(rowCnt).append("개의 사원정보가 조회되었습니다.");

		/* jOptionPane으로 출력 보여주기 */
		JTextArea jta = new JTextArea(20, 50);
		jta.setEditable(false);
		jta.setText(viewTestProc.toString()); // 만들어진 출력데이터를 TA에 설정한다.
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("전체사원 조회 결과"));
		JOptionPane.showMessageDialog(null, jsp);

	}// searchAllTestProc

	public void searchOneTestProc() {
		String inputData = JOptionPane.showInputDialog("사원조회\n조회할 사원번호 입력");
		if (inputData != null && !inputData.equals("")) {
			try {
				int empno = Integer.parseInt(inputData);
				/* 사원번호를 입력 받고 해당하는 정보를 출력한다. */
				// 조회한 사원이 있다면 생성된 객체(CpEmp2OneVO)가 반환되고 조회된 사원이 없다면 null반환.//
				TestProcOneVO tpo_vo = UseCallableStatementDAO.getInstance().selectProcOne(empno);

				StringBuilder viewOneTestProc = new StringBuilder();
				viewOneTestProc.append("사원명 : ").append(tpo_vo.getEname());
				viewOneTestProc.append(", 연봉 : ").append(tpo_vo.getSal());
				viewOneTestProc.append(", 직급 : ").append(tpo_vo.getJob());
				viewOneTestProc.append(", 입사일 : ").append(tpo_vo.getHiredate());

				JLabel lbl = new JLabel(viewOneTestProc.toString());
				lbl.setFont(new Font("sansSerif", Font.BOLD, 15));

				JOptionPane.showMessageDialog(null, lbl);
			} catch (NullPointerException npe) {
				JOptionPane.showMessageDialog(null, inputData + "번 사원번호는 존재하지 않습니다.");
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호는 정수 형태로 입력하셔야 합니다.");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "죄송합니다. 서버에서 문제발생!!");
				e.printStackTrace();
			} // end catch

		} // end if
	}// searchOneTestProc

	public static void main(String[] args) {

		RunUseCallableStatement rucs = new RunUseCallableStatement();

		boolean exitFlag = false;
		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("메뉴선택\n1.사원추가 2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");

			// 버튼의 값 확인 //
			// System.out.println(inputMenu);

			if (inputMenu != null) {
				switch (inputMenu) {
				case "1":
					rucs.addTestProc();
					break;
				case "2":
					rucs.modifyTestProc();
					break;
				case "3":
					rucs.removeTestProc();
					break;
				case "4":
					rucs.searchAllTestProc();
					break;
				case "5":
					rucs.searchOneTestProc();
					break;
				case "6":
					exitFlag = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, inputMenu + "는 제공되는 서비스가 아닙니다.");
					break;
				}// end switch

			} else {
				exitFlag = true;
			} // end if

		} while (!exitFlag);

		JOptionPane.showMessageDialog(null, "사용해 주셔서 감사합니다.");
	}// main

}// class
