package nabong.bbs.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import nabong.bbs.mapper.PageMapper;
import nabong.bbs.service.PageService;
import nabong.bbs.vo.PageVo;
import nabong.bbs.vo.commonFileVo;

@Service("pageService")
public class PageServiceImpl extends EgovAbstractServiceImpl implements PageService {

	@Resource(name = "pageMapper")
	private PageMapper pageMapper;

	@Override
	public void joinCheckService(PageVo vo) {
		
		pageMapper.joinCheck(vo);
		
	}
	
	@Override
	public PageVo joinCheck(PageVo vo) {
		
		return pageMapper.joinCheck2(vo);
		
	}

	@Override
	public PageVo findUserService(PageVo vo) {
		
		return pageMapper.findUser(vo);
		
	}
	
	
	/* 공지사항 */
	@Override
	public List<PageVo> getnoticeService(int boardValue) throws Exception {

		List<PageVo> data = pageMapper.getList(boardValue);

		return data;
	}
	@Override
	public List<PageVo> searchNoticeService(PageVo vo){
		System.out.println(vo.getSearchName());
		return pageMapper.search(vo);
		
	}

	// c
	@Override
	public void insertNoticeService(PageVo vo) throws Exception {
		String filePath = "locaition"; //이거 초기화 해줘야지 됨
		UUID uuid = UUID.randomUUID(); // 랜덤한 이름
		filePath = "C:\\egovframework\\upload/";

		MultipartFile file = vo.getMpfile();
		String orgFileNm = file.getOriginalFilename(); //원래 파일이름
//		String fileExt = orgFileNm.substring(orgFileNm.lastIndexOf('.') + 1);
//		String fileName = orgFileNm.substring(0, orgFileNm.lastIndexOf('.'));

		//String fullFileName = fileName + "_" + new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + "." + fileExt;

		//System.out.println(fullFileName);
		String fullFileName = uuid.toString() + "_" + orgFileNm; // 최종 파일 이름은 랜덤한 이름 + 원래 파일이름 으로 저장
		
//		vo.setFileName(orgFileNm);
//		vo.setFileChangeName(fullFileName);
//		vo.setFilePath((filePath + vo.getFileChangeName()));
		
		try {
			file.transferTo(new File(filePath + File.separator + fullFileName));
			vo.setFileName(orgFileNm);
			vo.setFileChangeName(fullFileName);
			vo.setFilePath(("C:\\\\egovframework\\\\upload/" + vo.getFileChangeName()));
			pageMapper.noticeUpload(vo);

		} catch (Exception e) {

			e.printStackTrace();
		}
			
	}

	// u
	@Override
	public void updateNoticeService(PageVo vo) throws Exception {
		String filePath = "locaition"; //이거 초기화 해줘야지 됨

		filePath = "C:\\egovframework\\upload";

		MultipartFile file = vo.getMpfile();
		String orgFileNm = file.getOriginalFilename();
		String fileExt = orgFileNm.substring(orgFileNm.lastIndexOf('.') + 1);
		String fileName = orgFileNm.substring(0, orgFileNm.lastIndexOf('.'));

		String fullFileName = fileName + "_" + new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + "." + fileExt;

		System.out.println(fullFileName);
		
		try {
			file.transferTo(new File(filePath + File.separator + fullFileName));
			vo.setFileName(fullFileName);
			pageMapper.noticeUpdate(vo);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// r
	@Override
	public PageVo readNoticeService(int boardNo) throws Exception {
		
		return pageMapper.noticeRead(boardNo);

	}
	//조회수
	@Override
	public void noticeCountService(int boardNo) throws Exception {
		
		pageMapper.noticeCount(boardNo);

	}

	// d
	@Override
	public void deleteNoticeService(int boardNo) throws Exception {

		pageMapper.noticeDelete(boardNo);

	}

	// 조회수
	@Override
	public void countNoticeService(int boardNo) throws Exception {

		pageMapper.noticeCount(boardNo);

	}

	/* 공지사항 끝 */

	@Override
	public boolean loginService(HttpSession session, PageVo vo) throws Exception {
		if (pageMapper.login(vo) == null) {
			System.out.println("Service : Fali");
			return false;
		} else {
			System.out.println("Service : Success");
			session.setAttribute("userId", vo.getUserId());
			session.setAttribute("userPw", vo.getUserPw());
			return true;
		}
	}
	@Override
	public List<PageVo> getCommentService(int boardNo) throws Exception {
		
		return pageMapper.getComment(boardNo);
	}
	
	@Override
	public void deleteCommentService(int commentNo)throws Exception  {
		
		pageMapper.deleteComment(commentNo);
		
	};
	
	@Override
	public void insertCommentService(PageVo vo)throws Exception  {
		
		pageMapper.insertComment(vo);
	};

	// 마이페이지
	@Override
	public PageVo myPageService(HttpSession session, String id) throws Exception {

		PageVo member = pageMapper.getUserInfo(id);
		System.out.println("myPageService ID : " + id);
		System.out.println(member);
		return member;
	}

	// 안씀
	@Override
	public String memberInfoService() throws Exception {

		List<PageVo> data = pageMapper.testDB();
		return data.get(0).getUserId();
	}

	// 나중에
	@Override
	public void fileUpload(PageVo pageVo, Boolean isLocal) throws Exception {

		String filePath = "/usr/local/리눅스 서버 경로.....";
		if (isLocal) {
			filePath = "C:\\egovframework\\upload/";
		}

		MultipartFile file = pageVo.getMpfile();
		String orgFileNm = file.getOriginalFilename();
		String fileExt = orgFileNm.substring(orgFileNm.lastIndexOf('.') + 1);
		String fileName = orgFileNm.substring(0, orgFileNm.lastIndexOf('.'));

		String fullFileName = fileName + "_" + new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + "." + fileExt;

		System.out.println(fullFileName);

		try {

			file.transferTo(new File(filePath + File.separator + fullFileName));
			pageVo.setFileName(orgFileNm);
			pageVo.setFileChangeName(fullFileName);
			pageVo.setFilePath((filePath + pageVo.getFileChangeName()));
			pageMapper.fileUploadLog(pageVo);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<PageVo> fileList() throws Exception {

		List<PageVo> list = pageMapper.fileList();

		return list;

	}

	@Override
	public List<PageVo> getTestData(int boardValue) throws Exception {

		List<PageVo> list = pageMapper.test(boardValue);

		return list;

	}
	
	
	@Override
	public PageVo fileDownload(PageVo pageVO) throws Exception{
		PageVo pageVo = pageMapper.fileDownload(pageVO);
		return pageVo;
	}
}
