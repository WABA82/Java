package day0326;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * JDOM �ļ��� ���.
 * 
 * @author owner
 *
 */
public class UseJDOMParser {

	public UseJDOMParser() throws JDOMException, IOException {
		// 1. Parser����
		SAXBuilder builder = new SAXBuilder();

		// 2-1. ���ÿ��� XML���� ��������.
//		Document doc = builder.build(new File("C:/dev/workspace/jsp_prj/WebContent/xml0326/names.xml"));

		// 2-2. Web Server���� XML���� ��������
		Document doc = builder.build(new URL("http://localhost:8080/jsp_prj/xml0326/names.xml"));

		// 3. ������ü���� �ֻ��� �θ��� ���.
		Element rootNode = doc.getRootElement();

		// 4. �θ� ����� �ڽ� ��� ���.
		Iterator<Element> namesNode = rootNode.getChildren().iterator();
		
		// 5. �ڽĳ�� ��ȯ�ϸ鼭 ���.
		Element nameNode = null;
		while(namesNode.hasNext()) {
			// �ڽ� ��� ���.
			nameNode = namesNode.next();
			System.out.println("���� : "  + nameNode.getName());
			System.out.println("���� : "  + nameNode.getValue());
		}// end while
	}// ������

	public static void main(String[] args) {

		try {
			new UseJDOMParser();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main

}// class
