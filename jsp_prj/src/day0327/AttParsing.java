package day0327;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AttParsing {

	public List<AttVO> personData(String lastName) throws MalformedURLException, JDOMException, IOException {
		List<AttVO> list = new ArrayList<>();

		// 1. Builder 생성(Parser)
		SAXBuilder builder = new SAXBuilder();

		// 2. XML읽기
		Document doc = builder.build(new URL("http://localhost:8080/jsp_prj/xml0327/att.xml"));

		// 3. 최상위 노드 얻기.
		Element rootNode = doc.getRootElement();

		// 4. 최상위 - 하위노드들 얻기. (<person>)
		Iterator<Element> personNodes = rootNode.getChildren().iterator();

		// 5. 얻어낸 모든 person node를 반복.
		Element personNode = null;
		Iterator<Element> personSubNodes = null;
		Element someNode = null; // <person>의 하위 노드 저장. - <name> 또는 <address>
		Attribute lastAtt = null; // lastName 속성을 저장.
		Attribute cityAtt = null; // city 속성을 저장.
		Attribute zipcodeAtt = null; // zipcode 속성을 저장.
		String lastNameAtt = "";
		AttVO a_vo = null;

		// <person>들을 얻는다.
		while (personNodes.hasNext()) {

			// 반복중인 personNode하나 얻기.
			personNode = personNodes.next();

			// <person>의 하위 노드 얻기. - <name> 또는 <address>
			personSubNodes = personNode.getChildren().iterator();
			while (personSubNodes.hasNext()) {
				someNode = personSubNodes.next();

				// 입력된 성씨로 값을 생성해야하므로 성씨가 있는 <name>을 비교.
				if ("name".equals(someNode.getName())) {
					lastAtt = someNode.getAttribute("lastName"); // "성"
					lastNameAtt = lastAtt.getValue(); // "성"의 값
					// 매개변수 성과 xml에서 읽어들인 태그의 속성이 같을 때.
					if (lastName.equals(lastNameAtt)) {
						a_vo = new AttVO();
						a_vo.setFirstName(someNode.getText());
						a_vo.setLastName(lastNameAtt);
					} // end if
				} // end if

				// <name> 사이의 값
				if (lastName.equals(lastNameAtt)) {
					// <address> 얻기.
					if ("address".equals(someNode.getName())) {
						cityAtt = someNode.getAttribute("city");
						zipcodeAtt = someNode.getAttribute("zipcode");

						a_vo.setCity(cityAtt.getValue());
						a_vo.setZipcode(zipcodeAtt.getValue());
						a_vo.setAddress(someNode.getText());
						list.add(a_vo); // 입력한 성씨와 일치하는 값을 parsing한 객체를 list에 추가.
					} // end if
				} // end if

			} // end while

		} // end while

		return list;
	}// class

//	public static void main(String[] args) {
//
//		AttParsing a = new AttParsing();
//		try {
//
//			System.out.println(a.personData("정"));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JDOMException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}// main

}// class
