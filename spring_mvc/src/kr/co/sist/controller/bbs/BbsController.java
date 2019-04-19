package kr.co.sist.controller.bbs;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.domain.Diary;
import kr.co.sist.domain.DiaryDetail;
import kr.co.sist.domain.DiaryReply;
import kr.co.sist.service.DiaryService;
import kr.co.sist.vo.DiaryVO;
import kr.co.sist.vo.ReplyVO;

@Controller
public class BbsController {

	/**
	 * ������� diary/List.do ��û�� ���� diary/list.jsp ��ȯ.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/diary/list.do", method = GET)
	public String diaryList(DiaryVO d_vo, Model model) {

		DiaryService ds = new DiaryService();
		int totalCount = ds.totalCount(); // �� �Խù��� ��.
		int pageScale = ds.pageScale(); // �� ȭ�鿡 ������ �Խù��� ��.
		int totalPage = ds.totalPage(totalCount); // ��ü �Խù��� �����ֱ� ���� �� �������� ��.

		// ���� ȣ��� ���� �Ķ���� ���� �����Ǿ� ���� ���� ��.
		if (d_vo.getCurrentPage() == 0) {
			d_vo.setCurrentPage(1); // 1�� ���� ��ȸ�ؾ� �ϹǷ� 1�� ����.
		} // end if
		int startNum = ds.startNum(d_vo.getCurrentPage()); // ���۹�ȣ
		int endNum = ds.endNum(startNum);// ����ȣ

		d_vo.setStartNum(startNum);
		d_vo.setEndNum(endNum);

		List<Diary> diaryList = ds.searchDiaryList(d_vo); // ����Ʈ ��� ��ȸ.

		String indexList = ds.indexList(d_vo.getCurrentPage(), totalPage, "list.do");

		model.addAttribute("diaryList", diaryList);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currntPage", d_vo.getCurrentPage());

		return "/diary/list";
	}// diaryList()

	@RequestMapping(value = "/diary/bbs_read.do", method = GET)
	public String bbsRead(int num, Model model) {
		DiaryService ds = new DiaryService();
		DiaryDetail dd = ds.searchBbs(num); // ������ ������ ��ȸ.
		List<DiaryReply> replyList = ds.searchReplyList(num); // ������ ��۵��� ��ȸ.

		model.addAttribute("searchData", dd);
		model.addAttribute("replyList", replyList);

		return "diary/bbs_read";
	}// bbsRead

	@ResponseBody
	@RequestMapping(value = "/diary/add_reply.do", method = GET)
	public String writeReply(ReplyVO r_vo) {
		JSONObject json = null;
		DiaryService ds = new DiaryService();
		json = ds.writeReply(r_vo);
		return json.toJSONString();
	}

}// class
