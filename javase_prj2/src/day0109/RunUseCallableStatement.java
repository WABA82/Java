package day0109;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import day0103.UseConnection;
import day0107.CpEmp2VO;

public class RunUseCallableStatement {

	public void addTestProc() {
		String tempData = JOptionPane.showInputDialog("������� �߰�\n�Է� ��) �����ȣ,�����,����, ����");

		if (tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");
			if (data.length != 4) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
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
				JOptionPane.showMessageDialog(null, "�����ȣ ���� �Դϴ�.");
				return;
			} // end catch

			// ó���� �Էµ����͸� VO�� �����ϰ�
			TestProcVO tp_vo = new TestProcVO(empno, sal, ename, job);
			// VO�� ���� DB�� insert �Ѵ�.
			try {
				String msg = "";
				msg = UseCallableStatementDAO.getInstance().insertProc(tp_vo);
				JOptionPane.showMessageDialog(null, empno + "�� ������� �߰�");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DBMS�� ����� �����߻�");
			} // end switch
		} // end catch

	}// addTestProc

	public static void main(String[] args) {

		RunUseCallableStatement rucs = new RunUseCallableStatement();

		boolean exitFlag = false;
		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("�޴�����\n1.����߰� 2.������� 3.������� 4.��ü�����ȸ 5.Ư�������ȸ 6.����");

			// ��ư�� �� Ȯ�� //
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
					JOptionPane.showMessageDialog(null, inputMenu + "�� �����Ǵ� ���񽺰� �ƴմϴ�.");
					break;
				}// end switch

			} else {
				exitFlag = true;
			} // end if

		} while (!exitFlag);

		JOptionPane.showMessageDialog(null, "����� �ּż� �����մϴ�.");
	}// main

}// class
