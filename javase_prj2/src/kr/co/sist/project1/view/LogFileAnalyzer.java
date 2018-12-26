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
*         �α����Ϻм��� : log�� ���̴� ���� �����ϰ�, �� log ���Ͽ��� ���ϴ� ������ ��� ���� ���α׷�.<br>
*         [������][��ûurl?key=mongodb&query=sist][��û����������][���� �ð�]<br>
*         ������ : 200-����, 404-����������, 403-���Ѿ���, 500-�������ο���<br>
*         1. �ִٻ�� Ű�� �̸��� Ƚ�� : java xxȸ<br>
*         2. �������� ����Ƚ��, ���� : IE - xx (xx%), Chrome - xx (xx%)<br>
*         3. ���񽺸� ���������� ������ Ƚ��, ����(404) Ƚ��<br>
*         4. ��û�� ���� ���� �ð� [ 10 ��]<br>
*         5. ���������� ��û(403)�� �߻��� Ƚ��, ���� ���ϱ�<br>
*         6. �ԷµǴ� ���ο� �ش��ϴ� �������(1000~1500��° ���ο� �ش��ϴ� ���� ��<br>
*         �ִٻ�� Ű�� �̸��� Ƚ�� | java/ xxȸ)<br>
*         <br>
*         < ������ ���� ><br>
*         view��ư�� report ����<br>
*         report��ư�� view��ư�� �ѹ��̶� Ŭ���� ���Ŀ� �����Ѵ�.!!!<br>
*         view��ư�� Ŭ���Ǹ� ���ϴ��̾�α� â�� ���� LOG������ �м��Ͽ� ���� ����(1~6)�� Dialog�� ���<br>
*         report Ŭ���Ǹ� c:/dev/report ������ ������ �� ��report_������¥.dat�� ������ �����Ͽ� 1~6������
*         �۾��� ��� ����Ѵ�.<br>
*/

@SuppressWarnings("serial") /* JFrame ��ӹޱ� */
public class LogFileAnalyzer extends JFrame {

    /* �ν��Ͻ����� ���� */
    // ��ư //
    private JButton viewButton;
    private JButton reportButton;
    private JButton inputButton;
    // �� : ȭ����¿� //
    private JLabel label1Key, label2Browser, label3Access, label4AskTime, label5Fail403, label6RangeKey;

    //////////////////////////////// ���� ������ ////////////////////////////////////

    /** �⺻ ������ **/
    public LogFileAnalyzer() {
        super("�α����Ϻм���");
        /* �⺻������Ʈ ���� */
        // ��ư //
        viewButton = new JButton("���ϼ���");
        reportButton = new JButton("�������");
        inputButton = new JButton("�����Է�");
        // �� //
        label1Key = new JLabel("1.java xxȸ");
        label2Browser = new JLabel("2.IE - xx (xx%), Chrome - xx (xx%),,,");
        label3Access = new JLabel("3.���� ���� Ƚ��, ���� Ƚ��");
        label4AskTime = new JLabel("4.[ 10 ��]");
        label5Fail403 = new JLabel("5.����403");
        label6RangeKey = new JLabel("6.���ο� �ش��ϴ� ����");

        /* �������� */
        label1Key.setBorder(new TitledBorder("�ִ� ��� Ű ����"));
        label2Browser.setBorder(new TitledBorder("���� ������ ����"));
        label3Access.setBorder(new TitledBorder("���� ����Ƚ�� / ����Ƚ��"));
        label4AskTime.setBorder(new TitledBorder("�ִ� ���� �ð�"));
        label5Fail403.setBorder(new TitledBorder("���� 403 �߻� Ƚ��"));
        label6RangeKey.setBorder(new TitledBorder("�Է� ���� �ش� ����(�ִ� Ű ����)"));

        /* ��ġ���� : �гλ��� */
        // ���� : BorderLayout.CENTER //
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(6, 1));
        panelCenter.add(label1Key);
        panelCenter.add(label2Browser);
        panelCenter.add(label3Access);
        panelCenter.add(label4AskTime);
        panelCenter.add(label5Fail403);
        panelCenter.add(label6RangeKey);
        // �Ʒ� : BorderLayout.SOUTH //
        JPanel panelBottom = new JPanel();
        panelBottom.add(viewButton);
        panelBottom.add(inputButton);
        panelBottom.add(reportButton);

        /* ��ġ : JFrame�� ��ġ�ϱ� */
        add(BorderLayout.CENTER, panelCenter);
        add(BorderLayout.SOUTH, panelBottom);

        /* ũ�⼳�� */
        setBounds(200, 200, 740, 560);

        /* �̺�Ʈ��� */
        // �̺�Ʈ��ü ���� Has A //
		LogFIleAnalyzerEvt lfaEvent = new LogFIleAnalyzerEvt(this);
        addWindowListener(lfaEvent); // �����̺�Ʈ
        viewButton.addActionListener(lfaEvent); // ��ư�̺�Ʈ
        reportButton.addActionListener(lfaEvent); // ��ư�̺�Ʈ
        inputButton.addActionListener(lfaEvent); // ��ư�̺�Ʈ
        /* ����ȭ */
        setVisible(true);

    }// �⺻������ �� //

    //////////////////////////////// ���� get �޼ҵ� ////////////////////////////////////

    /** get�޼ҵ� **/
    // get ��ư //
    public JButton getViewButton() {
        return viewButton;
    }

    public JButton getReportButton() {
        return reportButton;
    }

    // get �ؽ�Ʈ������ //
    public JButton getInputButton() {
        return inputButton;
    }

    // get �� //
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
    }// get�޼ҵ� �� //

}// class //
