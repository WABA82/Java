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
		String tempData = JOptionPane.showInputDialog("������� �߰�\n�Է� ��) �����ȣ,�����,����");

		if (tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");
			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
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
				JOptionPane.showMessageDialog(null, "�����ȣ�� ���� �Դϴ�.");
				return;
			} // end catch

			// ó���� �Էµ����͸� VO�� �����ϰ�
			CpEmp2VO cevo = new CpEmp2VO(empno, sal, ename);
			// VO�� ���� DB�� insert �Ѵ�.
			try {
				ups_dao.insertCpEmp2(cevo);
				JOptionPane.showMessageDialog(null, empno + "�� ������� �߰�");
			} catch (SQLException e) {

				String errMsg = "";
				switch (e.getErrorCode()) {
				case 1438:
					errMsg = "�����ȣ�� 4�ڸ� �̰� ������ 5�ڸ� �Դϴ�.";
					break;
				case 12899:
					errMsg = "�Էµ� ������� �ʹ� ��ϴ�. ";
					break;
				default:
					errMsg = "�˼��մϴ�. ������ �߻��߽��ϴ�. ����� �ٽ� �õ��� �ּ���.";
					break;
				}// end switch
				JOptionPane.showMessageDialog(null, errMsg);
				e.printStackTrace();
			} // end catch
		} // end if

	}// addCpEmp2

	public void modifyCpEmp2() {
		String tempData = JOptionPane.showInputDialog("������� ����\n �����ȣ�� ��ġ�ϴ� ������ ��ġ�� �����մϴ�.\n�Է� ��) �����ȣ,�����,����");

		if (tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");
			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
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
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ ���� �Դϴ�.");
				return;
			} // end catch

			// ó���� �Էµ����͸� VO�� �����ϰ�
			CpEmp2VO cevo = new CpEmp2VO(empno, sal, ename);
			// VO�� ���� DB�� Update �Ѵ�.
			try {
				String msg = "";
				if (ups_dao.updateCpEmp2(cevo)) {// ����� ���ڵ� ����
					msg = empno + "�� ����� ������ �����Ͽ����ϴ�.";
				} else {// ����� ���ڵ� �������� X
					msg = empno + "�� ����� �������� �ʽ��ϴ�.";
				} // end if
				JOptionPane.showMessageDialog(null, msg);

			} catch (SQLException e) {

				String errMsg = "";
				switch (e.getErrorCode()) {
				case 12899:
					errMsg = "�Էµ� �μ��� �Ǵ� ��ġ�� ���̰� �ʹ� ��ϴ�. ";
					break;
				default:
					errMsg = "�˼��մϴ�. ������ �߻��߽��ϴ�. ����� �ٽ� �õ��� �ּ���.";
					break;
				}// end switch
				JOptionPane.showMessageDialog(null, errMsg);
				e.printStackTrace();
			} // end catch
		}
	}// modifyCpEmp2

	public void removeCpEmp2() {
		String inputData = JOptionPane.showInputDialog("�������\n������ �����ȣ �Է�");
		if (inputData != null && !inputData.equals("")) {

			int empno = 0;
			try {
				empno = Integer.parseInt(inputData.trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� ���� �̾�� �մϴ�.");
				return;
			} // end catch

			try {
				String msg = empno + "�� �μ��� �������� �ʽ��ϴ�.";
				if (ups_dao.deleteCpEmp2(empno)) {
					msg = empno + "�� ��������� �����Ͽ����ϴ�.";
				}
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�.������ �߻��Ͽ����ϴ�.");
			}

		} // end if
	}// removeCpEmp2

	public void searchAllCpEmp2() {
		StringBuilder viewCpEmp = new StringBuilder();
		viewCpEmp.append("-------------------------------------------------------\n");
		viewCpEmp.append("��ȣ    �����ȣ    �����    ����    �Ի���    \n");
		viewCpEmp.append("-------------------------------------------------------\n");

		int rowCnt = 0;
		try {
			// DB���� ��ȸ�� ��� �ޱ�
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
				viewCpEmp.append("�Էµ� ��������� �������� �ʽ��ϴ�.\n");
			} // end if

		} catch (SQLException e) {
			viewCpEmp.append("DBMS���� ������ �߻��߽��ϴ�.\n");
			e.printStackTrace();
		} // end catch

		viewCpEmp.append("-------------------------------------------------------\n");
		viewCpEmp.append("\t\t��").append(rowCnt).append("���� ��������� ��ȸ�Ǿ����ϴ�.");

		/* jOptionPane���� ��� �����ֱ� */
		JTextArea jta = new JTextArea(20, 50);
		jta.setEditable(false);
		jta.setText(viewCpEmp.toString()); // ������� ��µ����͸� TA�� �����Ѵ�.
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("��ü��� ��ȸ ���"));
		JOptionPane.showMessageDialog(null, jsp);
	}// searchAllCpEmp2

	public void searchOneEmp2() {
		String inputData = JOptionPane.showInputDialog("�����ȸ\n��ȸ�� �����ȣ �Է�");
		if (inputData != null && !inputData.equals("")) {
			try {
				int empno = Integer.parseInt(inputData);
				/* �����ȣ�� �Է� �ް� �ش��ϴ� ������ ����Ѵ�. */
				// ��ȸ�� ����� �ִٸ� ������ ��ü(CpEmp2OneVO)�� ��ȯ�ǰ� ��ȸ�� ����� ���ٸ� null��ȯ.//
				CpEmp2OneVO ceo_vo = ups_dao.selectOneCpEmp2(empno);

				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy EEEEE");
				StringBuilder viewData = new StringBuilder();
				viewData.append("����� : ").append(ceo_vo.getEname());
				viewData.append(", ���� : ").append(ceo_vo.getSal());
				viewData.append(", �Ի��� : ").append(sdf.format(ceo_vo.getHiredate()));

				JLabel lbl = new JLabel(viewData.toString());
				lbl.setFont(new Font("sansSerif", Font.BOLD, 15));
				JOptionPane.showMessageDialog(null, lbl);

			} catch (NullPointerException npe) {
				JOptionPane.showMessageDialog(null, inputData + "�� �����ȣ�� �������� �ʽ��ϴ�.");
//				// �����ϴ� �μ���ȣ ��� �����ϱ�
//				try {
//					List<Integer> list = us_crud.selectAllCpDeptNo();
//					StringBuilder sb = new StringBuilder();
//					for (Integer i : list) {
//						sb.append(" ").append(i);
//					} // for
//					JOptionPane.showMessageDialog(null,
//							inputData + "�Է��� �μ���ȣ�� ���� ��ȣ�Դϴ�.\n" + "�μ� ��� :" + sb.toString());
//				} catch (SQLException e) {
//					e.printStackTrace();
//				} // end catch

				// npe.printStackTrace();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ���� ���·� �Է��ϼž� �մϴ�.");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�. �������� �����߻�!!");
				e.printStackTrace();
			} // end catch
		} // end if
	}// searchOneEmp2

	public static void main(String[] args) {

		RunPreparedStatement rps_crud = new RunPreparedStatement();

		boolean exitFlag = false;
		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("�޴�����\n1.����߰� 2.������� 3.������� 4.��ü�����ȸ 5.Ư�������ȸ 6.����");

			// ��ư�� �� Ȯ�� //
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
