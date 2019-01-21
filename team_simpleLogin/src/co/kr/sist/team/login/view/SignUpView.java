package co.kr.sist.team.login.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import co.kr.sist.team.login.controller.SignUpController;

@SuppressWarnings("serial")
public class SignUpView extends JDialog {

	private JTextField jtfId, jtfTel1, jtfTel2, jtfTel3, jtfEmail1, jtfEmail2, jtfName, jtfSsn1, jtfSsn2, jtfAddress1,
			jtfAddress2, jtfAddress3, jtfQA;
	private JLabel telComma1, telComma2, emailComma, ssnComma;
	private JComboBox<String> jcbEmail, jcbQuestion;
	private JPasswordField jpfPw1, jpfPw2;
	private JButton jbSearchAddr, jbSignUp, jbCancle, jbCheckId, jbCheckSSN;

	public SignUpView(LoginView lv) {
		super(lv, "ȸ������", true); // true-��� : ���� �������� ����� �� ����.

		JLabel jlTitle = new JLabel("ȸ������");
		jlTitle.setFont(new Font("SanSerif", Font.BOLD, 18));

		JLabel[] jlabels = new JLabel[11];
		String[] jblNames = { "���̵�", "��й�ȣ", "��й�ȣ Ȯ��", "�ڵ���", "�̸���", "�̸�", "�ֹε�Ϲ�ȣ", "�ּ�", "���ּ�", "��������", "���� ��" };
		for (int i = 0; i < jblNames.length; i++) {
			jlabels[i] = new JLabel(jblNames[i]);
		} // end for

		jtfId = new JTextField(20);
		jpfPw1 = new JPasswordField(20);
		jpfPw2 = new JPasswordField(20);

		jtfTel1 = new JTextField("010");
		jtfTel1.setHorizontalAlignment(JTextField.CENTER);
		jtfTel2 = new JTextField(20);
		jtfTel2.setHorizontalAlignment(JTextField.CENTER);
		jtfTel3 = new JTextField(20);
		jtfTel3.setHorizontalAlignment(JTextField.CENTER);

		jtfEmail1 = new JTextField(20);
		jtfEmail2 = new JTextField(20);
		String[] emailItems = { "�����Է�", "���̹�", "����", "����" };
		jcbEmail = new JComboBox<String>(emailItems);

		jtfName = new JTextField(20);

		jtfSsn1 = new JTextField(20);
		jtfSsn2 = new JTextField(20);

		jtfAddress1 = new JTextField(20);
		jtfAddress1.setEditable(false);
		jtfAddress1.setBackground(Color.WHITE);
		jtfAddress2 = new JTextField(20);
		jtfAddress2.setEditable(false);
		jtfAddress2.setBackground(Color.WHITE);
		jtfAddress3 = new JTextField(20);

		jbSearchAddr = new JButton("�ּҰ˻�"); // Ȯ�δ��̾�α� â �����ֱ� ["ȸ�������� �����Ͻðڽ��ϱ�?"]
		jbSignUp = new JButton("ȸ������"); // Ȯ�δ��̾�α� â �����ֱ� ["ȸ�������� �����Ͻðڽ��ϱ�?"]
		jbCancle = new JButton("���"); // Ȯ�δ��̾�α� â �����ֱ� ["���� ��� �Ͻðڽ��ϱ�?"]
		jbCheckId = new JButton("ID����");
		jbCheckSSN = new JButton("����");

		jcbQuestion = new JComboBox<>();
		jcbQuestion.addItem("��� �ʵ��б���?");
		jcbQuestion.addItem("�¾ ����?");
		jcbQuestion.addItem("���� ������?");

		jtfQA = new JTextField(20);

		/* ������Ʈ ũ�⼳�� */
		jlTitle.setBounds(160, 50, 100, 20);

		jlabels[0].setBounds(75, 100, 50, 30); // ���̵�
		jlabels[1].setBounds(60, 135, 60, 30); // ��й�ȣ
		jlabels[2].setBounds(30, 170, 85, 30); // ��й�ȣ Ȯ��
		jlabels[3].setBounds(75, 205, 50, 30); // �ڵ���
		jlabels[4].setBounds(75, 240, 50, 30); // �̸���
		jlabels[5].setBounds(80, 275, 50, 30); // �̸�
		jlabels[6].setBounds(30, 310, 85, 30); // �ֹι�ȣ
		jlabels[7].setBounds(80, 345, 50, 30); // �ּ�
		jlabels[8].setBounds(60, 415, 60, 30); // ���ּ�
		jlabels[9].setBounds(60, 450, 60, 30); // ��������
		jlabels[10].setBounds(70, 485, 50, 30); // ���� ��

		// ���̵�
		jtfId.setBounds(120, 100, 135, 30);
		jbCheckId.setBounds(260, 100, 80, 30);

		// ��й�ȣ
		jpfPw1.setBounds(120, 135, 220, 30);
		jpfPw2.setBounds(120, 170, 220, 30);

		// ��ȭ��ȣ
		jtfTel1.setBounds(120, 205, 60, 30);
		telComma1 = new JLabel(" - ");
		telComma1.setBounds(182, 205, 20, 30);
		jtfTel2.setBounds(200, 205, 60, 30);
		telComma2 = new JLabel(" - ");
		telComma2.setBounds(262, 205, 20, 30);
		jtfTel3.setBounds(280, 205, 60, 30);

		// �̸���
		jtfEmail1.setBounds(120, 240, 70, 30);
		emailComma = new JLabel("@");
		emailComma.setBounds(190, 240, 15, 30);
		jtfEmail2.setBounds(205, 240, 70, 30);
		jcbEmail.setBounds(280, 240, 70, 30);

		// �̸�
		jtfName.setBounds(120, 275, 220, 30);

		// �ֹι�ȣ
		jtfSsn1.setBounds(120, 310, 70, 30);
		ssnComma = new JLabel(" - ");
		ssnComma.setBounds(192, 310, 20, 30);
		jtfSsn2.setBounds(205, 310, 70, 30);
		jbCheckSSN.setBounds(280, 310, 60, 30);

		// �ּ�
		jtfAddress1.setBounds(120, 345, 100, 30);
		jbSearchAddr.setBounds(230, 345, 110, 30);
		jtfAddress2.setBounds(120, 380, 220, 30);
		jtfAddress3.setBounds(120, 415, 220, 30); // ���ּ� �Է�

		// ��������

		jcbQuestion.setBounds(120, 450, 220, 30);

		// ���� ��
		jtfQA.setBounds(120, 485, 220, 30);

		// ��ư
		jbSignUp.setBounds(65, 540, 135, 40);
		jbCancle.setBounds(210, 540, 135, 40);

		/* ��ġ */
		setLayout(null);

		add(jlTitle);

		for (int i = 0; i < jlabels.length; i++) { // �󺧹迭 ��ġ
			add(jlabels[i]);
		} // end for

		add(jtfId);
		add(jbCheckId);

		add(jpfPw1);
		add(jpfPw2);

		add(jtfTel1);
		add(telComma1);
		add(jtfTel2);
		add(telComma2);
		add(jtfTel3);

		add(jtfEmail1);
		add(emailComma);
		add(jtfEmail2);
		add(jcbEmail);

		add(jtfName);

		add(jtfSsn1);
		add(ssnComma);
		add(jtfSsn2);
		add(jbCheckSSN);

		add(jtfAddress1);
		add(jbSearchAddr);
		add(jtfAddress2);
		add(jtfAddress3);// �����ּ� �Է¶�

		add(jcbQuestion);
		add(jtfQA);

		add(jbSignUp);
		add(jbCancle);

		/* �̺�Ʈ ��� */
		SignUpController suc = new SignUpController(this);
		addWindowListener(suc);// ����ó��

		jbCheckId.addActionListener(suc); // ���̵� ���� ��ư
		jcbEmail.addActionListener(suc); // �̸��� �޺� �ڽ�
		jbCheckSSN.addActionListener(suc); // �ֹι�ȣ ���� ��ư
		jbSearchAddr.addActionListener(suc); // �ּҰ˻� ��ư

		jbSignUp.addActionListener(suc); // ȸ������ ��ư
		jbCancle.addActionListener(suc); // ��� ��ư

		setResizable(false); // ũ�� ���� �Ұ�
		setBounds(100, 100, 400, 650); // ������ ũ�� ����
		setVisible(true); // ����ȣ
	}// �Ű�������

	public static void main(String[] args) {
		new SignUpView(null);
	}// main

	/* ���� getter */
	public JTextField getJtfId() {
		return jtfId;
	}

	public JTextField getJtfTel1() {
		return jtfTel1;
	}

	public JTextField getJtfTel2() {
		return jtfTel2;
	}

	public JTextField getJtfTel3() {
		return jtfTel3;
	}

	public JTextField getJtfEmail1() {
		return jtfEmail1;
	}

	public JTextField getJtfEmail2() {
		return jtfEmail2;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfSsn1() {
		return jtfSsn1;
	}

	public JTextField getJtfSsn2() {
		return jtfSsn2;
	}

	public JTextField getJtfAddress1() {
		return jtfAddress1;
	}

	public JTextField getJtfAddress2() {
		return jtfAddress2;
	}

	public JTextField getJtfAddress3() {
		return jtfAddress3;
	}

	public JTextField getJtfQA() {
		return jtfQA;
	}

	public JLabel getTelComma1() {
		return telComma1;
	}

	public JLabel getTelComma2() {
		return telComma2;
	}

	public JLabel getEmailComma() {
		return emailComma;
	}

	public JLabel getSsnComma() {
		return ssnComma;
	}

	public JComboBox<String> getJcbEmail() {
		return jcbEmail;
	}

	public JComboBox<String> getJcbQuestion() {
		return jcbQuestion;
	}

	public JPasswordField getJpfPw1() {
		return jpfPw1;
	}

	public JPasswordField getJpfPw2() {
		return jpfPw2;
	}

	public JButton getJbSearchAddr() {
		return jbSearchAddr;
	}

	public JButton getJbSignUp() {
		return jbSignUp;
	}

	public JButton getJbCancle() {
		return jbCancle;
	}

}// class