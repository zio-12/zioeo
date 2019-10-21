package nabong.bbs.service.impl;

import java.util.List;

import nabong.bbs.vo.PageVo;

public interface PageDao {

	List<PageVo> memberInfo() throws Exception;

}
