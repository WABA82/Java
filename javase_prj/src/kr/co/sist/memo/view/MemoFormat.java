package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

import kr.co.sist.memo.evt.MemoFormatEvt;

/*
 * 1. 리스트를 클릭하면 item의 값이 해당 List위의 TF에 설정되면서 보기가 변경되어야 한다.
 * 2. 확인버튼이 클릭되면 설정한 Font정보가 부모창의 TA에 반영.
 * 3. 취소 버튼이 클릭되면 창이 닫혀야 한다.
 */
@SuppressWarnings("serial")
public class MemoFormat extends Dialog {

	/* 프레임(수퍼클래스) 선언 */
	private JavaMemo javamemo;

	/* 일반컴포넌트 선언 */
	private TextField tfFonText, tfStyleText, tfSizeText;
	private Label lblPreview;
	private Button btnYes, btnNo;
	private List listFont, listStyle, listSize;

//	Label lblFont

	public MemoFormat(JavaMemo javamemo) {
		super(javamemo, "글꼴", true);
		this.javamemo = javamemo;

		/* 일반컴포넌트 생성 */
		Label lblFont = new Label("글꼴");
		Label lblStyle = new Label("글꼴 스타일");
		Label lblSize = new Label("크기");
		Label lblSee = new Label("보기");

		/* JavaMemo클래스에 TA */
		Font fontTa = javamemo.getTaNote().getFont();
		System.out.println(fontTa.getFamily() + "/" + fontTa.getStyle() + "/" + fontTa.getSize());

		// 라벨 생성 //
		lblPreview = new Label("AaBbYyZz");
		lblPreview.setFont(fontTa);

		// 텍스트필드 생성 //
		String[] arrStyle = { "일반", "굵게", "기울임꼴", "굵음 기울임꼴" };
		tfFonText = new TextField(fontTa.getFamily());
		tfStyleText = new TextField(String.valueOf(arrStyle[fontTa.getStyle()]));
		tfSizeText = new TextField(String.valueOf(fontTa.getSize()));

		// 버튼 생성 //
		btnYes = new Button("확인");
		btnNo = new Button("취소");

		// 리스트 생성 //
		listFont = new List();
		listStyle = new List();
		listSize = new List();

		// 리스트 폰트 //
		listFont.add("Dialog");
		listFont.add("Serif");
		listFont.add("SansSerif");
		listFont.add("Monospaced");
		listFont.add("DialogInput");

		// 리스트 스타일 //
		for (String style : arrStyle) {
			listStyle.add(style);
		}

		// 리스트 사이즈 //
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

		/* 레이아웃 해제 : 수동배치 */
		setLayout(null);

		/* 일반컴포넌트의 크기설정 */
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

		/* 이벤트 등록 */
		MemoFormatEvt mfe = new MemoFormatEvt(this);
		btnYes.addActionListener(mfe);
		btnNo.addActionListener(mfe);

		// 리스트 이벤트 처리
		listFont.addItemListener(mfe);
		listStyle.addItemListener(mfe);
		listSize.addItemListener(mfe);

		// 종료 이벤트 처리 //
		addWindowListener(mfe);

		setBounds(javamemo.getX() + 150, javamemo.getY() + 80, 400, 350);

		setResizable(false);

		/* 가시화 */
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
