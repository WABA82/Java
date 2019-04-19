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
	 * 내비바의 diary/List.do 요청에 따른 diary/list.jsp 반환.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/diary/list.do", method = GET)
	public String diaryList(DiaryVO d_vo, Model model) {

		DiaryService ds = new DiaryService();
		int totalCount = ds.totalCount(); // 총 게시물의 수.
		int pageScale = ds.pageScale(); // 한 화면에 보여줄 게시물의 수.
		int totalPage = ds.totalPage(totalCount); // 전체 게시물을 보여주기 위한 총 페이지의 수.

		// 최초 호출로 웹의 파라미터 값이 설정되어 있지 않을 때.
		if (d_vo.getCurrentPage() == 0) {
			d_vo.setCurrentPage(1); // 1번 부터 조회해야 하므로 1로 설정.
		} // end if
		int startNum = ds.startNum(d_vo.getCurrentPage()); // 시작번호
		int endNum = ds.endNum(startNum);// 끝번호

		d_vo.setStartNum(startNum);
		d_vo.setEndNum(endNum);

		List<Diary> diaryList = ds.searchDiaryList(d_vo); // 리스트 목록 조회.

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
		DiaryDetail dd = ds.searchBbs(num); // 원글의 내용을 조회.
		List<DiaryReply> replyList = ds.searchReplyList(num); // 원글의 댓글들을 조회.

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
