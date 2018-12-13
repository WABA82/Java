package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;
import kr.co.sist.memo.view.MemoHelp;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo javamemo;

	/* ������ has a */
	public JavaMemoEvt(JavaMemo javamemo) {
		this.javamemo = javamemo;
	}

	/* ���� Ȱ��ȭ */
	@Override
	public void windowClosing(WindowEvent e) {
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
			openMemo();
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
		// ���� : TA�� �ʱ�ȭ �ϱ� ���ؼ��� TA.getText()�޼ҵ带 �ѹ� �����ؾ� �մϴ�. //
		javamemo.getTaNote().getText();
		javamemo.getTaNote().setText("");

		//
		javamemo.setTitle("�޸���-����");
	}

	/* ���� ���� */
	public void openMemo() {
		// ���ϴ��̾�α� ��ü ���� : (���ϴ��̾�αװ� ������ ��ü, ���̾�α��� �̸�(����), ���̾�α� ����) //
		FileDialog fdOpen = new FileDialog(javamemo, "��������", FileDialog.LOAD);
		fdOpen.setVisible(true); // ����ȭ

		// ���̾�α��� �޼ҵ� //
		String filePath = fdOpen.getDirectory(); // ������ ������ ���ã�� �޼ҵ�
		String fileName = fdOpen.getFile(); // ������ ������ �̸�

		if (filePath != null) {
			javamemo.setTitle("�޸���-���� " + filePath + fileName);
		} // end if
	}// openMemo �޼ҵ� ���� //

	/* �ۼ��� �޸� ���� : ������ ���ϸ��� �״�� �����ϴ� ���ϸ� �ݿ�. */
	public void saveMemo() {
		newSaveMemo();
	}

	/* ���ϸ��� �Է¹޾� ���̸����� �����ϴ� �� */
	public void newSaveMemo() {
		// ���ϴ��̾�α� ��ü ���� : (���ϴ��̾�αװ� ������ ��ü, ���̾�α��� �̸�(����), ���̾�α� ����) //
		FileDialog fdSave = new FileDialog(javamemo, "��������", FileDialog.SAVE);
		fdSave.setVisible(true); // ����ȭ

		// ���̾�α��� �޼ҵ� //
		String filePath = fdSave.getDirectory(); // ������ ������ ���ã�� �޼ҵ�
		String fileName = fdSave.getFile(); // ������ ������ �̸�

		if (filePath != null) {
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
