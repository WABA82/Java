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
				System.out.println(msg);
				JOptionPane.showMessageDialog(null, empno + "�� ������� �߰�");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DBMS�� ����� �����߻�");
			} // end switch
		} // end catch

	}// addTestProc

	public void modifyTestProc() {
		String tempData = JOptionPane.showInputDialog("������� ����\n �����ȣ�� ��ġ�ϴ� ������ ������ �����մϴ�.\n�Է� ��) �����ȣ,����,����");

		if (tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");
			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
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
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ ���� �Դϴ�.");
				return;
			} // end catch

			// ó���� �Էµ����͸� VO�� �����ϰ�
			TestProcUpdateVo tpu_vo = new TestProcUpdateVo(empno, sal, job);
			// VO�� ���� DB�� Update �Ѵ�.
			try {
				String msg = "";
				msg = UseCallableStatementDAO.getInstance().updateProc(tpu_vo);
				JOptionPane.showMessageDialog(null, msg);

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�. ����� �ٽ� �õ��� �ּ���.");
				e.printStackTrace();
			} // end catch
		}
	}// modifyTestProc

	public void removeTestProc() {
		String inputData = JOptionPane.showInputDialog("�������\n������ �����ȣ �Է�");
		if (inputData != null && !inputData.equals("")) {

			int empno = 0;
			try { /* NumberFormatException */
				empno = Integer.parseInt(inputData.trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� ���� �̾�� �մϴ�.");
				return;
			} // end catch

			try { /* SQLException */
				String msg = "";
				msg = UseCallableStatementDAO.getInstance().deleteProc(empno);
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�.������ �߻��Ͽ����ϴ�.");
			} // end catch

		} // end if
	}// removeTestProc

	public void searchAllTestProc() {
		StringBuilder viewTestProc = new StringBuilder();
		viewTestProc.append("-------------------------------------------------------\n");
		viewTestProc.append("��ȣ    �����ȣ    �����    ����    ����    �Ի���   \n");
		viewTestProc.append("-------------------------------------------------------\n");

		int rowCnt = 0;
		try {
			// DB���� ��ȸ�� ��� �ޱ�
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
				viewTestProc.append("�Էµ� ��������� �������� �ʽ��ϴ�.\n");
			} // end if

		} catch (SQLException e) {
			viewTestProc.append("DBMS���� ������ �߻��߽��ϴ�.\n");
			e.printStackTrace();
		} // end catch

		viewTestProc.append("-------------------------------------------------------\n");
		viewTestProc.append("\t\t��").append(rowCnt).append("���� ��������� ��ȸ�Ǿ����ϴ�.");

		/* jOptionPane���� ��� �����ֱ� */
		JTextArea jta = new JTextArea(20, 50);
		jta.setEditable(false);
		jta.setText(viewTestProc.toString()); // ������� ��µ����͸� TA�� �����Ѵ�.
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("��ü��� ��ȸ ���"));
		JOptionPane.showMessageDialog(null, jsp);

	}// searchAllTestProc

	public void searchOneTestProc() {
		String inputData = JOptionPane.showInputDialog("�����ȸ\n��ȸ�� �����ȣ �Է�");
		if (inputData != null && !inputData.equals("")) {
			try {
				int empno = Integer.parseInt(inputData);
				/* �����ȣ�� �Է� �ް� �ش��ϴ� ������ ����Ѵ�. */
				// ��ȸ�� ����� �ִٸ� ������ ��ü(CpEmp2OneVO)�� ��ȯ�ǰ� ��ȸ�� ����� ���ٸ� null��ȯ.//
				TestProcOneVO tpo_vo = UseCallableStatementDAO.getInstance().selectProcOne(empno);

				StringBuilder viewOneTestProc = new StringBuilder();
				viewOneTestProc.append("����� : ").append(tpo_vo.getEname());
				viewOneTestProc.append(", ���� : ").append(tpo_vo.getSal());
				viewOneTestProc.append(", ���� : ").append(tpo_vo.getJob());
				viewOneTestProc.append(", �Ի��� : ").append(tpo_vo.getHiredate());

				JLabel lbl = new JLabel(viewOneTestProc.toString());
				lbl.setFont(new Font("sansSerif", Font.BOLD, 15));

				JOptionPane.showMessageDialog(null, lbl);
			} catch (NullPointerException npe) {
				JOptionPane.showMessageDialog(null, inputData + "�� �����ȣ�� �������� �ʽ��ϴ�.");
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ���� ���·� �Է��ϼž� �մϴ�.");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�. �������� �����߻�!!");
				e.printStackTrace();
			} // end catch

		} // end if
	}// searchOneTestProc

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
