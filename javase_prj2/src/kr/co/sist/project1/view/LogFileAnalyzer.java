package kr.co.sist.project1.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import kr.co.sist.logfileanalyzer.Evt.LogFIleAnalyzerEvt;


/**
* @author owner<br>
*         로그파일분석기 : log에 쌓이는 것을 인지하고, 이 log 파일에서 원하는 정보를 얻기 위한 프로그램.<br>
*         [응답결과][요청url?key=mongodb&query=sist][요청브라우저종류][일자 시간]<br>
*         응답결과 : 200-성공, 404-페이지없음, 403-권한없음, 500-서버내부오류<br>
*         1. 최다사용 키의 이름과 횟수 : java xx회<br>
*         2. 브라우저별 접속횟수, 비율 : IE - xx (xx%), Chrome - xx (xx%)<br>
*         3. 서비스를 성공적으로 수행한 횟수, 실패(404) 횟수<br>
*         4. 요청이 가장 많은 시간 [ 10 시]<br>
*         5. 비정상적인 요청(403)이 발생한 횟수, 비율 구하기<br>
*         6. 입력되는 라인에 해당하는 정보출력(1000~1500번째 라인에 해당하는 정보 중<br>
*         최다사용 키의 이름과 횟수 | java/ xx회)<br>
*         <br>
*         < 프레인 생성 ><br>
*         view버튼과 report 생성<br>
*         report버튼은 view버튼이 한번이라도 클릭된 이후에 동작한다.!!!<br>
*         view버튼이 클릭되면 파일다이얼로그 창을 제공 LOG파일을 분석하여 위의 내용(1~6)을 Dialog에 출력<br>
*         report 클릭되면 c:/dev/report 폴더를 생성한 후 “report_생성날짜.dat” 파일을 생성하여 1~6까지의
*         작업을 모두 출력한다.<br>
*/

@SuppressWarnings("serial") /* JFrame 상속받기 */
public class LogFileAnalyzer extends JFrame {

    /* 인스턴스변수 선언 */
    // 버튼 //
    private JButton viewButton;
    private JButton reportButton;
    private JButton inputButton;
    // 라벨 : 화면출력용 //
    private JLabel label1Key, label2Browser, label3Access, label4AskTime, label5Fail403, label6RangeKey;

    //////////////////////////////// 이하 생성자 ////////////////////////////////////

    /** 기본 생성자 **/
    public LogFileAnalyzer() {
        super("로그파일분석기");
        /* 기본컴포넌트 생성 */
        // 버튼 //
        viewButton = new JButton("파일선택");
        reportButton = new JButton("결과저장");
        inputButton = new JButton("범위입력");
        // 라벨 //
        label1Key = new JLabel("1.java xx회");
        label2Browser = new JLabel("2.IE - xx (xx%), Chrome - xx (xx%),,,");
        label3Access = new JLabel("3.서비스 성공 횟수, 실패 횟수");
        label4AskTime = new JLabel("4.[ 10 시]");
        label5Fail403 = new JLabel("5.오류403");
        label6RangeKey = new JLabel("6.라인에 해당하는 정보");

        /* 보더설정 */
        label1Key.setBorder(new TitledBorder("최다 사용 키 정보"));
        label2Browser.setBorder(new TitledBorder("접속 브라우저 정보"));
        label3Access.setBorder(new TitledBorder("접속 성공횟수 / 실패횟수"));
        label4AskTime.setBorder(new TitledBorder("최다 접속 시간"));
        label5Fail403.setBorder(new TitledBorder("오류 403 발생 횟수"));
        label6RangeKey.setBorder(new TitledBorder("입력 라인 해당 정보(최다 키 정보)"));

        /* 위치설정 : 패널생성 */
        // 센터 : BorderLayout.CENTER //
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(6, 1));
        panelCenter.add(label1Key);
        panelCenter.add(label2Browser);
        panelCenter.add(label3Access);
        panelCenter.add(label4AskTime);
        panelCenter.add(label5Fail403);
        panelCenter.add(label6RangeKey);
        // 아래 : BorderLayout.SOUTH //
        JPanel panelBottom = new JPanel();
        panelBottom.add(viewButton);
        panelBottom.add(inputButton);
        panelBottom.add(reportButton);

        /* 배치 : JFrame에 배치하기 */
        add(BorderLayout.CENTER, panelCenter);
        add(BorderLayout.SOUTH, panelBottom);

        /* 크기설정 */
        setBounds(200, 200, 740, 560);

        /* 이벤트등록 */
        // 이벤트객체 생성 Has A //
		LogFIleAnalyzerEvt lfaEvent = new LogFIleAnalyzerEvt(this);
        addWindowListener(lfaEvent); // 종료이벤트
        viewButton.addActionListener(lfaEvent); // 버튼이벤트
        reportButton.addActionListener(lfaEvent); // 버튼이벤트
        inputButton.addActionListener(lfaEvent); // 버튼이벤트
        /* 가시화 */
        setVisible(true);

    }// 기본생성자 끝 //

    //////////////////////////////// 이하 get 메소드 ////////////////////////////////////

    /** get메소드 **/
    // get 버튼 //
    public JButton getViewButton() {
        return viewButton;
    }

    public JButton getReportButton() {
        return reportButton;
    }

    // get 텍스트에리아 //
    public JButton getInputButton() {
        return inputButton;
    }

    // get 라벨 //
    public JLabel getLabel1Key() {
        return label1Key;
    }

    public JLabel getLabel2Browser() {
        return label2Browser;
    }

    public JLabel getLabel3Access() {
        return label3Access;
    }

    public JLabel getLabel4AskTime() {
        return label4AskTime;
    }

    public JLabel getLabel5Fail403() {
        return label5Fail403;
    }

    public JLabel getLabel6RangeKey() {
        return label6RangeKey;
    }// get메소드 끝 //

}// class //
