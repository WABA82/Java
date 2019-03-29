package day0326;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JtbcRssParsing {

	private static JtbcRssParsing jrp;

	private JtbcRssParsing() {
	}// private 생성자

	public static JtbcRssParsing getInstance() {
		if (jrp == null) {
			jrp = new JtbcRssParsing();
		} // end if
		return jrp;
	}// getInstance

	public List<RssVO> getNews(String rssName) throws IOException, JDOMException {
		List<RssVO> list = new ArrayList<RssVO>();

		// 1.빌더 생성.
		SAXBuilder builder = new SAXBuilder();

		// 2. URL을 사용하여 외부 RSS 문서 객체 얻기.
		Document doc = builder.build(new URL("http://fs.jtbc.joins.com//RSS/" + rssName + ".xml"));

		// 3. 최상위 부모노드 얻기.<rss>
		Element rootNode = doc.getRootElement();

		// 4. 자식 노드(<channel>) 얻기.
		Element channelNode = rootNode.getChild("channel");

		// 5. <channel>의 자식 노드(태그)들 얻기.
		Iterator<Element> someNodes = channelNode.getChildren().iterator();

		Element someNode = null;
		Iterator<Element> itemSubNodes = null;
		Element itemSubNode = null;

		RssVO r_vo = null;

		while (someNodes.hasNext()) {
			someNode = someNodes.next();

			if ("item".equals(someNode.getName())) {
				// <item>의 모든 자식들 얻기.
				itemSubNodes = someNode.getChildren().iterator();
				// list에 담을 VO생성.
				r_vo = new RssVO();
				while (itemSubNodes.hasNext()) {
					itemSubNode = itemSubNodes.next();

					// <title>의 값 얻기.
					if ("title".equals(itemSubNode.getName())) {
						r_vo.setTitle(itemSubNode.getText());
					} // end if

					// <link>의 값 얻기.
					if ("link".equals(itemSubNode.getName())) {
						r_vo.setLink(itemSubNode.getText());
					} // end if

					// <description>의 값 얻기.
					if ("description".equals(itemSubNode.getName())) {
						r_vo.setDescription(itemSubNode.getText());
					} // end if

					// <pubDate>의 값 얻기.
					if ("pubDate".equals(itemSubNode.getName())) {
						r_vo.setPubDate(itemSubNode.getText());
					} // end if

				} // end while

				// list에 VO담기.
				list.add(r_vo);
			} // end if
		} // end while

		return list;
	}// getNews

	public static void main(String[] args) {
		JtbcRssParsing jrp = JtbcRssParsing.getInstance();
		try {
			System.out.println(jrp.getNews("newsflash"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
	}// main

}// class
