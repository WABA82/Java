package day0109homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class Evt extends WindowAdapter implements ActionListener {

	private View view;
	private StringBuilder sql_createTable;

	public Evt(View view) {
		this.view = view;
	}// �⺻������

	@Override
	public void windowClosing(WindowEvent e) {
		view.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {
		/* ���̺��߰���ư */
		if (e.getSource() == view.getBtn_InsertTab()) {
			btnInsertTabAct();
		}

		/* �÷��߰���ư */
		try {
			if (e.getSource() == view.getBtn_InsertCol()) {
				btnInsersColAct();
			}
		} catch (NullPointerException nfe) {
			JOptionPane.showMessageDialog(view, "���� ���̺��� ������ �ּ���.");
		}

//		if (e.getSource() == view.getJcb_DataTypes()) {
//			System.out.println(view.getJcb_DataTypes().getSelectedItem());
//		} // end if
//
//		if (e.getSource() == view.getJcb_Keys()) {
//			System.out.println(view.getJcb_Keys().getSelectedItem());
//		} // end if

	}// actionPerformed

	public void btnInsertTabAct() {
		String iTabName = view.getJtf_Table().getText().trim();
		view.getJtf_Table().setText("");
		if (iTabName != null && !iTabName.equals("")) {

			sql_createTable = new StringBuilder("create table ");
			sql_createTable.append(iTabName).append("(");

			view.getJta_QueryView().setText(sql_createTable.toString());
			view.getJta_QueryView().append(");");

		} else {
			JOptionPane.showMessageDialog(view, "���̺���� �Է��� �ּ���");
		} // end else

	}// btnInsertTabAct()

	public void btnInsersColAct() {
		StringBuilder sql_insert = new StringBuilder();

		/* �Է°� �������� */
		String iColName = view.getJtf_Column().getText().trim();
		int iDataType = view.getJcb_DataTypes().getSelectedIndex();
		String iDataSize = view.getJft_DataSize().getText().trim();
		int iKeys = view.getJcb_Keys().getSelectedIndex();
		String iKeyName = view.getJtf_KeyName().getText().trim();
		view.getJtf_Column().setText("");
		view.getJft_DataSize().setText("");
		view.getJtf_KeyName().setText("");

		if (!(iColName == null || iColName.equals("")) && !(iDataSize == null || iDataSize.equals(""))) {

			sql_insert.append("\n    ").append(iColName);
			sql_insert.append(" ").append(view.getJcb_DataTypes().getItemAt(iDataType)).append("(").append(iDataSize)
					.append(")");

			if (iKeys != 1 && (iKeyName == null || iKeyName.equals(""))) {
				sql_insert.append(" ").append(view.getJcb_Keys().getItemAt(iKeys)).append("\n");
			} else {
				sql_insert.append(" constraint ").append(iKeyName).append(" primary key\n");
			} // end else

			sql_createTable.append(sql_insert.toString());

			view.getJta_QueryView().setText(sql_createTable.toString());
			view.getJta_QueryView().append(");");

		} else {
			JOptionPane.showMessageDialog(view, "�÷���� ũ��� �ݵ�� �Է��ؾ� �մϴ�.");
		} // end if

	}// btnInsertTabAct()

}// class
