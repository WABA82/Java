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
	}// 기본생성자

	@Override
	public void windowClosing(WindowEvent e) {
		view.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {
		/* 테이블추가버튼 */
		if (e.getSource() == view.getBtn_InsertTab()) {
			btnInsertTabAct();
		}

		/* 컬럼추가버튼 */
		try {
			if (e.getSource() == view.getBtn_InsertCol()) {
				btnInsersColAct();
			}
		} catch (NullPointerException nfe) {
			JOptionPane.showMessageDialog(view, "먼저 테이블을 생성해 주세요.");
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
			JOptionPane.showMessageDialog(view, "테이블명을 입력해 주세요");
		} // end else

	}// btnInsertTabAct()

	public void btnInsersColAct() {
		StringBuilder sql_insert = new StringBuilder();

		/* 입력값 가져오기 */
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
			JOptionPane.showMessageDialog(view, "컬럼명과 크기는 반드시 입력해야 합니다.");
		} // end if

	}// btnInsertTabAct()

}// class
