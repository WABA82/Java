package kr.co.sist.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.dao.JdbcDAO;
import kr.co.sist.domain.DetailMember;
import kr.co.sist.domain.Member;
import kr.co.sist.vo.MemberImg;
import kr.co.sist.vo.MemberUpdateVO;
import kr.co.sist.vo.MemberVO;

@Component
public class JdbcService {

	@Autowired(required = false)
	private JdbcDAO jdao;

	public boolean fileUploadProcess(HttpServletRequest request, Model model) throws IOException {
		boolean flag = false;

		// 파일 업로드
		MultipartRequest mr = new MultipartRequest(request, "C:/dev/workspace/spring_jdbc/WebContent/upload/", 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());

		// 바뀌어진 이름으로 추가되어야 하므로 DefaultFileNamePolicy로 만들어진
		// 새로운 이름을 getFilesystemName을 통해 얻어 img명을 넣는다
		MemberVO mv = new MemberVO(mr.getParameter("name"), mr.getFilesystemName("upfile"), mr.getParameter("loc"), mr.getParameter("hightschool"));

		try {
			jdao.insertMember(mv);
			model.addAttribute("inputData", mv);
			flag = true;
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}

		return flag;
	}

	public List<Member> searchAllMember() {
		List<Member> list = null;
		try {
			list = jdao.selectAllMember();
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		return list;
	}

	public DetailMember searchOneMember(int num) {
		DetailMember dm = null;
		try {
			dm = jdao.selectOneMember(num);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		return dm;
	}

	public boolean updateMember(MemberUpdateVO mu_vo) {
		boolean flag = false;
		try {
			flag = jdao.updateMember(mu_vo) == 1;
		} catch (Exception e) {
			e.printStackTrace();
		} // end catch
		return flag;
	}// updateMember

	public boolean removeMember(int num) {
		boolean flag = false;
		try {
			MemberImg mi = jdao.deleteMember(num);

			flag = mi.getCnt() == 1;

			// 삭제된 레코드가 존재한다면
			if (flag) {
				// default.png가 아니였을 때 파일을 삭제.
				if (!"default.png".equals(mi.getImg())) {
					File file = new File("C:/dev/workspace/spring_jdbc/WebContent/upload/" + mi.getImg());
					file.delete();
				} // end if
			} // end if

		} catch (Exception e) {
			e.printStackTrace();
		} // end catch
		return flag;
	}// removeService

}
