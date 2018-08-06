package kr.or.ddit.calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	
	/*
	 * beforeClass(@beforeClass)
	 setUp() (@Before) 실행 -> 테스트 메소드 실행 --> tearDown()(@After) 실행
	 setUp() (@Before) 실행 -> 테스트 메소드 실행 --> tearDown()(@After) 실행
	 setUp() (@Before) 실행 -> 테스트 메소드 실행 --> tearDown()(@After) 실행
	 setUp() (@Before) 실행 -> 테스트 메소드 실행 --> tearDown()(@After) 실행
	 afterClass(@fterClass)
	 */
	private Calculator cal;
	private int param1;
	private int param2;
	
	@Before
	public void setUp(){
		cal = new Calculator();
		param1 = 6;
		param2 = 5;
		
	}
	
	@After
	public void tearDown(){
		System.out.println("after");
		
	}
	

	/**
	* Method : addtest
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC15
	* 변경이력 :
	* Method 설명 : 계산기의 덧셈 가능 테스트
	*/
	@Test
	public void addtest() { //메서드 이름부터 작성
		
		/***Given***/

		/***When***/
		int addResult = cal.add(param1, param2);

		/***Then***/
		assertEquals(11, addResult); 

	}
	
	/**
	* Method : minusTest
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC15
	* 변경이력 :
	* Method 설명 : 계산기의 뺄셈 기능 테스트
	*/
	@Test
	public void minusTest(){
		/***Given***/
		/***When***/
		int minusResult = cal.minus(param1, param2);

		/***Then***/
		assertEquals(1, minusResult);

	}
	
	@Test
	public void mulTest(){
		/***Given***/

		/***When***/
		int mulResult = cal.mul(param1, param2);
		

		/***Then***/
		assertEquals(30, mulResult);
		
	}
	
	@Test
	public void divTest(){
		/***Given***/

		/***When***/
		int divResult = cal.div(param1, param2);
		

		/***Then***/
		assertEquals(6/5, divResult);
	}
	
	/**
	* Method : diveByZeroTest
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC15
	* 변경이력 :
	* Method 설명 : 계산기 나눗셈의 0으로 나누었을 때의 예외 확인
	*/
	@Test
	public void divByZeroTest(){
		/***Given***/
		param2 = 0;

		/***When***/
		int divResult = cal.div(param1, param2);
		
		/***Then***/
		assertEquals(0, divResult);

	}
	
	

}












