package nabong.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import nabong.bbs.vo.PageVo;

/*@Configuration*/
@Mapper("pageMapper")
public interface PageMapper {
	
	public List<PageVo> testDB() throws Exception;

	public void fileUploadLog(PageVo pageVo) throws Exception;

	public List<PageVo> fileList() throws Exception;

	public PageVo login(PageVo vo) throws Exception;

	public List<PageVo> getList(int boardValue)throws Exception; //리스트그래서 
	public void noticeUpload(PageVo vo) throws Exception;  //글등록 
	public void noticeUpdate(PageVo vo) throws Exception;  //글 업데이트
	public PageVo noticeRead(int boardNo) throws Exception; //글읽기 
	public void noticeDelete(int boardNo) throws Exception;  //글 삭제
	public void noticeCount(int boardNo) throws Exception;  //조회수
	
	public PageVo getUserInfo(String id) throws Exception;
	
	public List<PageVo> test(int boardValue) throws Exception;
	
	public PageVo fileDownload(PageVo pageVo) throws Exception;
	
	public List<PageVo> getComment(int boardNo) throws Exception;//댓글
	public void insertComment(PageVo vo) throws Exception;
	public void deleteComment(int commetnNo) throws Exception;

	public List<PageVo> search(PageVo vo);

	public void joinCheck(PageVo vo);

	public PageVo findUser(PageVo vo);

	public PageVo joinCheck2(PageVo vo);
	
	
	
	
	
}
