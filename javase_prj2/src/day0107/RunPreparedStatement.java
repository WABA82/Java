package day0107;

import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class RunPreparedStatement {

	private UsePreparedStatementDAO ups_dao;

	public RunPreparedStatement() {
		ups_dao = new UsePreparedStatementDAO();
	}// RunPreparedStatement

	public void addCpEmp2() {
		String tempData = JOptionPane.showInputDialog("사원정보 추가\n입력 예) 사원번호,사원명,연봉");

		if (tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");
			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;
			} // end if

			int empno = 0;
			int sal = 0;
			String ename = "";

			try {
				empno = Integer.parseInt(data[0]);
				ename = data[1];
				sal = Integer.parseInt(data[2]);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호는 숫자 입니다.");
				return;
			} // end catch

			// 처리된 입력데이터를 VO에 설정하고
			CpEmp2VO cevo = new CpEmp2VO(empno, sal, ename);
			// VO의 값을 DB에 insert 한다.
			try {
				ups_dao.insertCpEmp2(cevo);
				JOptionPane.showMessageDialog(null, empno + "번 사원정보 추가");
			} catch (SQLException e) {

				String errMsg = "";
				switch (e.getErrorCode()) {
				case 1438:
					errMsg = "사원번호는 4자리 이고 연봉은 5자리 입니다.";
					break;
				case 12899:
					errMsg = "입력된 사원명이 너무 깁니다. ";
					break;
				default:
					errMsg = "죄송합니다. 문제가 발생했습니다. 잠시후 다시 시도해 주세요.";
					break;
				}// end switch
				JOptionPane.showMessageDialog(null, errMsg);
				e.printStackTrace();
			} // end catch
		} // end if

	}// addCpEmp2

	public void modifyCpEmp2() {
		String tempData = JOptionPane.showInputDialog("사원정보 변경\n 사원번호에 일치하는 사원명과 위치를 변경합니다.\n입력 예) 사원번호,사원명,연봉");

		if (tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");
			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;
			} // end if

			int empno = 0;
			int sal = 0;
			String ename = "";
			try {
				empno = Integer.parseInt(data[0].trim());
				ename = data[1].trim();
				sal = Integer.parseInt(data[2].trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호와 연봉은 숫자 입니다.");
				return;
			} // end catch

			// 처리된 입력데이터를 VO에 설정하고
			CpEmp2VO cevo = new CpEmp2VO(empno, sal, ename);
			// VO의 값을 DB에 Update 한다.
			try {
				String msg = "";
				if (ups_dao.updateCpEmp2(cevo)) {// 변경된 레코드 존재
					msg = empno + "번 사원의 정보를 변경하였습니다.";
				} else {// 변경된 레코드 존재하지 X
					msg = empno + "번 사원은 존재하지 않습니다.";
				} // end if
				JOptionPane.showMessageDialog(null, msg);

			} catch (SQLException e) {

				String errMsg = "";
				switch (e.getErrorCode()) {
				case 12899:
					errMsg = "입력된 부서명 또는 위치의 길이가 너무 깁니다. ";
					break;
				default:
					errMsg = "죄송합니다. 문제가 발생했습니다. 잠시후 다시 시도해 주세요.";
					break;
				}// end switch
				JOptionPane.showMessageDialog(null, errMsg);
				e.printStackTrace();
			} // end catch
		}
	}// modifyCpEmp2

	public void removeCpEmp2() {
		String inputData = JOptionPane.showInputDialog("사원삭제\n삭제할 사원번호 입력");
		if (inputData != null && !inputData.equals("")) {

			int empno = 0;
			try {
				empno = Integer.parseInt(inputData.trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "부서번호는 숫자 이어야 합니다.");
				return;
			} // end catch

			try {
				String msg = empno + "번 부서는 존재하지 않습니다.";
				if (ups_dao.deleteCpEmp2(empno)) {
					msg = empno + "번 사원정보를 삭제하였습니다.";
				}
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "죄송합니다.문제가 발생하였습니다.");
			}

		} // end if
	}// removeCpEmp2

	public void searchAllCpEmp2() {
		StringBuilder viewCpEmp = new StringBuilder();
		viewCpEmp.append("-------------------------------------------------------\n");
		viewCpEmp.append("번호    사원번호    사원명    연봉    입사일    \n");
		viewCpEmp.append("-------------------------------------------------------\n");

		int rowCnt = 0;
		try {
			// DB에서 조회한 결과 받기
			List<CpEmp2AllVO> list = ups_dao.selectAllCpEmp2();
			CpEmp2AllVO ceallvo = null;

			rowCnt = list.size();
			for (int i = 0; i < list.size(); i++) {
				ceallvo = list.get(i);
				viewCpEmp.append(i + 1).append("    ");
				viewCpEmp.append(ceallvo.getEmpno()).append("    ");
				viewCpEmp.append(ceallvo.getName()).append("    ");
				viewCpEmp.append(ceallvo.getSal()).append("    ");
				viewCpEmp.append(ceallvo.getHiredate()).append("    \n");
			} // end for i

			if (list.isEmpty()) { // list.size() == 0
				viewCpEmp.append("입력된 사원정보가 존재하지 않습니다.\n");
			} // end if

		} catch (SQLException e) {
			viewCpEmp.append("DBMS에서 문제가 발생했습니다.\n");
			e.printStackTrace();
		} // end catch

		viewCpEmp.append("-------------------------------------------------------\n");
		viewCpEmp.append("\t\t총").append(rowCnt).append("개의 사원정보가 조회되었습니다.");

		/* jOptionPane으로 출력 보여주기 */
		JTextArea jta = new JTextArea(20, 50);
		jta.setEditable(false);
		jta.setText(viewCpEmp.toString()); // 만들어진 출력데이터를 TA에 설정한다.
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("전체사원 조회 결과"));
		JOptionPane.showMessageDialog(null, jsp);
	}// searchAllCpEmp2

	public void searchOneEmp2() {
		String inputData = JOptionPane.showInputDialog("사원조회\n조회할 사원번호 입력");
		if (inputData != null && !inputData.equals("")) {
			try {
				int empno = Integer.parseInt(inputData);
				/* 사원번호를 입력 받고 해당하는 정보를 출력한다. */
				// 조회한 사원이 있다면 생성된 객체(CpEmp2OneVO)가 반환되고 조회된 사원이 없다면 null반환.//
				CpEmp2OneVO ceo_vo = ups_dao.selectOneCpEmp2(empno);

				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy EEEEE");
				StringBuilder viewData = new StringBuilder();
				viewData.append("사원명 : ").append(ceo_vo.getEname());
				viewData.append(", 연봉 : ").append(ceo_vo.getSal());
				viewData.append(", 입사일 : ").append(sdf.format(ceo_vo.getHiredate()));

				JLabel lbl = new JLabel(viewData.toString());
				lbl.setFont(new Font("sansSerif", Font.BOLD, 15));
				JOptionPane.showMessageDialog(null, lbl);

			} catch (NullPointerException npe) {
				JOptionPane.showMessageDialog(null, inputData + "번 사원번호는 존재하지 않습니다.");
//				// 존재하는 부서번호 목록 제공하기
//				try {
//					List<Integer> list = us_crud.selectAllCpDeptNo();
//					StringBuilder sb = new StringBuilder();
//					for (Integer i : list) {
//						sb.append(" ").append(i);
//					} // for
//					JOptionPane.showMessageDialog(null,
//							inputData + "입력한 부서번호는 없는 번호입니다.\n" + "부서 목록 :" + sb.toString());
//				} catch (SQLException e) {
//					e.printStackTrace();
//				} // end catch

				// npe.printStackTrace();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호는 정수 형태로 입력하셔야 합니다.");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "죄송합니다. 서버에서 문제발생!!");
				e.printStackTrace();
			} // end catch
		} // end if
	}// searchOneEmp2

	public static void main(String[] args) {

		RunPreparedStatement rps_crud = new RunPreparedStatement();

		boolean exitFlag = false;
		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("메뉴선택\n1.사원추가 2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");

			// 버튼의 값 확인 //
			// System.out.println(inputMenu);

			if (inputMenu != null) {
				switch (inputMenu) {
				case "1":
					rps_crud.addCpEmp2();
					break;
				case "2":
					rps_crud.modifyCpEmp2();
					break;
				case "3":
					rps_crud.removeCpEmp2();
					break;
				case "4":
					rps_crud.searchAllCpEmp2();
					break;
				case "5":
					rps_crud.searchOneEmp2();
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
