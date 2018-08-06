package kr.or.ddit.cookie;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CookieUtilTest {
	
	private String cookie;
	
	@Before
	public void setUp(){
		cookie = "userId=brown; rememberMe=y; checkYn=n";
	}
	
	/**
	* Method : cookieSplitTest
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC15
	* 변경이력 :
	* Method 설명 : 쿠키 전체 값에 대한 분리 작업 확인
	*/
	@Test
	public void cookieSplitTest(){
		
		/***Given***/
		String[] cookies = cookie.split("; ");

		/***When***/
		
		/***Then***/
		assertEquals(3, cookies.length);
		assertEquals("userId=brown", cookies[0]);
		assertEquals("rememberMe=y", cookies[1]);
		assertEquals("checkYn=n", cookies[2]);
		
		//"기대값(예측)"
		assertEquals("brown", cookies[0].split("=")[1]);
		assertEquals("y", cookies[1].split("=")[1]);
		assertEquals("n", cookies[2].split("=")[1]);
		
	}
	
	@Test
	public void cookieNameValueSplitTest(){
		/***Given***/
		String cookie = "userId=brown";
		
		/***When***/
		//cookieArr[0] = userId
		//cookieArr[1] = brown
		
		String[] cookieArr = cookie.split("=");

		/***Then***/

	}

//	@Test
//	public void test() {
//		
//		/***Given***/
//		String cookie = "userId=brown; rememberMe=y";
//		CookieUtil cookieUtil = new CookieUtil();
//		
//		/***When***/
//		//uesrId ==> brown
//		String cookieValue = cookieUtil.getCookie(cookie,"userId");
//
//		/***Then***/
//		assertEquals("brown", cookieValue);
//		
//	}

}
