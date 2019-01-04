package day0104;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class RunUseStatementCRUD {

	public UseStatementCRUD us_crud;

	public RunUseStatementCRUD() {
		us_crud = new UseStatementCRUD();
	}// ������

	public void addCpDept() {
		String tempData = JOptionPane.showInputDialog("�μ����� �߰�\n�Է� ��) �μ���ȣ,�μ���,��ġ");

		if (tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");
			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;
			} // end if

			int deptno = 0;
			String dname = "";
			String loc = "";
			try {
				deptno = Integer.parseInt(data[0]);
				dname = data[1];
				loc = data[2];
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� ���� �Դϴ�.");
				return;
			} // end catch

			// ó���� �Էµ����͸� VO�� �����ϰ�
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);
			// VO�� ���� DB�� insert �Ѵ�.
			try {
				us_crud.insertCpDeptVO(cdvo);
				JOptionPane.showMessageDialog(null, deptno + "�� �μ����� �߰�");
			} catch (SQLException e) {

				String errMsg = "";
				switch (e.getErrorCode()) {
				case 1:
					errMsg = deptno + "�� �μ��� �̹� �����մϴ�.";
					break;
				case 1438:
					errMsg = "�μ� ��ȣ�� ���ڸ� �Դϴ�.";
					break;
				case 12899:
					errMsg = "�Էµ� �μ��� �Ǵ� ��ġ�� ���̰� �ʹ� ��ϴ�. ";
					break;
				default:
					errMsg = "�˼��մϴ�. ������ �߻��߽��ϴ�. ����� �ٽ� �õ��� �ּ���.";
					break;
				}// end switch
				JOptionPane.showMessageDialog(null, errMsg);
				e.printStackTrace();
			}

		} // end if

	}// addCpDept

	public void modifyCpDept() {
		String tempData = JOptionPane.showInputDialog("�μ����� ����\n �μ���ȣ�� ��ġ�ϴ� �μ���� ��ġ�� �����մϴ�.\n�Է� ��) �μ���ȣ,�μ���,��ġ");

		if (tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");
			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;
			} // end if

			int deptno = 0;
			String dname = "";
			String loc = "";
			try {
				deptno = Integer.parseInt(data[0]);
				dname = data[1];
				loc = data[2];
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� ���� �Դϴ�.");
				return;
			} // end catch

			// ó���� �Էµ����͸� VO�� �����ϰ�
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);
			// VO�� ���� DB�� Update �Ѵ�.
			try {
				String msg = "";
				if (us_crud.UpdateCpDeptVO(cdvo)) {// ����� ���ڵ� ����
					msg = deptno + "�� �μ��� ������ �����Ͽ����ϴ�.";
				} else {// ����� ���ڵ� �������� X
					msg = deptno + "�� �μ��� �������� �ʽ��ϴ�.";
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
	}// modifyCpDept

	public void removeCpDept() {
		String inputData = JOptionPane.showInputDialog("�μ�����\n������ �μ���ȣ �Է�");
		if (inputData != null && !inputData.equals("")) {

			int deptno = 0;
			try {
				deptno = Integer.parseInt(inputData);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� ���� �̾�� �մϴ�.");
				return;
			} // end catch

			try {
				String msg = deptno + "�� �μ��� �������� �ʽ��ϴ�.";
				if (us_crud.deleteCpDeptVO(deptno)) {
					msg = deptno + "�� �μ� ������ �����Ͽ����ϴ�.";
				}
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�.������ �߻��Ͽ����ϴ�.");
			}

		} // end if
	}// removeCpDept

	public void searchAllCpDept() {

		StringBuilder viewCpDept = new StringBuilder();
		viewCpDept.append("-------------------------------------------------------\n");
		viewCpDept.append("��ȣ    �μ���ȣ    �μ���    ��ġ    \n");
		viewCpDept.append("-------------------------------------------------------\n");

		int rowCnt = 0;
		try {
			// DB���� ��ȸ�� ��� �ޱ�
			List<CpDeptVO> list = us_crud.selectAllCpDept();
			CpDeptVO cdv = null;
			rowCnt = list.size();
			for (int i = 0; i < list.size(); i++) {
				cdv = list.get(i);
				viewCpDept.append(i + 1).append("    ");
				viewCpDept.append(cdv.getDeptno()).append("    ");
				viewCpDept.append(cdv.getDname()).append("    ");
				viewCpDept.append(cdv.getLoc()).append("    \n");
			} // end for i

			if (list.isEmpty()) { // list.size() == 0
				viewCpDept.append("�Էµ� �μ������� �������� �ʽ��ϴ�.\n");
			} // end if

		} catch (SQLException e) {
			viewCpDept.append("DBMS���� ������ �߻��߽��ϴ�.\n");
			e.printStackTrace();
		} // end catch

		viewCpDept.append("-------------------------------------------------------\n");
		viewCpDept.append("\t\t��").append(rowCnt).append("���� �μ������� ��ȸ�Ǿ����ϴ�.");

		/* jOptionPane���� ��� �����ֱ� */
		JTextArea jta = new JTextArea(20, 50);
		jta.setEditable(false);
		jta.setText(viewCpDept.toString()); // ������� ��µ����͸� TA�� �����Ѵ�.
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("��ü�μ� ��ȸ ���"));
		JOptionPane.showMessageDialog(null, jsp);
	}// searchAllCpDept

	public void searchOneCpDept() {
		String inputData = JOptionPane.showInputDialog("�μ���ȸ\n��ȸ�� �μ���ȣ �Է�");
		if (inputData != null && !inputData.equals("")) {
			try {
				int deptno = Integer.parseInt(inputData);
				/* �μ���ȣ�� �Է� �ް� �ش��ϴ� ������ ����Ѵ�. */
				// ��ȸ�� �μ��� �ִٸ� ������ ��ü�� ��ȯ�ǰ� ��ȸ�� �μ��� ���ٸ� null��ȯ.//
				OneCpDeptVO ocdvo = us_crud.selectCpDept(deptno);

				StringBuilder viewData = new StringBuilder();
				viewData.append("�μ��� : ").append(ocdvo.getDname());
				viewData.append(", ��ġ : ").append(ocdvo.getLoc());

				JLabel lbl = new JLabel(viewData.toString());
				lbl.setFont(new Font("sansSerif", Font.BOLD, 15));
				JOptionPane.showMessageDialog(null, lbl);

			} catch (NullPointerException npe) {
				// �����ϴ� �μ���ȣ ��� �����ϱ�
				try {
					List<Integer> list = us_crud.selectAllCpDeptNo();
					StringBuilder sb = new StringBuilder();
					for (Integer i : list) {
						sb.append(" ").append(i);
					} // for
					JOptionPane.showMessageDialog(null,
							inputData + "�Է��� �μ���ȣ�� ���� ��ȣ�Դϴ�.\n" + "�μ� ��� :" + sb.toString());
				} catch (SQLException e) {
					e.printStackTrace();
				} // end catch
					// npe.printStackTrace();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� ���� ���·� �Է��ϼž� �մϴ�.");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�. �������� �����߻�!!");
				e.printStackTrace();
			} // end catch
		} // end if

	}// searchAllCpDept

	public static void main(String[] args) {

		RunUseStatementCRUD rus_crud = new RunUseStatementCRUD();

		boolean exitFlag = false;
		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("�޴�����\n1.�μ��߰� 2.�μ����� 3.�μ����� 4.��ü�μ���ȸ 5.Ư���μ���ȸ 6.����");

			// ����ư�� �� Ȯ���� ���� //
//			System.out.println(inputMenu);
			if (inputMenu != null) {
				switch (inputMenu) {
				case "1":
					rus_crud.addCpDept();
					break;
				case "2":
					rus_crud.modifyCpDept();
					break;
				case "3":
					rus_crud.removeCpDept();
					break;
				case "4":
					rus_crud.searchAllCpDept();
					break;
				case "5":
					rus_crud.searchOneCpDept();
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
