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
		super(lv, "회원가입", true); // true-모달 : 상위 프레임을 사용할 수 없음.

		JLabel jlTitle = new JLabel("회원가입");
		jlTitle.setFont(new Font("SanSerif", Font.BOLD, 18));

		JLabel[] jlabels = new JLabel[11];
		String[] jblNames = { "아이디", "비밀번호", "비밀번호 확인", "핸드폰", "이메일", "이름", "주민등록번호", "주소", "상세주소", "인증질문", "질문 답" };
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
		String[] emailItems = { "직접입력", "네이버", "다음", "구글" };
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

		jbSearchAddr = new JButton("주소검색"); // 확인다이얼로그 창 보여주기 ["회원가입을 진행하시겠습니까?"]
		jbSignUp = new JButton("회원가입"); // 확인다이얼로그 창 보여주기 ["회원가입을 진행하시겠습니까?"]
		jbCancle = new JButton("취소"); // 확인다이얼로그 창 보여주기 ["정말 취소 하시겠습니까?"]
		jbCheckId = new JButton("ID인증");
		jbCheckSSN = new JButton("인증");

		jcbQuestion = new JComboBox<>();
		jcbQuestion.addItem("출신 초등학교는?");
		jcbQuestion.addItem("태어난 곳은?");
		jcbQuestion.addItem("나의 별명은?");

		jtfQA = new JTextField(20);

		/* 컴포넌트 크기설정 */
		jlTitle.setBounds(160, 50, 100, 20);

		jlabels[0].setBounds(75, 100, 50, 30); // 아이디
		jlabels[1].setBounds(60, 135, 60, 30); // 비밀번호
		jlabels[2].setBounds(30, 170, 85, 30); // 비밀번호 확인
		jlabels[3].setBounds(75, 205, 50, 30); // 핸드폰
		jlabels[4].setBounds(75, 240, 50, 30); // 이메일
		jlabels[5].setBounds(80, 275, 50, 30); // 이름
		jlabels[6].setBounds(30, 310, 85, 30); // 주민번호
		jlabels[7].setBounds(80, 345, 50, 30); // 주소
		jlabels[8].setBounds(60, 415, 60, 30); // 상세주소
		jlabels[9].setBounds(60, 450, 60, 30); // 인증질문
		jlabels[10].setBounds(70, 485, 50, 30); // 질문 답

		// 아이디
		jtfId.setBounds(120, 100, 135, 30);
		jbCheckId.setBounds(260, 100, 80, 30);

		// 비밀번호
		jpfPw1.setBounds(120, 135, 220, 30);
		jpfPw2.setBounds(120, 170, 220, 30);

		// 전화번호
		jtfTel1.setBounds(120, 205, 60, 30);
		telComma1 = new JLabel(" - ");
		telComma1.setBounds(182, 205, 20, 30);
		jtfTel2.setBounds(200, 205, 60, 30);
		telComma2 = new JLabel(" - ");
		telComma2.setBounds(262, 205, 20, 30);
		jtfTel3.setBounds(280, 205, 60, 30);

		// 이메일
		jtfEmail1.setBounds(120, 240, 70, 30);
		emailComma = new JLabel("@");
		emailComma.setBounds(190, 240, 15, 30);
		jtfEmail2.setBounds(205, 240, 70, 30);
		jcbEmail.setBounds(280, 240, 70, 30);

		// 이름
		jtfName.setBounds(120, 275, 220, 30);

		// 주민번호
		jtfSsn1.setBounds(120, 310, 70, 30);
		ssnComma = new JLabel(" - ");
		ssnComma.setBounds(192, 310, 20, 30);
		jtfSsn2.setBounds(205, 310, 70, 30);
		jbCheckSSN.setBounds(280, 310, 60, 30);

		// 주소
		jtfAddress1.setBounds(120, 345, 100, 30);
		jbSearchAddr.setBounds(230, 345, 110, 30);
		jtfAddress2.setBounds(120, 380, 220, 30);
		jtfAddress3.setBounds(120, 415, 220, 30); // 상세주소 입력

		// 인증질문

		jcbQuestion.setBounds(120, 450, 220, 30);

		// 질문 답
		jtfQA.setBounds(120, 485, 220, 30);

		// 버튼
		jbSignUp.setBounds(65, 540, 135, 40);
		jbCancle.setBounds(210, 540, 135, 40);

		/* 배치 */
		setLayout(null);

		add(jlTitle);

		for (int i = 0; i < jlabels.length; i++) { // 라벨배열 배치
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
		add(jtfAddress3);// 상제주소 입력란

		add(jcbQuestion);
		add(jtfQA);

		add(jbSignUp);
		add(jbCancle);

		/* 이벤트 등록 */
		SignUpController suc = new SignUpController(this);
		addWindowListener(suc);// 종료처리

		jbCheckId.addActionListener(suc); // 아이디 인증 버튼
		jcbEmail.addActionListener(suc); // 이메일 콤보 박스
		jbCheckSSN.addActionListener(suc); // 주민번호 검증 버튼
		jbSearchAddr.addActionListener(suc); // 주소검색 버튼

		jbSignUp.addActionListener(suc); // 회원가입 버튼
		jbCancle.addActionListener(suc); // 취소 버튼

		setResizable(false); // 크기 변경 불가
		setBounds(100, 100, 400, 650); // 프레임 크기 설정
		setVisible(true); // 가시호
	}// 매개생성자

	public static void main(String[] args) {
		new SignUpView(null);
	}// main

	/* 이하 getter */
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