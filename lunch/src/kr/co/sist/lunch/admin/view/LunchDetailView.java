package kr.co.sist.lunch.admin.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.controller.LunchDetailController;
import kr.co.sist.lunch.admin.controller.LunchMainController;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;

/**
 * 도시락 테이블에서 선택된 도시락의 상세 정보 출력하고 수정,삭제를 할 수 있는 창
 * @author owner	
 */
@SuppressWarnings("serial")
public class LunchDetailView extends JDialog{
	
	private JLabel jlLunchImg;
	private JTextField jtfLunchCode,jtfLunchName, jtfLunchDate,jtfLunchPrice;
	private JTextArea jtaLunchSpec;
	private JButton jbImg, jbUpdate, jbDelete, jbEnd;
	
	
	public LunchDetailView( LunchMainView lmv, LunchDetailVO ldvo, LunchMainController lmc) {
		super(lmv,"도시락 상세 정보",true); //모달
		//DB에서 조회한 결과를 Component에서 채운다. 
		
		ImageIcon iiLunch=new ImageIcon("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+ldvo.getImg());
		jlLunchImg=new JLabel(iiLunch);
		
		jtfLunchCode=new JTextField();
		jtfLunchName=new JTextField();		
		jtfLunchDate=new JTextField();
		jtfLunchPrice=new JTextField();
		
		jtaLunchSpec=new JTextArea();
		
		//DB에서 조회한 값 설정
		jtfLunchCode.setText(ldvo.getLunch_code());
		jtfLunchName.setText(ldvo.getLunch_name());
		jtfLunchDate.setText(ldvo.getInput_date());
		jtfLunchPrice.setText( String.valueOf( ldvo.getPrice() ));
		jtaLunchSpec.setText(ldvo.getSpec());
		
		jbImg=new JButton("이미지선택");
		jbUpdate=new JButton("수정");
		jbDelete=new JButton("삭제");
		jbEnd=new JButton("닫기");
		
		JScrollPane jspTaSpec=new JScrollPane(jtaLunchSpec);
		
		setLayout(null);
		
		JLabel jlDetailTitle=new JLabel("도시락 상세정보");
		jlDetailTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		
		JLabel jlLunchCode=new JLabel("코드");
		JLabel jlLunchName=new JLabel("도시락명");
		JLabel jlLunchPrice=new JLabel("가격");
		JLabel jlLunchDate=new JLabel("입력일");
		JLabel jlLunchSpec=new JLabel("특장점");
		
		//배치
		jlDetailTitle.setBounds(10, 25, 250, 30);
		jlLunchImg.setBounds(10, 65, 244, 220);
		jbImg.setBounds(80, 290, 100, 25);
		
		jlLunchCode.setBounds(270, 65, 80, 25);
		jlLunchName.setBounds(270, 95, 80, 25);
		jlLunchPrice.setBounds(270, 125, 80, 25);
		jlLunchDate.setBounds(270, 155, 80, 25);
		jlLunchSpec.setBounds(270, 185, 80, 25);
		
		jtfLunchCode.setBounds(340, 65, 185, 25);
		jtfLunchCode.setEditable(false);
		jtfLunchCode.setBackground(Color.WHITE);
		jtfLunchName.setBounds(340, 95, 185, 25);
		
		jtfLunchPrice.setBounds(340, 125, 185, 25);
		
		jtfLunchDate.setBounds(340, 155, 185, 25);
		jtfLunchDate.setEditable(false);
		jtfLunchDate.setBackground(Color.WHITE);
		
		jspTaSpec.setBounds(340, 185, 185, 100);
		
		jbUpdate.setBounds(230, 350, 80, 30);
		jbDelete.setBounds(320, 350, 80, 30);
		jbEnd.setBounds(410, 350, 80, 30);
		
		add(jlDetailTitle);
		add(jlLunchImg);
		add(jbImg);
		add(jlLunchCode);
		add(jlLunchName);
		add(jlLunchPrice);
		add(jlLunchDate);
		add(jlLunchSpec);
		add(jtfLunchCode);
		add(jtfLunchName);
		add(jtfLunchDate);
		add(jtfLunchPrice);
		add(jspTaSpec);
		add(jbUpdate);
		add(jbDelete);
		add(jbEnd);
		
		LunchDetailController ldc=new LunchDetailController(this, lmc, ldvo.getImg());
		addWindowListener( ldc );
		
		jbImg.addActionListener(ldc);
		jbUpdate.addActionListener(ldc);
		jbDelete.addActionListener(ldc);
		jbEnd.addActionListener(ldc);
		
		setBounds(lmv.getX()+100, lmv.getY()+50, 550, 450); 
		setVisible(true);
		//다이얼로그를 종료할 때에는 JFrame과 다르게 DISPOSE_ON_CLOSE로 닫는다.
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//LunchDetailView

	public JLabel getJlLunchImg() {
		return jlLunchImg;
	}

	public JTextField getJtfLunchCode() {
		return jtfLunchCode;
	}

	public JTextField getJtfLunchName() {
		return jtfLunchName;
	}

	public JTextField getJtfLunchDate() {
		return jtfLunchDate;
	}

	public JTextField getJtfLunchPrice() {
		return jtfLunchPrice;
	}

	public JTextArea getJtaLunchSpec() {
		return jtaLunchSpec;
	}

	public JButton getJbImg() {
		return jbImg;
	}

	public JButton getJbUpdate() {
		return jbUpdate;
	}

	public JButton getJbDelete() {
		return jbDelete;
	}

	public JButton getJbEnd() {
		return jbEnd;
	}
	
}//class










