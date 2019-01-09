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
		if (e.getSource() == view.getBtn_InsertCol()) {
			btnInsersColAct();
		}
	}// actionPerformed

	public void btnInsertTabAct() {
		String iTabName = view.getJtf_Table().getText().trim();
		view.getJtf_Table().setText("");

		sql_createTable = new StringBuilder("create table ");
		sql_createTable.append(iTabName).append("();");

	}// btnInsertTabAct()

	public void btnInsersColAct() {
		String iColName = view.getJtf_Table().getText().trim();
		String iDataType = view.getJcb_DataTypes().getSelectedItem().toString();
		String iDataSize = view.getJft_DataSize().getText().trim();
		String iKey = view.getJcb_Keys().getSelectedItem().toString();
		String iKeyName = view.getJtf_KeyName().getText().trim();
		view.getJtf_Column().setText("");
		view.getJft_DataSize().setText("");
		view.getJtf_KeyName().setText("");

		int Inidx = sql_createTable.indexOf("(");
		StringBuilder sql_insert = new StringBuilder();
		if (iColName != null && iColName.equals("") && iDataSize != null && !iDataSize.equals("")) {
			sql_insert.append(iColName);
			sql_insert.append(" ").append(iDataType).append("(").append(iDataSize).append(")");
			sql_createTable.insert(Inidx, "\n");

			if (iKey != null && !iKey.equals("")) {
				sql_insert.append(" ").append(iKey);
			} // end if
		} else {
			JOptionPane.showMessageDialog(view, "컬럼명과 크기는 반드시 입력해야 합니다.");
		} // end if

	}// btnInsertTabAct()

}// class
