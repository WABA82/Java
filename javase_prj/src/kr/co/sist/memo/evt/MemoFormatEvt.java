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

	/* 생성자 */
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

		// 미리보기 라벨 변경 설정합니다 //
		Font temp = memoformat.getLblPreview().getFont();
		String font = temp.getFamily();
		int style = temp.getStyle();
		int size = temp.getSize();

		// 선택한 아이템을 TF에 값으로 설정합니다. //
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

		/* 설정된 정보 중 변경된 정보만 가지고 Preview의 글꼴정보를 변경한다 */
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

	/* 미리보기 라벨에서 설정된 폰트 정보를 TA에 설정하는 일을 합니다. */
	public void setTaNoteFont() {
		memoformat.getJavamemo().getTaNote().setFont(memoformat.getLblPreview().getFont());
		try {
			fontStatusSave();
		} catch (IOException e) {
			e.printStackTrace();
		}
		memoformat.dispose();
	}

	/* 설정한 폰트상태를 파일로 저장 - 다음번에 프로그램이 실행되면 현재 저장된 폰트값을 적용하여 TA를 설정하면 변경상태가 유지된다. */
	private void fontStatusSave() throws IOException {
//		BufferedWriter bw = null;
		ObjectOutputStream oos = null;

		try {
			/* 미리보기에 라벨의 설정된 폰트정보를 얻는다. */
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
