package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

import kr.co.sist.memo.evt.MemoFormatEvt;

/*
 * 1. ����Ʈ�� Ŭ���ϸ� item�� ���� �ش� List���� TF�� �����Ǹ鼭 ���Ⱑ ����Ǿ�� �Ѵ�.
 * 2. Ȯ�ι�ư�� Ŭ���Ǹ� ������ Font������ �θ�â�� TA�� �ݿ�.
 * 3. ��� ��ư�� Ŭ���Ǹ� â�� ������ �Ѵ�.
 */
@SuppressWarnings("serial")
public class MemoFormat extends Dialog {

	/* ������(����Ŭ����) ���� */
	private JavaMemo javamemo;

	/* �Ϲ�������Ʈ ���� */
	private TextField tfFonText, tfStyleText, tfSizeText;
	private Label lblPreview;
	private Button btnYes, btnNo;
	private List listFont, listStyle, listSize;

//	Label lblFont

	public MemoFormat(JavaMemo javamemo) {
		super(javamemo, "�۲�", true);
		this.javamemo = javamemo;

		/* �Ϲ�������Ʈ ���� */
		Label lblFont = new Label("�۲�");
		Label lblStyle = new Label("�۲� ��Ÿ��");
		Label lblSize = new Label("ũ��");
		Label lblSee = new Label("����");

		/* JavaMemoŬ������ TA */
		Font fontTa = javamemo.getTaNote().getFont();
		System.out.println(fontTa.getFamily() + "/" + fontTa.getStyle() + "/" + fontTa.getSize());

		// �� ���� //
		lblPreview = new Label("AaBbYyZz");
		lblPreview.setFont(fontTa);

		// �ؽ�Ʈ�ʵ� ���� //
		String[] arrStyle = { "�Ϲ�", "����", "����Ӳ�", "���� ����Ӳ�" };
		tfFonText = new TextField(fontTa.getFamily());
		tfStyleText = new TextField(String.valueOf(arrStyle[fontTa.getStyle()]));
		tfSizeText = new TextField(String.valueOf(fontTa.getSize()));

		// ��ư ���� //
		btnYes = new Button("Ȯ��");
		btnNo = new Button("���");

		// ����Ʈ ���� //
		listFont = new List();
		listStyle = new List();
		listSize = new List();

		// ����Ʈ ��Ʈ //
		listFont.add("Dialog");
		listFont.add("Serif");
		listFont.add("SansSerif");
		listFont.add("Monospaced");
		listFont.add("DialogInput");

		// ����Ʈ ��Ÿ�� //
		for (String style : arrStyle) {
			listStyle.add(style);
		}

		// ����Ʈ ������ //
		int i = 0;
		String temp = "";

		for (i = 2; i < 11; i++) {
			temp = String.valueOf(i);
			listSize.add(temp);
			i = i + 1;
		}

		for (i = 11; i < 81; i++) {
			temp = String.valueOf(i);
			listSize.add(temp);
		}

		/* ���̾ƿ� ���� : ������ġ */
		setLayout(null);

		/* �Ϲ�������Ʈ�� ũ�⼳�� */
		lblFont.setBounds(27, 50, 80, 20);
		tfFonText.setBounds(30, 70, 90, 20);

		lblStyle.setBounds(155, 50, 80, 20);
		tfStyleText.setBounds(155, 70, 90, 20);

		lblSize.setBounds(280, 50, 80, 20);
		tfSizeText.setBounds(280, 70, 90, 20);

		lblSee.setBounds(160, 210, 80, 20);
		lblPreview.setBounds(160, 230, 120, 70);

		listFont.setBounds(30, 100, 90, 85);
		listStyle.setBounds(155, 100, 90, 85);
		listSize.setBounds(280, 100, 90, 85);

		btnYes.setBounds(230, 305, 45, 30);
		btnNo.setBounds(300, 305, 45, 30);

		add(lblFont);
		add(tfFonText);
		add(listFont);

		add(lblStyle);
		add(tfStyleText);
		add(listStyle);

		add(lblSize);
		add(tfSizeText);
		add(listSize);

		add(lblSee);
		add(lblPreview);

		add(btnYes);
		add(btnNo);

		/* �̺�Ʈ ��� */
		MemoFormatEvt mfe = new MemoFormatEvt(this);
		btnYes.addActionListener(mfe);
		btnNo.addActionListener(mfe);

		// ����Ʈ �̺�Ʈ ó��
		listFont.addItemListener(mfe);
		listStyle.addItemListener(mfe);
		listSize.addItemListener(mfe);

		// ���� �̺�Ʈ ó�� //
		addWindowListener(mfe);

		setBounds(javamemo.getX() + 150, javamemo.getY() + 80, 400, 350);

		setResizable(false);

		/* ����ȭ */
		setVisible(true);
	}

	public JavaMemo getJavamemo() {
		return javamemo;
	}

	public TextField getTfFonText() {
		return tfFonText;
	}

	public TextField getTfStyleText() {
		return tfStyleText;
	}

	public TextField getTfSizeText() {
		return tfSizeText;
	}

	public Label getLblPreview() {
		return lblPreview;
	}

	public Button getBtnYes() {
		return btnYes;
	}

	public Button getBtnNo() {
		return btnNo;
	}

	public List getListFont() {
		return listFont;
	}

	public List getListStyle() {
		return listStyle;
	}

	public List getListSize() {
		return listSize;
	}
}