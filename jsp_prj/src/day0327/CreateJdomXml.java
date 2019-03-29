package day0327;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreateJdomXml {

	public List<String> data() {
		List<String> list = new ArrayList<>();

		list.add("���� �Դ� ��");
		list.add("ȭ���ϰ� �Դ� ��");
		list.add("�������� ���� ��");
		list.add("���� ������ �Դ� ��");
		list.add("�ݻ��԰� �� �Դ� ��");
		list.add("���ϸ鼭 �Դ� ��");
		list.add("������ ã�ƴٴϸ� �Դ� ��");

		return list;
	}// data

	public Document createXml(List<String> weekMsg) {

		// 1. xml������ü ����.
		Document doc = new Document();

		// 2. �ֻ��� ��� ����.
		Element rootNode = new Element("week");

		// 3. ���� ��� ����.
		Element msgNode = null;
		for (String data : weekMsg) {

			msgNode = new Element("msg");

			// 4. ���� ��忡 �� ����.
			msgNode.setText(data);

			// 5.���� ���� ���� ��带 ���� ��忡 �Ҵ�.
			rootNode.addContent(msgNode);
		} // end for each

		// 6. ���� ��带 xml���� ��ü�� �߰�.
		doc.addContent(rootNode);

		return doc;
	}// createXml

	public void createXmlFile(Document doc) throws IOException {

		// 7. ��°�ü ���� : Compact, raw format�� �� �ٷ� ����Ѵ�. pretty�� ���� �ٲ㼭 ���.
		XMLOutputter x_out = new XMLOutputter(Format.getPrettyFormat());

		// 8. xml���� ��ü�� ��� ��Ʈ���� ����Ͽ� ���.
		x_out.output(doc, System.out); //�ֿܼ� ���.
		x_out.output(doc, new FileOutputStream("C:/dev/workspace/jsp_prj/WebContent/xml0327/jdom_msg.xml")); //�ֿܼ� ���.

	}// createXmlFile

	public static void main(String[] args) {

		CreateJdomXml c = new CreateJdomXml();
		try {
			c.createXmlFile(c.createXml(c.data()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// main

}// class
