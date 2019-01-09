package day0109;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import day0103.UseConnection;
import day0107.CpEmp2VO;

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
				JOptionPane.showMessageDialog(null, empno + "번 사원정보 추가");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DBMS에 사소한 문제발생");
			} // end switch
		} // end catch

	}// addTestProc

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
//				case "2":
//					rps_crud.modifyCpEmp2();
//					break;
//				case "3":
//					rps_crud.removeCpEmp2();
//					break;
//				case "4":
//					rps_crud.searchAllCpEmp2();
//					break;
//				case "5":
//					rps_crud.searchOneEmp2();
//					break;
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
