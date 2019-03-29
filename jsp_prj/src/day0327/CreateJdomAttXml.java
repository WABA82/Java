package day0327;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreateJdomAttXml {

	public List<DataVO> data() {
		List<DataVO> list = new ArrayList<>();

		list.add(new DataVO("아반테", "현대", "김정윤", "승용", 1600));
		list.add(new DataVO("솔리드프로", "넥슨", "김희철", "스포츠카", 3000));
		list.add(new DataVO("연카", "넥슨", "공선의", "스포츠카", 800));
		list.add(new DataVO("소렌토", "기아", "이재찬", "SUV", 4800));
		list.add(new DataVO("MAN트럭", "MAN", "노진경", "트럭", 10000));

		return list;
	}// data

	public Document createXml(List<DataVO> carList) {

		// 1. xml문서객체 생성.
		Document doc = new Document();

		// 2. 최상위 노드 생성.
		Element rootNode = new Element("cars");

		// 3-1. 하위 노드 선언.
		Element carNode = null;
		Element carModelNode = null;
		Element companyNode = null;
		Element ownerNode = null;
		Element ccNode = null;

		// 3-2. 속성 노드 선언
		Attribute carTypeAtt = null;

		// 3-3. 하위 노드 생성
		for (DataVO data : carList) {

			carNode = new Element("car");

			carModelNode = new Element("model");
			companyNode = new Element("company");
			ownerNode = new Element("owner");
			ccNode = new Element("cc");

			carTypeAtt = new Attribute("car_type", data.getCarType());

			// 4. 하위 노드에 값 설정.
			carModelNode.setText(data.getCarModel());
			companyNode.setText(data.getCompany());
			ownerNode.setText(data.getOwner());
			ccNode.setText(String.valueOf(data.getCc()));

			// 속성 설정 하기.
			carNode.setAttribute(carTypeAtt);

			// 5. 값을 가진 하위 노드를 상위 노드에 추가.
			carNode.addContent(carModelNode);
			carNode.addContent(companyNode);
			carNode.addContent(ownerNode);
			carNode.addContent(ccNode);
			// 하위노드를 가진 <car>를 취상위노드에 배치
			rootNode.addContent(carNode);
		} // end for each

		// 6. 상위 노드를 xml문서 객체에 추가.
		doc.addContent(rootNode);

		return doc;
	}// createXml

	public void createXmlFile(Document doc) throws IOException {

		// 7. 출력객체 생성 : Compact, raw format은 한 줄로 출력한다. pretty은 줄을 바꿔서 출력.
		XMLOutputter x_out = new XMLOutputter(Format.getPrettyFormat());

		// 8. xml문서 객체와 출력 스트림을 사용하여 출력.
		x_out.output(doc, System.out); // 콘솔에 출력.
		x_out.output(doc, new FileOutputStream("C:/dev/workspace/jsp_prj/WebContent/xml0327/jdom_car.xml")); // 콘솔에 출력.

	}// createXmlFile

	public static void main(String[] args) {

		CreateJdomAttXml c = new CreateJdomAttXml();
		try {
			c.createXmlFile(c.createXml(c.data()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// main

}// class
