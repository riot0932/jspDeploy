package kr.or.ddit.lprod;


import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.lprod.dao.lprodDaoInf;
import kr.or.ddit.lprod.dao.lprodDao;
import kr.or.ddit.lprod.model.lprodVo;

import org.junit.Before;
import org.junit.Test;

public class lprodDaoTest {
	
	private lprodDaoInf lprodDao;

	@Before
	public void setUp() {
		lprodDao = new lprodDao();
	}

	@Test
	public void selectAllLprod(){
		/***Given***/
		

		/***When***/
		List<lprodVo> lprodList = lprodDao.selectAllLprod();
		for(lprodVo vo : lprodList){
			System.out.println(vo);
		}
		/***Then***/
		assertEquals(11, lprodList.size());
		

	}
	
}
