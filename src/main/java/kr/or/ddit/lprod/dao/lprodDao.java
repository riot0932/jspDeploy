package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.lprod.model.lprodVo;
import kr.or.ddit.mybatis.SplMapSessionFactory;

public class lprodDao implements lprodDaoInf {

	private SqlSessionFactory sqlSessionfactory = 
			SplMapSessionFactory.getSqlSessionFactory();
	
	/**
	* Method : selectAllLprod
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* @return
	* Method 설명 :lprod 전체 목록 출력
	*/
	@Override
	public List<lprodVo> selectAllLprod() {
		SqlSession session = sqlSessionfactory.openSession();
		List<lprodVo> lprodList = session.selectList("lprod.selectAllLprod");
		session.close();
		return lprodList;
	}

	/**
	* Method : getlprodPageList
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : lprod 페이지 리스트 조회
	*/
	@Override
	public List<lprodVo> getlprodPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionfactory.openSession();
		List<lprodVo> lprodList = session.selectList("lprod.getlprodPageList", map);
		session.close();
		return lprodList;
	}

	/**
	* Method : getlprodTotCnt
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* @return
	* Method 설명 : 전체 건수 조회
	*/
	@Override
	public int getlprodTotCnt() {
		SqlSession session = sqlSessionfactory.openSession();
		int totalCnt = session.selectOne("lprod.getlprodTotCnt");
		session.close();
		return totalCnt;
	}

}
