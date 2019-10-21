package nabong.bbs.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import nabong.bbs.service.PageService;
import nabong.bbs.vo.PageVo;
import nabong.bbs.vo.PagingVo;

@Controller
public class PageController {
	@Autowired
	private PageService pageService;

	// 아이디&비밀번호 찾기 폼
	@RequestMapping("/findUser.do")
	public String findUser(Model mv) throws Exception {

		return "find";

	}

	// 아이디&비밀번호 찾기 체크 아 왜 .do를쓰라는지알겠ㄷㄻㅇㄴㄻㅇ러ㅏㅣ;ㄴ어ㅏㅣ;
	@RequestMapping("/findUserCheck.do")
	public String findUser(@ModelAttribute PageVo vo, Model mv, HttpSession session) throws Exception {

		if (pageService.findUserService(vo) == null) {
			String check = "no";
			mv.addAttribute("check", check);
			System.out.println("결과 없음");
			return "redirect:findUser.do";
		} else {
			String check = "Yes";
			mv.addAttribute("check", check);
			mv.addAttribute("find", pageService.findUserService(vo));
			System.out.println("결과 있음");
			return "redirect:findUser.do";
		}

	}

	// 회원가입 폼
	@RequestMapping("/join.do")
	public String join(Model mv) throws Exception {

		return "join";

	}

	// 회원가입 체크 넣어야됨
	@RequestMapping("/joinCheck.do")
	public String joinCheck(@ModelAttribute PageVo vo, Model mv) throws Exception {
		
		if(pageService.joinCheck(vo) != null) {
			String check = "overlepId";
			mv.addAttribute("check", check);	
			return "join";
		}else {
		pageService.joinCheckService(vo);
		String check = "joinOk";
		mv.addAttribute("check", check);
			return "login";
		}
	}


	// 메인
	@RequestMapping("/main.do")
	public String Main(Model mv, PageVo vo) throws Exception {

		List<PageVo> list = pageService.getnoticeService(1);
		List<PageVo> QnAList = pageService.getnoticeService(2);
		List<PageVo> FreeList = pageService.getnoticeService(3);

		mv.addAttribute("boardList", list);
		mv.addAttribute("QnAList", QnAList);
		mv.addAttribute("FreeList", FreeList);

		return "main";
	}

	// 로그인 창
	@RequestMapping("/login.do")
	public String login(HttpSession session) {

		if (session.getAttribute("userId") == null) {
			return "login";

		} else {
			System.out.println("로그인되어있는경우에는 로그인창 갈수 없음");
			System.out.println("로그인 정보 : " + session.getAttribute("userId"));
			return "main";
		}
	}

	// 로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:main.do";
	}

	@RequestMapping("/myPage.do")
	public String myPage(HttpSession session, PageVo vo, Model model) throws Exception {
		String check = "login";

		if (session.getAttribute("userId") == null) {
			model.addAttribute("check", check);
			return "login";

		} else {
			String id = (String) session.getAttribute("userId");
			vo = pageService.myPageService(session, id);
			System.out.println(vo.getJoinTime());
			model.addAttribute("info", vo);
			return "myPage";
		}
	}

	@RequestMapping("/loginCheck.do")
	public String loginCheck(HttpSession session, @ModelAttribute PageVo vo, Model model) throws Exception {

		boolean check = pageService.loginService(session, vo);

		if (check) {
			System.out.println("로그인 성공");
			System.out.println(session.getAttribute("userId"));
			System.out.println(session.getAttribute("userPw"));
			return "redirect:main.do";
		} else {
			System.out.println("로그인 실패");
			System.out.println(check);
			model.addAttribute("check", check);
			return "login";
		}

	}

	// 검색
	@RequestMapping("/search.do")
	public String noticeSearch(@RequestParam("boardValue") int boardValue, @ModelAttribute PageVo vo,
			@RequestParam(defaultValue = "1") int curPage, HttpSession session, Model mv) throws Exception {
		vo.setBoardValue(boardValue);
		List<PageVo> list = pageService.searchNoticeService(vo);
		mv.addAttribute("list", list);
		PagingVo paging = new PagingVo(5, 7, list.size(), curPage);
		mv.addAttribute("boardValue", boardValue);
		mv.addAttribute("page", paging);
		if (curPage > paging.getEndPage()) {
			curPage = 1;
			return "redirect:notice.do";
		}
		return "notice";
	}

	/* 공지사항 */
	// 목록
	@RequestMapping("/notice.do")
	public String noticeBoard(@RequestParam("boardValue") int boardValue, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session, Model mv) throws Exception {

		List<PageVo> list = pageService.getnoticeService(boardValue);
		PagingVo paging = new PagingVo(5, 7, list.size(), curPage);
		mv.addAttribute("list", list);
		mv.addAttribute("boardValue", boardValue);
		mv.addAttribute("page", paging);
		if (curPage > paging.getEndPage()) {
			curPage = 1;
			return "redirect:notice.do";
		}
		return "notice";
	}

	// r
	@RequestMapping("/read.do")
	public String noticeRead(@RequestParam("boardNo") int boardNo, HttpSession session, Model mv) throws Exception {
		String check = "login";
		PageVo vo = pageService.readNoticeService(boardNo);

		if (session.getAttribute("userId") != null) {
			pageService.countNoticeService(boardNo);
			mv.addAttribute("list", vo);// 조회수
			mv.addAttribute("commentList", pageService.getCommentService(boardNo));// 댓글
			return "read";

		} else {
			mv.addAttribute("check", check);
			return "login";
		}
	}

	// c 화면
	@RequestMapping("/write.do")
	public String noticeWrite(String check, HttpSession session, Model mv) throws Exception {
		check = "write";
		if (session.getAttribute("userId") != null) {
			mv.addAttribute("check", check);
			return "write";
		} else {
			check = "login";
			mv.addAttribute("check", check);
			return "login";
		}
	}

	// u 화면
	@RequestMapping("/update.do")
	public String noticeUpdate(@RequestParam("check") String check, @RequestParam("boardNo") int boardNo,
			HttpSession session, Model mv) throws Exception {

		if (session.getAttribute("userId") != null) {
			mv.addAttribute("list", pageService.readNoticeService(boardNo));
			mv.addAttribute("check", check);
			return "write";
		} else {
			check = "login";
			mv.addAttribute("check", check);
			return "login";
		}
	}

	// c, u check
	@RequestMapping("/writeCheck.do")
	public String noticeWriteCheck(MultipartHttpServletRequest req, @RequestParam("check") String check,
			@ModelAttribute PageVo vo) throws Exception {

		String string = "write";
		boolean isLocal = false;
		Iterator<String> itr = req.getFileNames();

		String requestUrl = new String(req.getRequestURL());
		System.out.println(requestUrl);
		if (requestUrl.contains("localhost") || requestUrl.contains("127.0.0.1")) {
			isLocal = true;
		}

		while (itr.hasNext()) {
			MultipartFile mpf = req.getFile(itr.next());

			vo.setMpfile(mpf); // 파일
			if (check.equals(string)) {
				System.out.println("noticeWriteCheck : write " + vo.getBoardValue());
				pageService.insertNoticeService(vo);
				return "redirect:notice.do?boardValue=" + vo.getBoardValue();
			} else {
				System.out.println("noticeWriteCheck : update " + vo.getBoardNo());
				pageService.updateNoticeService(vo);
				return "redirect:notice.do?boardValue=" + vo.getBoardNo();
			}
		}
		return "redirect:notice.do?boardValue=" + vo.getBoardValue();
	}

	// d
	@RequestMapping("/delete.do")
	public String noticeDelete(@RequestParam("boardNo") int boardNo) throws Exception {

		System.out.println("noticeDelete : boardNo : " + boardNo);
		pageService.deleteNoticeService(boardNo);

		return "redirect:main.do";
	}

	/* 게시판 끝 */
	// 댓글 추가
	@RequestMapping("/insertComment.do")
	public String insertComment(@RequestParam("boardNo") int boardNo, @ModelAttribute PageVo vo) throws Exception {
		vo.setBoardNo(boardNo);

		pageService.insertCommentService(vo);

		return "redirect:read.do?boardNo=" + boardNo;
	}

	// 댓글 삭제
	@RequestMapping("/deleteComment.do")
	public String deleteComment(@RequestParam("boardNo") int boardNo, @RequestParam("commentNo") int commentNo)
			throws Exception {

		pageService.deleteCommentService(commentNo);

		return "redirect:read.do?boardNo=" + boardNo;
	}

	@RequestMapping("/upload.do")
	public String fileUploadTest() {

		System.out.println("~~");

		return "Upload";
	}

	@RequestMapping("/fileUpload.do")
	public String fileUploadTest(MultipartHttpServletRequest req, ModelAndView mv) throws Exception {

		System.out.println("파일 업로드 시작");
		Iterator<String> itr = req.getFileNames();

		boolean isLocal = false;
		PageVo vo = new PageVo();
		vo.setBoardUser(req.getParameter("boardUser"));// 유저아이디
		vo.setBoardTitle(req.getParameter("boardTitle"));// 제목
		vo.setBoardText(req.getParameter("boardText"));// 내용

		String requestUrl = new String(req.getRequestURL());
		System.out.println(requestUrl);
		if (requestUrl.contains("localhost") || requestUrl.contains("127.0.0.1")) {
			isLocal = true;
		}

		while (itr.hasNext()) {
			MultipartFile mpf = req.getFile(itr.next());

			vo.setMpfile(mpf); // 파일
			pageService.fileUpload(vo, isLocal);
		}

		return "Upload";
	}

	@RequestMapping(value = "/fileDownload.do")
	public String bbsFileDownload(HttpServletResponse response, @ModelAttribute("pageVo") PageVo pageVo,
			// 글번호
			@RequestParam(required = true, value = "boardNo") int boardNo, ModelMap model) throws Exception {
		// AtchFileVO가 파일명, 경로, 크기 이런거 들어있는 Vo
		PageVo fileInfo = new PageVo();
		// 어떤글에 있는 파일인가 찾기위해서 wirtNum
		fileInfo.setBoardNo(boardNo);
		// 첨부파일 DB정보 가지고 오는거
		pageVo = pageService.fileDownload(fileInfo);
		System.out.println("1");
		byte[] fileByte;
		// atchFileVO.getFilePst() 저 부분에 저장경로 적어주면됨
		System.out.println("22");
		System.out.println(pageVo.getFilePath());
		fileByte = FileUtils.readFileToByteArray(new File(pageVo.getFilePath()));
		System.out.println(fileByte);
		System.out.println("2");
		response.setContentType("application/octet-stream");
		System.out.println("3");
		response.setContentLength(fileByte.length);
		System.out.println("4");
		// encode 안에는 어떤 파일명으로 다운받을지, 저장할때 파일명이 변경되서 원래 이름 정보도 저장해서 그 이름으로 다운받게 함
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode(pageVo.getFileName(), "UTF-8") + "\";");
		System.out.println("5");
		response.setHeader("Content-Transfer-Encoding", "binary");
		System.out.println("6");
		response.getOutputStream().write(fileByte);
		System.out.println("7");
		response.getOutputStream().flush();
		System.out.println("8");
		response.getOutputStream().close();
		System.out.println("9");
		return "redirect:read.do?boardNo=" + boardNo;
	}

	@RequestMapping("/testDB.do")
	public @ResponseBody String testDB() throws Exception {

		return pageService.memberInfoService();
	}
}
