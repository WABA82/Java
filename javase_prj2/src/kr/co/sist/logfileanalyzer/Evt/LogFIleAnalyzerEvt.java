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
	private File folder;
	private String openPath; // ������ ������ ���/�̸� ���� //
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
		openPath = "";
		/* ���� */
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
		openPath = slcFileName + slcFilePath;
		/* ���Ͽ��⿡�� ��ҹ�ư�� ������ ��� : null�� �ƴ� ��쿡�� ������ Ÿ��Ʋ ���� */
		if (slcFileName != null && slcFilePath != null) {
			/* ������ ���� ���� */
			lfAnalyzer.setTitle("�α����Ϻм��� - " + slcFilePath + slcFileName);
		} // end if //
		/* File��ü ���� */
		file = new File(slcFilePath + slcFileName);

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

			/* �о�� ������ �� ���� �� */
			lfAnalyzer.getLabelLineCnt().setText("�� " + lineCnt + " ����");
			System.out.println("�� " + lineCnt + " ����");

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
			/* 1�� �󺧿� ��� */
			lfAnalyzer.getLabel1Key().setText(" �ִ� ��� Ű : "
					+ maxkey.substring(maxkey.lastIndexOf("=") + 1, maxkey.length()) + " Ƚ�� : " + maxValue);
			System.out.println("1. �ִ� ��� Ű : " + maxkey.substring(maxkey.lastIndexOf("=") + 1, maxkey.length())
					+ " Ƚ�� : " + maxValue);
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
			StringBuilder browserPrint = new StringBuilder();
			for (String key : Map.keySet()) {
				browserPrint.append(key).append(" : ").append(Map.get(key)).append("    ");
			}
			/* 2�� �󺧿� ��� */
			lfAnalyzer.getLabel2Browser().setText(browserPrint.toString());
			System.out.println(browserPrint.toString());
			Map.clear();

			/* 3. ���񽺸� ���������� ������ Ƚ��, ����(404) Ƚ�� */
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
				if (accessArr[i].equals("200") || accessArr[i].equals("404") || accessArr[i].equals("500")) {
					Map.put(accessArr[i], accesscnt);
				}
			} // for i

			/* 4�� ��� */
			StringBuilder accessPrint = new StringBuilder();
			for (String key : Map.keySet()) {
				accessPrint.append("�����ڵ� ").append(key).append(" : ").append(Map.get(key)).append("    ");
				System.out.println("3. �����ڵ� : " + key + " Ƚ�� : " + Map.get(key));
			}
			lfAnalyzer.getLabel3Access().setText(accessPrint.toString());
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

			// ��� //
			lfAnalyzer.getLabel4AskTime().setText("�ִ� ���ӽð� : " + maxkey + "�� Ƚ�� : " + maxValue);
			System.out.println("�ִ� ���ӽð� : " + maxkey + "�� Ƚ�� : " + maxValue);
			Map.clear();

			/* 5. ���������� ��û(403)�� �߻��� Ƚ��, ���� ���ϱ� */
			// Set ���� //
			for (String access : accessList) {
				Set.add(access);
			}

			// Map ���� //
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

			/* 5�� ��� */
			for (String key : Map.keySet()) {
				lfAnalyzer.getLabel5Fail403().setText("5. �����ڵ� : " + key + " Ƚ�� : " + Map.get(key));
				System.out.println("5. �����ڵ� : " + key + " Ƚ�� : " + Map.get(key));
			}
			Map.clear();

			/* 6. �ԷµǴ� ���ο� �ش��ϴ� ������� - inputButtonAct���� ó�� */
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
		/* ���ϳ��� ���� */
		StringBuilder writeToFile = new StringBuilder();
		String save1 = lfAnalyzer.getLabel1Key().getText();
		String save2 = lfAnalyzer.getLabel2Browser().getText();
		String save3 = lfAnalyzer.getLabel3Access().getText();
		String save4 = lfAnalyzer.getLabel4AskTime().getText();
		String save5 = lfAnalyzer.getLabel5Fail403().getText();
		String save6 = lfAnalyzer.getLabel6RangeKey().getText();

		/* ������ ������ ���� ��� */
		writeToFile.append(save1).append("\n").append(save2).append("\n").append(save3).append("\n").append(save4)
				.append("\n").append(save5).append("\n").append(save6);

		/********************************************************************************************************************************/
		/* ���� ���� �� �������� */
		// view��ư�� Ŭ���Ǹ� ���ϴ��̾�α� â�� ���� LOG������ �м��Ͽ� ���� ����(1~6)�� Dialog�� ���<br>
		// ������ �� ��report_������¥.dat�� ������ �����Ͽ� 1~6������
		SimpleDateFormat formatter = new SimpleDateFormat("yy-mm-dd hh:mm:ss", Locale.KOREA);
		Date date = new Date(folder.lastModified());
		String fileDate = formatter.format(date);
		StringBuilder fileNameSB = new StringBuilder();
		fileNameSB.append("c:/dev/temp/report/report_").append(fileDate).append(".dat");
		String saveFileName = fileNameSB.toString();
		File savefile = new File(saveFileName);

		BufferedWriter bWriter = null;
		int flag = JOptionPane.showConfirmDialog(lfAnalyzer, "������ ���� �Ͻðڽ��ϱ�??");
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
				// Set ���� //
				for (int i = start - 1; i < last; i++) {
					Set.add(urlList.get(i));
				}
				// Map ���� //
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

				// �ִ밪 ��� //
				int maxValue = 0;
				String maxkey = "";
				for (String key : Map.keySet()) {
					if (maxValue < Map.get(key)) {
						maxkey = key;
						maxValue = Map.get(key);
					}
				}
				/* 6�� �󺧿� ��� */
				lfAnalyzer.getLabel6RangeKey().setText(" �ִ� ��� Ű : "
						+ maxkey.substring(maxkey.lastIndexOf("=") + 1, maxkey.length()) + " Ƚ�� : " + maxValue);
				System.out.println("6. �ִ� ��� Ű : " + maxkey.substring(maxkey.lastIndexOf("=") + 1, maxkey.length())
						+ " Ƚ�� : " + maxValue);
				Map.clear();

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

//	report Ŭ���Ǹ� c:/dev/report ������ ����
	public void createDirectory() {
		folder = new File("c:/dev/temp/report");
		if (folder.mkdirs()) {
			System.out.println("������������");
		} else {
			System.out.println("���� �̸��� ���� ����");
		}
	}// createDirectory
}// class //
