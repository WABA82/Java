package kr.co.sist.memo.evt;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import kr.co.sist.memo.view.MemoFormat;

public class MemoFormatEvt extends WindowAdapter implements ActionListener, ItemListener {

	private MemoFormat memoformat;

	/* ������ */
	public MemoFormatEvt(MemoFormat memoformat) {
		this.memoformat = memoformat;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		memoformat.dispose();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		String selectedValue = ((List) e.getSource()).getSelectedItem();

		// �̸����� �� ���� �����մϴ� //
		Font temp = memoformat.getLblPreview().getFont();
		String font = temp.getFamily();
		int style = temp.getStyle();
		int size = temp.getSize();

		// ������ �������� TF�� ������ �����մϴ�. //
		if (e.getSource() == memoformat.getListFont()) {
			memoformat.getTfFonText().setText(selectedValue);
			font = selectedValue;
		}

		if (e.getSource() == memoformat.getListStyle()) {
			memoformat.getTfStyleText().setText(selectedValue);
			style = ((List) e.getSource()).getSelectedIndex();
		}

		if (e.getSource() == memoformat.getListSize()) {
			memoformat.getTfSizeText().setText(selectedValue);
			size = Integer.parseInt(selectedValue);
		}

		/* ������ ���� �� ����� ������ ������ Preview�� �۲������� �����Ѵ� */
		memoformat.getLblPreview().setFont(new Font(font, style, size));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == memoformat.getBtnYes()) {
			setTaNoteFont();
			memoformat.dispose();
		}

		if (e.getSource() == memoformat.getBtnNo()) {
			memoformat.dispose();
		}
	}

	/* �̸����� �󺧿��� ������ ��Ʈ ������ TA�� �����ϴ� ���� �մϴ�. */
	public void setTaNoteFont() {
		memoformat.getJavamemo().getTaNote().setFont(memoformat.getLblPreview().getFont());
		try {
			fontStatusSave();
		} catch (IOException e) {
			e.printStackTrace();
		}
		memoformat.dispose();
	}

	/* ������ ��Ʈ���¸� ���Ϸ� ���� - �������� ���α׷��� ����Ǹ� ���� ����� ��Ʈ���� �����Ͽ� TA�� �����ϸ� ������°� �����ȴ�. */
	private void fontStatusSave() throws IOException {
//		BufferedWriter bw = null;
		ObjectOutputStream oos = null;

		try {
			/* �̸����⿡ ���� ������ ��Ʈ������ ��´�. */
			Font fontTemp = memoformat.getLblPreview().getFont();
			oos = new ObjectOutputStream(new FileOutputStream("c:/dev/temp/memo.dat"));
			oos.writeObject(fontTemp);
			oos.flush();
//			StringBuilder fontData = new StringBuilder();
//			fontData.append(fontTemp.getFamily()).append(",").append(fontTemp.getStyle()).append(",")
//					.append(fontTemp.getSize());
//			bw = new BufferedWriter(new FileWriter("c:/dev/temp/memo.dat"));
//			bw.write(fontData.toString());
//			bw.flush();

		} finally {
			if (oos != null) {
				oos.close();
			}
//			if (bw != null) {
//				bw.close();
//			}
		} // try~catch//
	}
}
