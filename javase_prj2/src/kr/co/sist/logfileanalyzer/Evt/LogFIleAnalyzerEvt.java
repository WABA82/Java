package kr.co.sist.logfileanalyzer.Evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import kr.co.sist.project1.view.LogFileAnalyzer;

/**
 * @author owner<br>
 *         로그파일분석기 : log에 쌓이는 것을 인지하고, 이 log 파일에서 원하는 정보를 얻기 위한 프로그램.<br>
 *         [응답결과][요청url?key=mongodb&query=sist][요청브라우저종류][일자 시간]<br>
 *         응답결과 : 200-성공, 404-페이지없음, 403-권한없음, 500-서버내부오류<br>
 *         < 프레인 생성 ><br>
 *         view버튼과 report 생성<br>
 *         report버튼은 view버튼이 한번이라도 클릭된 이후에 동작한다.!!!<br>
 *         view버튼이 클릭되면 파일다이얼로그 창을 제공 LOG파일을 분석하여 위의 내용(1~6)을 Dialog에 출력<br>
 *         report 클릭되면 c:/dev/report 폴더를 생성한 후 “report_생성날짜.dat” 파일을 생성하여 1~6까지의
 *         작업을 모두 출력한다.<br>
 */
public class LogFIleAnalyzerEvt extends WindowAdapter implements ActionListener {

	/* 인스턴스 변수 선언 */
	// 매개생성자 : has A //
	private LogFileAnalyzer lfAnalyzer;
	// 일반 //
	private int lineCnt; // 파일의 총 라인의 수 //
	private String lfa_title; // 문서 제목 : 다른 버튼을 시작하기위한 기준 //
	// 파일 //
	private File file;
	private File folder;
	private String openPath; // 열었던 파일의 경로/이름 저장 //
	// List //
	private List<String> tokenlist; // = new ArrayList<>();
	private ArrayList<String> accessList;
	private ArrayList<String> urlList;
	private ArrayList<String> browserList;
	private ArrayList<String> timeList;
	// Set //
	private HashSet<String> Set;
	// Map //
	HashMap<String, Integer> Map;

	//////////////////////////////// 이하 생성자 ////////////////////////////////////

	/** 매개생성자 : LogFileAnalyzer를 받아서 사용 **/
	public LogFIleAnalyzerEvt(LogFileAnalyzer lfAnalyzer) {
		this.lfAnalyzer = lfAnalyzer;
		/* 일반 */
		lineCnt = 0;
		lfa_title = lfAnalyzer.getTitle();
		openPath = "";
		/* 파일 */
		file = null;
		folder = null;
		/* Arraylist */
		tokenlist = new ArrayList<>();
		accessList = new ArrayList<>();
		urlList = new ArrayList<>();
		browserList = new ArrayList<>();
		timeList = new ArrayList<>();
		/* HashSet */
		Set = new HashSet<>();
		/* HashMap */
		Map = new HashMap<>();
	}// 매개생성자

	//////////////////////////////// 이하 이벤트 처리 메소드 ///////////////////////////

	/** 이벤트 처리 **/
	@Override // 종료발생 //
	public void windowClosing(WindowEvent e) {
		lfAnalyzer.dispose();
	}// windowClosing

	@Override // 이벤트발생//
	public void actionPerformed(ActionEvent e) {

		// viewButton에서 Evt발생 : viewButtonAct호출 //
		if (e.getSource() == lfAnalyzer.getViewButton()) {
			try {
				viewButtonAct();
			} catch (IOException e1) {
				// e1.printStackTrace();
			}
		} // end if

		// reportButton에서 Evt발생 : reportButtonAct호출 //
		if (e.getSource() == lfAnalyzer.getReportButton()) {
			if (!lfa_title.equals(lfAnalyzer.getTitle())) {
				try {
					reportButtonAct();
				} catch (IOException e1) {
//                    e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(lfAnalyzer, "먼저 파일을 선택해주세요.", "저장오류", JOptionPane.ERROR_MESSAGE);
			}
		} // end if

		// inputButton에서 Evt발생 : reportButtonAct호출
		if (e.getSource() == lfAnalyzer.getInputButton()) {
			if (!lfa_title.equals(lfAnalyzer.getTitle())) {
				try {
					inputButtonAct();
				} catch (IOException e1) {
//                    e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(lfAnalyzer, "먼저 파일을 선택해주세요.", "입력오류", JOptionPane.ERROR_MESSAGE);
			}
		} // end if

	}// actionPerformed

	//////////////////////////////// 이하 이벤트 동작 메소드 ///////////////////////////

	/** viewButton동작 메소드 **/
	public void viewButtonAct() throws IOException {
		/* 호출시 FileDialog 열기 */
		FileDialog openLogFileD = new FileDialog(lfAnalyzer, "로그파일 열기", FileDialog.LOAD);
		openLogFileD.setVisible(true); // FileDialog가시화
		/* 변수 생성 : 선택파일 이름, 경로 */
		String slcFileName = openLogFileD.getFile();
		String slcFilePath = openLogFileD.getDirectory();
		openPath = slcFileName + slcFilePath;
		/* 파일열기에서 취소버튼이 눌렸을 경우 : null이 아닐 경우에만 프레임 타이틀 변경 */
		if (slcFileName != null && slcFilePath != null) {
			/* 프레임 제목 변경 */
			lfAnalyzer.setTitle("로그파일분석기 - " + slcFilePath + slcFileName);
		} // end if //
		/* File객체 생성 */
		file = new File(slcFilePath + slcFileName);

		/* try~finally */
		BufferedReader bReader = null;
		try {
			/* "file"객체 읽기 */
			bReader = new BufferedReader(new FileReader(file));
			String readlineTemp = "";
			while ((readlineTemp = bReader.readLine()) != null) {
				setTokenList(readlineTemp);
				lineCnt = lineCnt + 1;
			} // while

			/* 읽어온 파일의 총 라인 수 */
			lfAnalyzer.getLabelLineCnt().setText("총 " + lineCnt + " 라인");
			System.out.println("총 " + lineCnt + " 라인");

			/* 각 리스트에 담는 메소드 */
			setLists();

			/* 문제 풀기 */
			/* 1. 최다사용 키의 이름과 횟수 : java xx회 */
			// Set 셋팅 //
			for (String key : urlList) {
				Set.add(key);
			}
			String[] keyArr = Set.toArray(new String[Set.size()]);
			Set.clear();

			// Map 셋팅 //
			int keycnt;
			for (int i = 0; i < keyArr.length; i++) {
				keycnt = 0;
				for (int j = 0; j < urlList.size(); j++) {
					if (keyArr[i].equals(urlList.get(j))) {
						keycnt = keycnt + 1;
					}
				} // for j
				Map.put(keyArr[i], keycnt);
			} // for i

			// 최대값 출력 //
			int maxValue = 0;
			String maxkey = "";
			for (String key : Map.keySet()) {
				if (maxValue < Map.get(key)) {
					maxkey = key;
					maxValue = Map.get(key);
				}
			}
			/* 1번 라벨에 출력 */
			lfAnalyzer.getLabel1Key().setText(" 최다 사용 키 : "
					+ maxkey.substring(maxkey.lastIndexOf("=") + 1, maxkey.length()) + " 횟수 : " + maxValue);
			System.out.println("1. 최다 사용 키 : " + maxkey.substring(maxkey.lastIndexOf("=") + 1, maxkey.length())
					+ " 횟수 : " + maxValue);
			Map.clear();

			/* 2. 브라우저별 접속횟수, 비율 : IE - xx (xx%), Chrome - xx (xx%) */
			// Set 셋팅 //
			for (String browser : browserList) {
				Set.add(browser);
			}
			// Map 셋팅 //
			String[] browserArr = Set.toArray(new String[Set.size()]);
			Set.clear();
			int browsercnt;
			for (int i = 0; i < browserArr.length; i++) {
				browsercnt = 0;
				for (int j = 0; j < browserList.size(); j++) {
					if (browserArr[i].equals(browserList.get(j))) {
						browsercnt = browsercnt + 1;
					}
				} // for j
				Map.put(browserArr[i], browsercnt);
			} // for i

			// 최대값 출력 //
			StringBuilder browserPrint = new StringBuilder();
			for (String key : Map.keySet()) {
				browserPrint.append(key).append(" : ").append(Map.get(key)).append("    ");
			}
			/* 2번 라벨에 출력 */
			lfAnalyzer.getLabel2Browser().setText(browserPrint.toString());
			System.out.println(browserPrint.toString());
			Map.clear();

			/* 3. 서비스를 성공적으로 수행한 횟수, 실패(404) 횟수 */
			// Set 셋팅 //
			for (String access : accessList) {
				Set.add(access);
			}

			// Map 셋팅 //
			String[] accessArr = Set.toArray(new String[Set.size()]);
			Set.clear();
			int accesscnt;
			for (int i = 0; i < accessArr.length; i++) {
				accesscnt = 0;
				for (int j = 0; j < accessList.size(); j++) {
					if (accessArr[i].equals(accessList.get(j))) {
						accesscnt = accesscnt + 1;
					}
				} // for ~ j
				if (accessArr[i].equals("200") || accessArr[i].equals("404") || accessArr[i].equals("500")) {
					Map.put(accessArr[i], accesscnt);
				}
			} // for i

			/* 4번 출력 */
			StringBuilder accessPrint = new StringBuilder();
			for (String key : Map.keySet()) {
				accessPrint.append("접속코드 ").append(key).append(" : ").append(Map.get(key)).append("    ");
				System.out.println("3. 접속코드 : " + key + " 횟수 : " + Map.get(key));
			}
			lfAnalyzer.getLabel3Access().setText(accessPrint.toString());
			Map.clear();

			/* 4. 요청이 가장 많은 시간 [ 10 시] */
			// Set 셋팅 //
			for (String hour : timeList) {
				Set.add(hour);
			}
			// Map 셋팅 //
			String[] hourArr = Set.toArray(new String[Set.size()]);
			Set.clear();
			int hourcnt;
			for (int i = 0; i < hourArr.length; i++) {
				hourcnt = 0;
				for (int j = 0; j < timeList.size(); j++) {
					if (hourArr[i].equals(timeList.get(j))) {
						hourcnt = hourcnt + 1;
					}
				} // for j
				Map.put(hourArr[i], hourcnt);
			} // for i

			// 최대값 출력 //
			maxValue = 0;
			maxkey = "";
			for (String key : Map.keySet()) {
				if (maxValue < Map.get(key)) {
					maxkey = key;
					maxValue = Map.get(key);
				}
			}

			// 출력 //
			lfAnalyzer.getLabel4AskTime().setText("최다 접속시간 : " + maxkey + "시 횟수 : " + maxValue);
			System.out.println("최다 접속시간 : " + maxkey + "시 횟수 : " + maxValue);
			Map.clear();

			/* 5. 비정상적인 요청(403)이 발생한 횟수, 비율 구하기 */
			// Set 셋팅 //
			for (String access : accessList) {
				Set.add(access);
			}

			// Map 셋팅 //
			accessArr = Set.toArray(new String[Set.size()]);
			Set.clear();
			int err403cnt;
			for (int i = 0; i < accessArr.length; i++) {
				err403cnt = 0;
				for (int j = 0; j < accessList.size(); j++) {
					if (accessArr[i].equals(accessList.get(j))) {
						err403cnt = err403cnt + 1;
					}
				} // for ~ j
				if (accessArr[i].equals("403")) {
					Map.put(accessArr[i], err403cnt);
				}
			} // for i

			/* 5번 출력 */
			for (String key : Map.keySet()) {
				lfAnalyzer.getLabel5Fail403().setText("5. 접속코드 : " + key + " 횟수 : " + Map.get(key));
				System.out.println("5. 접속코드 : " + key + " 횟수 : " + Map.get(key));
			}
			Map.clear();

			/* 6. 입력되는 라인에 해당하는 정보출력 - inputButtonAct에서 처리 */
		} finally {
			if (bReader != null) {
				bReader.close();
			}
		} // try~finally 끝 //
	}// viewButtonAct

	/** reportButton동작 메소드 **/
	public void reportButtonAct() throws IOException {
		/* 폴더 생성 */
		createDirectory();
		/* 파일내용 생성 */
		StringBuilder writeToFile = new StringBuilder();
		String save1 = lfAnalyzer.getLabel1Key().getText();
		String save2 = lfAnalyzer.getLabel2Browser().getText();
		String save3 = lfAnalyzer.getLabel3Access().getText();
		String save4 = lfAnalyzer.getLabel4AskTime().getText();
		String save5 = lfAnalyzer.getLabel5Fail403().getText();
		String save6 = lfAnalyzer.getLabel6RangeKey().getText();

		/* 저장할 파일의 내용 담기 */
		writeToFile.append(save1).append("\n").append(save2).append("\n").append(save3).append("\n").append(save4)
				.append("\n").append(save5).append("\n").append(save6);

		/********************************************************************************************************************************/
		/* 파일 생성 및 내보내기 */
		// view버튼이 클릭되면 파일다이얼로그 창을 제공 LOG파일을 분석하여 위의 내용(1~6)을 Dialog에 출력<br>
		// 생성한 후 “report_생성날짜.dat” 파일을 생성하여 1~6까지의
		SimpleDateFormat formatter = new SimpleDateFormat("yy-mm-dd hh:mm:ss", Locale.KOREA);
		Date date = new Date(folder.lastModified());
		String fileDate = formatter.format(date);
		StringBuilder fileNameSB = new StringBuilder();
		fileNameSB.append("c:/dev/temp/report/report_").append(fileDate).append(".dat");
		String saveFileName = fileNameSB.toString();
		File savefile = new File(saveFileName);

		BufferedWriter bWriter = null;
		int flag = JOptionPane.showConfirmDialog(lfAnalyzer, "파일을 생성 하시겠습니까??");
		switch (flag) {
		case JOptionPane.OK_OPTION:
			try {
				bWriter = new BufferedWriter(new FileWriter(savefile));
				bWriter.write(writeToFile.toString());
				bWriter.flush();
			} finally {
				if (bWriter != null) {
					bWriter.close();
				} // end if
			} // end finally
			JOptionPane.showMessageDialog(lfAnalyzer, "success");
			break;
		case JOptionPane.NO_OPTION:
			JOptionPane.showMessageDialog(lfAnalyzer, "fail");
			break;
		case JOptionPane.CANCEL_OPTION:
			JOptionPane.showMessageDialog(lfAnalyzer, "Cancel");
		}// switch case // try~finally//
	}// reportButtonAct

	/** inputButton동작 메소드 **/
	public void inputButtonAct() throws IOException {
		String firstInput = JOptionPane.showInputDialog(lfAnalyzer, "시작 값을 입력해 주세요.");
		int start = Integer.parseInt(firstInput);

		if (start < lineCnt) {
			String seconInput = JOptionPane.showInputDialog(lfAnalyzer, "끝 값을 입력해 주세요.");
			int last = Integer.parseInt(seconInput);
			if (last > start || last == lineCnt) {

				/* 6번 초기화 */
				lfAnalyzer.getLabel6RangeKey().setText("");

				/* 문제풀이 */
//              6. 입력되는 라인에 해당하는 정보출력(1000~1500번째 라인에 해당하는 정보 중 최다사용 키의 이름과 횟수 | java/ xx회)<br>
				// Set 세팅 //
				for (int i = start - 1; i < last; i++) {
					Set.add(urlList.get(i));
				}
				// Map 세팅 //
				String[] keyArr = Set.toArray(new String[Set.size()]);
				Set.clear();
				int keycnt;
				for (int i = 0; i < keyArr.length; i++) {
					keycnt = 0;
					for (int j = start - 1; j < last; j++) {
						if (keyArr[i].equals(urlList.get(j))) {
							keycnt = keycnt + 1;
						}
					} // for j //
					Map.put(keyArr[i], keycnt);
				} // for i

				// 최대값 출력 //
				int maxValue = 0;
				String maxkey = "";
				for (String key : Map.keySet()) {
					if (maxValue < Map.get(key)) {
						maxkey = key;
						maxValue = Map.get(key);
					}
				}
				/* 6번 라벨에 출력 */
				lfAnalyzer.getLabel6RangeKey().setText(" 최다 사용 키 : "
						+ maxkey.substring(maxkey.lastIndexOf("=") + 1, maxkey.length()) + " 횟수 : " + maxValue);
				System.out.println("6. 최다 사용 키 : " + maxkey.substring(maxkey.lastIndexOf("=") + 1, maxkey.length())
						+ " 횟수 : " + maxValue);
				Map.clear();

			} else if (last < start || last >= lineCnt) {
				JOptionPane.showMessageDialog(lfAnalyzer, "입력가능 범위를 초과 했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(lfAnalyzer, "입력은 숫자만 가능합니다.", "오류", JOptionPane.ERROR_MESSAGE);
			} // end if //
		} else if (start >= lineCnt) {
			JOptionPane.showMessageDialog(lfAnalyzer, "입력가능 범위를 초과 했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(lfAnalyzer, "입력은 숫자만 가능합니다.", "오류", JOptionPane.ERROR_MESSAGE);
		} // end if //

	}// inputButtonAct

	//////////////////////////////// 이하 list set메소드 ///////////////////////////

	/* 데이타 메소드 : file을 읽고 가공_List, Set, Map사용 */
	public void setTokenList(String readlineTemp) {
		/* List 사용 : 토큰 별로 자르기 */
		StringTokenizer Tknizer = new StringTokenizer(readlineTemp, "[]", false);
		String token = "";
		while (Tknizer.hasMoreTokens()) {
			token = Tknizer.nextToken();
			tokenlist.add(token);
		} // while
	}// data

	public void setLists() {
		/* 각list에 담기 */
		String url = "";
		String time = "";
		String key = ""; // url에서 key 값만 저장할 메소드
		String hour = ""; // 일자에서 시간만 저장할 메소드
		for (int i = 0; i < tokenlist.size(); i++) {
			if (i % 4 == 0) {
				accessList.add(tokenlist.get(i));
			}
			if (i % 4 == 1) {
				url = tokenlist.get(i);
				if (url.contains("key")) {
					key = url.substring(url.indexOf("key"), url.indexOf("&"));
					urlList.add(key);
				}
			}
			if (i % 4 == 2) {
				browserList.add(tokenlist.get(i));
			}
			if (i % 4 == 3) {
				time = tokenlist.get(i);
				hour = time.substring(11, 13);
				timeList.add(hour);
			}
		} // for i //
	}// setList

	//////////////////////////////// 이하 폴더 및 파일 생성 메소드 ///////////////////////////

//	report 클릭되면 c:/dev/report 폴더를 생성
	public void createDirectory() {
		folder = new File("c:/dev/temp/report");
		if (folder.mkdirs()) {
			System.out.println("폴더생성성공");
		} else {
			System.out.println("같은 이름의 폴더 존재");
		}
	}// createDirectory
}// class //
