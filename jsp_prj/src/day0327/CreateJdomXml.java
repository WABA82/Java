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

		list.add("월래 먹는 날");
		list.add("화끈하게 먹는 날");
		list.add("수도없이 없는 날");
		list.add("목이 터지게 먹는 날");
		list.add("금새먹고 또 먹는 날");
		list.add("토하면서 먹는 날");
		list.add("일일히 찾아다니며 먹는 날");

		return list;
	}// data

	public Document createXml(List<String> weekMsg) {

		// 1. xml문서객체 생성.
		Document doc = new Document();

		// 2. 최상위 노드 생성.
		Element rootNode = new Element("week");

		// 3. 하위 노드 생성.
		Element msgNode = null;
		for (String data : weekMsg) {

			msgNode = new Element("msg");

			// 4. 하위 노드에 값 설정.
			msgNode.setText(data);

			// 5.값을 가진 하위 노드를 상위 노드에 할당.
			rootNode.addContent(msgNode);
		} // end for each

		// 6. 상위 노드를 xml문서 객체에 추가.
		doc.addContent(rootNode);

		return doc;
	}// createXml

	public void createXmlFile(Document doc) throws IOException {

		// 7. 출력객체 생성 : Compact, raw format은 한 줄로 출력한다. pretty은 줄을 바꿔서 출력.
		XMLOutputter x_out = new XMLOutputter(Format.getPrettyFormat());

		// 8. xml문서 객체와 출력 스트림을 사용하여 출력.
		x_out.output(doc, System.out); //콘솔에 출력.
		x_out.output(doc, new FileOutputStream("C:/dev/workspace/jsp_prj/WebContent/xml0327/jdom_msg.xml")); //콘솔에 출력.

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
