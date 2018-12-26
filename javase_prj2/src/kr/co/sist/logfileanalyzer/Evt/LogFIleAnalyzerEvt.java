package kr.co.sist.logfileanalyzer.Evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import kr.co.sist.project1.view.LogFileAnalyzer;

/**
 * @author owner<br>
 *         �α����Ϻм��� : log�� ���̴� ���� �����ϰ�, �� log ���Ͽ��� ���ϴ� ������ ��� ���� ���α׷�.<br>
 *         [������][��ûurl?key=mongodb&query=sist][��û����������][���� �ð�]<br>
 *         ������ : 200-����, 404-����������, 403-���Ѿ���, 500-�������ο���<br>
 *         < ������ ���� ><br>
 *         view��ư�� report ����<br>
 *         report��ư�� view��ư�� �ѹ��̶� Ŭ���� ���Ŀ� �����Ѵ�.!!!<br>
 *         view��ư�� Ŭ���Ǹ� ���ϴ��̾�α� â�� ���� LOG������ �м��Ͽ� ���� ����(1~6)�� Dialog�� ���<br>
 *         report Ŭ���Ǹ� c:/dev/report ������ ������ �� ��report_������¥.dat�� ������ �����Ͽ� 1~6������
 *         �۾��� ��� ����Ѵ�.<br>
 */
public class LogFIleAnalyzerEvt extends WindowAdapter implements ActionListener {

	/* �ν��Ͻ� ���� ���� */
	// �Ű������� : has A //
	private LogFileAnalyzer lfAnalyzer;
	// �Ϲ� //
	private int lineCnt; // ������ �� ������ �� //
	private String lfa_title; // ���� ���� : �ٸ� ��ư�� �����ϱ����� ���� //
	// ���� //
	private File file;
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

	//////////////////////////////// ���� ������ ////////////////////////////////////

	/** �Ű������� : LogFileAnalyzer�� �޾Ƽ� ��� **/
	public LogFIleAnalyzerEvt(LogFileAnalyzer lfAnalyzer) {
		this.lfAnalyzer = lfAnalyzer;
		/* �Ϲ� */
		lineCnt = 0;
		lfa_title = lfAnalyzer.getTitle();
		/* ���� */
		file = null;
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
	}// �Ű�������

	//////////////////////////////// ���� �̺�Ʈ ó�� �޼ҵ� ///////////////////////////

	/** �̺�Ʈ ó�� **/
	@Override // ����߻� //
	public void windowClosing(WindowEvent e) {
		lfAnalyzer.dispose();
	}// windowClosing

	@Override // �̺�Ʈ�߻�//
	public void actionPerformed(ActionEvent e) {

		// viewButton���� Evt�߻� : viewButtonActȣ�� //
		if (e.getSource() == lfAnalyzer.getViewButton()) {
			try {
				viewButtonAct();
			} catch (IOException e1) {
				// e1.printStackTrace();
			}
		} // end if

		// reportButton���� Evt�߻� : reportButtonActȣ�� //
		if (e.getSource() == lfAnalyzer.getReportButton()) {
			if (!lfa_title.equals(lfAnalyzer.getTitle())) {
				try {
					reportButtonAct();
				} catch (IOException e1) {
//                    e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(lfAnalyzer, "���� ������ �������ּ���.", "�������", JOptionPane.ERROR_MESSAGE);
			}
		} // end if

		// inputButton���� Evt�߻� : reportButtonActȣ��
		if (e.getSource() == lfAnalyzer.getInputButton()) {
			if (!lfa_title.equals(lfAnalyzer.getTitle())) {
				try {
					inputButtonAct();
				} catch (IOException e1) {
//                    e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(lfAnalyzer, "���� ������ �������ּ���.", "�Է¿���", JOptionPane.ERROR_MESSAGE);
			}
		} // end if

	}// actionPerformed

	//////////////////////////////// ���� �̺�Ʈ ���� �޼ҵ� ///////////////////////////

	/** viewButton���� �޼ҵ� **/
	public void viewButtonAct() throws IOException {
		/* ȣ��� FileDialog ���� */
		FileDialog openLogFileD = new FileDialog(lfAnalyzer, "�α����� ����", FileDialog.LOAD);
		openLogFileD.setVisible(true); // FileDialog����ȭ
		/* ���� ���� : �������� �̸�, ��� */
		String slcFileName = openLogFileD.getFile();
		String slcFilePath = openLogFileD.getDirectory();
		/* File��ü ���� */
		file = new File(slcFilePath + slcFileName);
		/* ������ ���� ���� */
		lfAnalyzer.setTitle("�α����Ϻм��� - " + slcFilePath + slcFileName);

		/* try~finally */
		BufferedReader bReader = null;
		try {
			/* "file"��ü �б� */
			bReader = new BufferedReader(new FileReader(file));
			String readlineTemp = "";
			while ((readlineTemp = bReader.readLine()) != null) {
				setTokenList(readlineTemp);
				lineCnt = lineCnt + 1;
			} // while

			/* �� ����Ʈ�� ��� �޼ҵ� */
			setLists();

			/* ���� Ǯ�� */
			/* 1. �ִٻ�� Ű�� �̸��� Ƚ�� : java xxȸ */
			// Set ���� //
			for (String key : urlList) {
				Set.add(key);
			}
			String[] keyArr = Set.toArray(new String[Set.size()]);
			Set.clear();

			// Map ���� //
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

			// �ִ밪 ��� //
			int maxValue = 0;
			String maxkey = "";
			for (String key : Map.keySet()) {
				if (maxValue < Map.get(key)) {
					maxkey = key;
					maxValue = Map.get(key);
				}
			}
			System.out.println("1. �ִ� ��� Ű : " + maxkey + " Ƚ�� : " + maxValue);
			Map.clear();

			/* 2. �������� ����Ƚ��, ���� : IE - xx (xx%), Chrome - xx (xx%) */
			// Set ���� //
			for (String browser : browserList) {
				Set.add(browser);
			}
			// Map ���� //
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
				// �ִ밪 ��� //
//			maxValue = 0;
//			maxkey = "";
			for (String key : Map.keySet()) {
				System.out.println("2. ���� �������� ���� �� ���� : " + key + " Ƚ�� : " + Map.get(key));
//				if (maxValue < Map.get(key)) {
//					maxkey = key;
//					maxValue = Map.get(key);
//				}
			}
			Map.clear();

			/* 3. ���񽺸� ���������� ������ Ƚ��, ����(404) Ƚ�� */
			/* 5. ���������� ��û(403)�� �߻��� Ƚ��, ���� ���ϱ� */
			// Set ���� //
			for (String access : accessList) {
				Set.add(access);
			}

			// Map ���� //
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
				Map.put(accessArr[i], accesscnt);
			} // for i

			// �ִ밪 ��� //
//			maxValue = 0;
//			maxkey = "";
			for (String key : Map.keySet()) {
				System.out.println("�ִ� ��� Ű : " + maxkey + " Ƚ�� : " + maxValue);
//				if (maxValue < Map.get(key)) {
//					maxkey = key;
//					maxValue = Map.get(key);
//				}
			}
			Map.clear();

			/* 4. ��û�� ���� ���� �ð� [ 10 ��] */
			// Set ���� //
			for (String hour : timeList) {
				Set.add(hour);
			}
			// Map ���� //
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

			// �ִ밪 ��� //
			maxValue = 0;
			maxkey = "";
			for (String key : Map.keySet()) {
				if (maxValue < Map.get(key)) {
					maxkey = key;
					maxValue = Map.get(key);
				}
			}
			System.out.println("�ִ� ��� Ű : " + maxkey + " Ƚ�� : " + maxValue);
			Map.clear();

			/* 6. �ԷµǴ� ���ο� �ش��ϴ� ������� - inputButtonAct���� ó�� */

			/* �о�� ������ �� ���� �� */
			// System.out.println(lineCnt);
		} finally {
			if (bReader != null) {
				bReader.close();
			}
		} // try~finally �� //
	}// viewButtonAct

	/** reportButton���� �޼ҵ� **/
	public void reportButtonAct() throws IOException {
		/* ���� ���� */
		createDirectory();
		/* ���� ���� �� �������� */
//        BufferedWriter bWriter = null;
//        try {
//            bWriter = new BufferedWriter(new FileWriter("report_"));
//            bWriter.write("���� �غ� �ȉ���ϴ�.");
//            bWriter.flush();
//        } finally {
//            if (bWriter != null) {
//                bWriter.close();
//            }
//        } // try~finally//
	}// reportButtonAct

	/** inputButton���� �޼ҵ� **/
	public void inputButtonAct() throws IOException {
		String firstInput = JOptionPane.showInputDialog(lfAnalyzer, "���� ���� �Է��� �ּ���.");
		int start = Integer.parseInt(firstInput);

		if (start < lineCnt) {
			String seconInput = JOptionPane.showInputDialog(lfAnalyzer, "�� ���� �Է��� �ּ���.");
			int last = Integer.parseInt(seconInput);
			if (last > start || last == lineCnt) {

				/* 6�� �ʱ�ȭ */
				lfAnalyzer.getLabel6RangeKey().setText("");

				/* ����Ǯ�� */
//              6. �ԷµǴ� ���ο� �ش��ϴ� �������(1000~1500��° ���ο� �ش��ϴ� ���� �� �ִٻ�� Ű�� �̸��� Ƚ�� | java/ xxȸ)<br>
				for (int i = start - 1; i < last; i++) {
					Set.add(urlList.get(i));
				}
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
				} // for i //
				for (String key : Map.keySet()) {
					System.out.println("Ű : " + key + "Ƚ��" + Map.get(key));
				}

			} else if (last < start || last >= lineCnt) {
				JOptionPane.showMessageDialog(lfAnalyzer, "�Է°��� ������ �ʰ� �߽��ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(lfAnalyzer, "�Է��� ���ڸ� �����մϴ�.", "����", JOptionPane.ERROR_MESSAGE);
			} // end if //
		} else if (start >= lineCnt) {
			JOptionPane.showMessageDialog(lfAnalyzer, "�Է°��� ������ �ʰ� �߽��ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(lfAnalyzer, "�Է��� ���ڸ� �����մϴ�.", "����", JOptionPane.ERROR_MESSAGE);
		} // end if //

	}// inputButtonAct

	//////////////////////////////// ���� list set�޼ҵ� ///////////////////////////

	/* ����Ÿ �޼ҵ� : file�� �а� ����_List, Set, Map��� */
	public void setTokenList(String readlineTemp) {
		/* List ��� : ��ū ���� �ڸ��� */
		StringTokenizer Tknizer = new StringTokenizer(readlineTemp, "[]", false);
		String token = "";
		while (Tknizer.hasMoreTokens()) {
			token = Tknizer.nextToken();
			tokenlist.add(token);
		} // while
	}// data

	public void setLists() {
		/* ��list�� ��� */
		String url = "";
		String time = "";
		String key = ""; // url���� key ���� ������ �޼ҵ�
		String hour = ""; // ���ڿ��� �ð��� ������ �޼ҵ�
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

	//////////////////////////////// ���� ���� �� ���� ���� �޼ҵ� ///////////////////////////
//	view��ư�� Ŭ���Ǹ� ���ϴ��̾�α� â�� ���� LOG������ �м��Ͽ� ���� ����(1~6)�� Dialog�� ���<br>
//	������ �� ��report_������¥.dat�� ������ �����Ͽ� 1~6������

//	report Ŭ���Ǹ� c:/dev/report ������ ����
	public void createDirectory() {
		File file = new File("c:/dev/temp/report");
		if (file.mkdirs()) {
			System.out.println("������������");
		} else {
			System.out.println("���� �̸��� ���� ����");
		}
	}// createDirectory
}// class //
