package nabong.bbs.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;
import  org.springframework.beans.factory.annotation.Autowired;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import nabong.bbs.vo.PageVo;

@Repository("pageDao")
public class PageDaoImpl extends EgovAbstractDAO implements PageDao{
	
	private SqlSessionTemplate sqlSession;

	private String namespace = "org.egovframework.sqlmap.example.mappers.pageMapper";
	
	@Override
	public List<PageVo> memberInfo() throws Exception {
		
		return sqlSession.selectList(namespace + ".test");
	}
}
