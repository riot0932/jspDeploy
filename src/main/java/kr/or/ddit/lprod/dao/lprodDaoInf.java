package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.lprodVo;

public interface lprodDaoInf {
	
	/**
	* Method : selectAllLprod
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체 목록 출력
	*/
	List<lprodVo> selectAllLprod();

	/**
	* Method : getlprodPageList
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 학생 페이지 리스트 조회
	*/
	List<lprodVo> getlprodPageList (Map<String, Integer> map);
	
	/**
	* Method : getlprodTotCnt
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* @return
	* Method 설명 : 전체 건수 조회
	*/
	int getlprodTotCnt();
}
