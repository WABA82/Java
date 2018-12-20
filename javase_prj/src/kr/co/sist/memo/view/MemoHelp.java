package kr.co.sist.memo.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Panel;
import java.awt.TextArea;

import kr.co.sist.memo.evt.MemoHelpEvt;

/*
 * CENTER�� TA ��ġ
 * ����)
 * �޸��� ����
 * �� �޸����� Java�� ����������� ������ �ڵ� ���� �� ������ �� �� �ֽ��ϴ�.
 * ��, �� �ڵ带 ����Ͽ� �������� ������ �ҽ�������  ��Ģ�����Ѵ�. GNU
 * �ۼ��� : ���ü�
 * Version : 1.0;
 */
@SuppressWarnings("serial")
/* DialogŬ���� ��� : Is A */
public class MemoHelp extends Dialog {

	/* JavaMemoŬ���� ���� */
	JavaMemo javamemo;

	/* �Ϲ�������Ʈ ���� */
	TextArea infoTextArea;
	Button okButton;

	public MemoHelp(JavaMemo javamemo) {
		/* JavaMemoŬ���� ���� : Has a ���� */
		super(javamemo, "�� �޸��忡 ���Ͽ�", true);
		this.javamemo = javamemo;

		/* �Ϲ�������Ʈ ���� */
		// TA������Ʈ ���� & �����Ұ� ���� //
		infoTextArea = new TextArea();
		String infoContents = "�޸��� ����\n�� �޸����� Java�� ����������� ������ �ڵ� ���� �� ������ �� �� �ֽ��ϴ�.\n��, �� �ڵ带 ����Ͽ� �������� ������ �ҽ�������  ��Ģ�����Ѵ�. GNU\n�ۼ��� : ���ü�\nVersion : 1.0\n";
		infoTextArea.setText(infoContents);
		// �����Ұ� �����Դϴ�. //
		infoTextArea.setEditable(false);

		// ��ư ������Ʈ ���� //
		okButton = new Button("Ȯ��");

		/* ��ġ */
		// TA : CENTER
		add(BorderLayout.CENTER, infoTextArea);
		// ��ư : SOUTH
		Panel southPanel = new Panel();
		southPanel.add(okButton);
		add(BorderLayout.SOUTH, southPanel);

		/* ũ�� ���� */
		setBounds(javamemo.getX() + 120, javamemo.getY() + 150, 600, 170);
		// ũ�� ��ȯ�Ұ� ���� //
		setResizable(false);

		/* �̺�Ʈ ��ü ���� �� ��� */
		MemoHelpEvt mhe = new MemoHelpEvt(this);
		okButton.addActionListener(mhe);
		addWindowListener(mhe);

		/* ����ȭ */
		setVisible(true);
	}

}
