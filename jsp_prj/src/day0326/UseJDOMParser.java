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
 * JDOM 파서의 사용.
 * 
 * @author owner
 *
 */
public class UseJDOMParser {

	public UseJDOMParser() throws JDOMException, IOException {
		// 1. Parser생성
		SAXBuilder builder = new SAXBuilder();

		// 2-1. 로컬에서 XML문서 가져오기.
//		Document doc = builder.build(new File("C:/dev/workspace/jsp_prj/WebContent/xml0326/names.xml"));

		// 2-2. Web Server에서 XML문서 가져오기
		Document doc = builder.build(new URL("http://localhost:8080/jsp_prj/xml0326/names.xml"));

		// 3. 문서객체에서 최상위 부모노드 얻기.
		Element rootNode = doc.getRootElement();

		// 4. 부모 노드의 자식 노드 얻기.
		Iterator<Element> namesNode = rootNode.getChildren().iterator();
		
		// 5. 자식노드 순환하면서 얻기.
		Element nameNode = null;
		while(namesNode.hasNext()) {
			// 자식 노드 얻기.
			nameNode = namesNode.next();
			System.out.println("노드명 : "  + nameNode.getName());
			System.out.println("노드명 : "  + nameNode.getValue());
		}// end while
	}// 생성자

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
