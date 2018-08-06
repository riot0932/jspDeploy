package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.lprodDaoInf;
import kr.or.ddit.lprod.dao.lprodDao;
import kr.or.ddit.lprod.model.lprodVo;

public class lprodService implements lprodServiceInf {
	
	lprodDaoInf lprodDao = new lprodDao();

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
		return lprodDao.selectAllLprod();
	}

	/**
	* Method : getlprodPageList
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 페이지 리스트
	*/
	@Override
	public Map<String, Object> getlprodPageList(Map<String, Integer> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//lprod 리스트 조회
		List<lprodVo> pageList = lprodDao.getlprodPageList(map);
		resultMap.put("pageList", pageList);
		
		//학생 전체 건수 조회
		int totCnt = lprodDao.getlprodTotCnt();
		resultMap.put("totCnt", totCnt);
		
		//페이지 네비게이션 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));
		
		return resultMap;
	}

	/**
	* Method : makePageNavi
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	* Method 설명 : 페이지 네비게이션
	*/
	private String makePageNavi(int page, int pageSize, int totCnt) {
		int cnt = totCnt / pageSize;	//몫
		int mod = totCnt % pageSize;	//나머지

		if(mod > 0){
			cnt++;
		}
		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1 ? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/lprodList?page="+prevPage+"&pageSize="+pageSize+"\"aria-label=\"Previous\">"
				+ "<span aria-hidden=\"true\">&laquo;</span></a></li>");
		
		for(int i = 1; i<= cnt; i++){
			String activeClass = "";
			if( i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li "+activeClass+"><a href=\"/lprodList?page="
					+i+"&pageSize="+pageSize+"\">"+ i +"</a></li>");
		}
		
		pageNaviStr.append("<li><a href=\"/lprodList?page="+nextPage+"&pageSize="+pageSize+"\" aria-label=\"Next\">"
				+ "<span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();
	}

}
