package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;
import kr.co.sist.memo.view.MemoHelp;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo javamemo;
	private String taNoteData; // TextArea�� ������ ������ ���� ���� //
	private String openPath; // ������ ���ϸ��� ���� //

	/* ������ has a */
	public JavaMemoEvt(JavaMemo javamemo) {
		this.javamemo = javamemo;
		taNoteData = "";
		openPath = "";
	}

	/* ���� Ȱ��ȭ */
	@Override
	public void windowClosing(WindowEvent e) {
		if (!taNoteData.equals(javamemo.getTaNote().getText())) {
			saveMemo();
		}
		javamemo.dispose();
	}

	/* �����ۿ� ���� ó�� �޼ҵ� */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// 1.miNew, 2.miOpen, 3.miSave, 4.miNewSave, 5.miEnd, 6.miFormat, 7.miHelp //

		// 1. �޴�������_"����" : �̺�Ʈ�� �߻� ���� �� //
		if (ae.getSource() == javamemo.getMiNew()) {
			newMemo();
		}
		// 2. �޴�������_"����" : �̺�Ʈ�� �߻� ���� �� //
		if (ae.getSource() == javamemo.getMiOpen()) {
			try {
				openMemo();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(javamemo, "������ ������ ���� �� �����ϴ�.", "���Ͽ��� ����", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(javamemo, "������ ������ �о���̴� �� ������ �߻�.", "���Ͽ��� ����",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		// 3. �޴�������_"����" : �̺�Ʈ�� �߻� ���� �� //
		if (ae.getSource() == javamemo.getMiSave()) {
			saveMemo();
		}
		// 4. �޴�������_"�ٸ� �̸����� ����" : �̺�Ʈ�� �߻� ���� �� //
		if (ae.getSource() == javamemo.getMiNewSave()) {
			newSaveMemo();
		}
		// 5. �޴�������_"����" : �̺�Ʈ�� �߻� ���� �� //
		if (ae.getSource() == javamemo.getMiEnd()) {
			// ������� ���� ������ �ִٸ� �����ϰ� ���� //
			if (!taNoteData.equals(javamemo.getTaNote().getText())) {
				saveMemo();
			}
			javamemo.dispose();
		}
		// 6. �޴�������_"����" : �̺�Ʈ�� �߻� ���� �� //
		if (ae.getSource() == javamemo.getMiFormat()) {
			formatDialog();
		}
		// 7. �޴�������_"����" : �̺�Ʈ�� �߻� ���� �� //
		if (ae.getSource() == javamemo.getMiHelp()) {
			helpDialog();
		}
	}

	/* "����"��ư�� ������ ��(ActionEvent) = ȣ�� : �ؽ�Ʈ������ �ʱ�ȭ */
	public void newMemo() {
		TextArea tempTa = javamemo.getTaNote();
		boolean flagNew = false;
		// ���忩�� �Ǵ� //
		if (!taNoteData.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(javamemo, "�ٸ� �̸����� �����Ͻðڽ��ϱ�?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				newSaveMemo();
			case JOptionPane.NO_OPTION:
				flagNew = false;
				break;
			default:
				flagNew = true;
			}
		}

		// ���� : TA�� �ʱ�ȭ �ϱ� ���ؼ��� TA.getText()�޼ҵ带 �ѹ� �����ؾ� �մϴ�. //

		if (!flagNew) {
			tempTa.getText();
			tempTa.setText("");
			// ������ �� ���Ŀ��� ����� ��� �ʱ�ȭ //
			taNoteData = tempTa.getText();
			openPath = "";
			javamemo.setTitle("�޸���-����");
		}
	}

	/* ���� ���� */
	public void openMemo() throws IOException, FileNotFoundException {

		// TextArea�� ����� �о�鿴�� ������ �ٸ��ٸ� ���忩�θ� ����� //
		TextArea tempTa = javamemo.getTaNote();
		boolean flagOpen = false;
		if (!taNoteData.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(javamemo, openPath + "\n �����Ͻðڽ��ϱ�?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				if (!openPath.equals("")) {
					if (flag == JOptionPane.OK_OPTION) {
						// ������ �̸��� ���� //
						saveMemo();
					}
				} else {
					// �ٸ� �̸����� ���� //
					newSaveMemo();
				}
			case JOptionPane.NO_OPTION:
				flagOpen = false;
				break;
			default:
				flagOpen = true;
			}
		} // endif//

		if (!flagOpen) {
			// ���ϴ��̾�α� ��ü ���� : (���ϴ��̾�αװ� ������ ��ü, ���̾�α��� �̸�(����), ���̾�α� ����) //
			FileDialog fdOpen = new FileDialog(javamemo, "��������", FileDialog.LOAD);
			fdOpen.setVisible(true); // ����ȭ

			// ���̾�α��� �޼ҵ� //
			String filePath = fdOpen.getDirectory(); // ������ ������ ���ã�� �޼ҵ�
			String fileName = fdOpen.getFile(); // ������ ������ �̸�

			// ������ ������ �����Ѵٸ� //
			if (filePath != null) {
				// ���õ� ���Ϸ� ���ϰ�ü ���� //
				File file = new File(filePath + fileName);
				BufferedReader br = null;

				try {

					br = new BufferedReader(new FileReader(file));
					String temp = "";
					// textArea �ʱ�ȭ //
					javamemo.getTaNote().setText("");
					while ((temp = br.readLine()) != null) {
						tempTa.append(temp + "\n");
					}
					// taNoteData ������ �о� ���� ������ ���� //
					taNoteData = tempTa.getText();
					// ������ ���ϸ��� ���� //
					openPath = file.getAbsolutePath();
				} finally {
					/* nullPoint���� ���� */
					if (br != null) {
						br.close();
					}
				}
				// ������ ��ο� �̸��� Frame�� TitleBar�� ���� //
				javamemo.setTitle("�޸���-���� " + filePath + fileName);
			} // end if
		}
	}// openMemo �޼ҵ� ���� //

	/* �ۼ��� �޸� ���� : ������ ���ϸ��� �״�� �����ϴ� ���ϸ� �ݿ�. */
	public void saveMemo() {
		try {
			if (!openPath.equals("")) {
				createFile(openPath);
			} else {
				newSaveMemo();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createFile(String pathName) throws IOException {
		BufferedWriter bw = null;
		try {

			/* ����ڰ� ���丮���� ������� ������ �� ���� ������ FileŬ������ ����� �ʿ䰡 ����. */
			bw = new BufferedWriter(new FileWriter(pathName));
			bw.write(javamemo.getTaNote().getText());
			bw.flush();

			openPath = pathName;
			taNoteData = javamemo.getTaNote().getText();
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}

	/* ���ϸ��� �Է¹޾� ���̸����� �����ϴ� �� */
	public void newSaveMemo() {
		// ���ϴ��̾�α� ��ü ���� : (���ϴ��̾�αװ� ������ ��ü, ���̾�α��� �̸�(����), ���̾�α� ����) //
		FileDialog fdSave = new FileDialog(javamemo, "��������", FileDialog.SAVE);
		fdSave.setVisible(true); // ����ȭ

		// ���̾�α��� �޼ҵ� //
		String filePath = fdSave.getDirectory(); // ������ ������ ���ã�� �޼ҵ�
		String fileName = fdSave.getFile(); // ������ ������ �̸�

		if (filePath != null) { // �����ư�� ������ �� ���� //
			try {
				createFile(filePath + fileName);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(javamemo, "������ ���� �߻�", "�����߻�", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			javamemo.setTitle("�޸���-���� " + filePath + fileName);
		} // end if
	}// newSaveMemo �޼ҵ� ���� //

	/* �۲��� �����ϴ� ���̾�α׸� �����ϴ� �� */
	public void formatDialog() {
		new MemoFormat(javamemo);
	}

	/* �޸��� ������ �����ϴ� ���̾�α� ���� */
	public void helpDialog() {
		new MemoHelp(javamemo);
	}

}
