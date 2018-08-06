package kr.or.ddit.student.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
	
	//@Before --> @Test --> @After
	
	//테스트 메소드 안에 중복되는 내용  : StudentDao 구현체에 대한 생성 로직
	// --> @Before 어노테이션이 붙은 setup 메소드에 위임
	//모든 테스트 메소드에서 StudentDao 객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고
	//클래스 변수를 setup메소드에서 초기화하는 로직이 필요
	//테스트 메소드에서 StudentDao를 생성하는 로직은 삭제

	private StudentDaoInf studentDao;

	@Before
	public void setUp(){
		studentDao = new StudentDao();
	}

	/**
	 * Method : selectAllStudentstest
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC15
	 * 변경이력 :
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Test
	public void selectAllStudentstest() {
		/***Given***/


		/***When***/
		List<StudentVo> studentList =  studentDao.selectAllStudents();

		for(StudentVo vo : studentList){
			System.out.println(vo);
		}

		/***Then***/
		assertEquals(25, studentList.size());

	}

	/**
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC15
	 * 변경이력 :
	 * Method 설명 : 특정 학생 정보를 아이디로 조회
	 */
	@Test
	public void getStudent(){

		/***Given***/

		/***When***/
		int id = 1;
		StudentVo studentList =  studentDao.getStudent(id);
		System.out.println(studentList.getName());

		/***Then***/
		assertEquals(1, studentList.getId());

	}

	/**
	* Method : getStudentByVo
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* Method 설명 : 특정 학생 정보를 아이디나 네임으로 조회
	*/
	@Test
	public void getStudentByVo(){

		/***Given***/
		StudentVo paramVo = new StudentVo();
		int id = 1;
		paramVo.setId(id);

		/***When***/
		StudentVo studentList =  studentDao.getStudent(id);

		System.out.println(studentList.getName());

		/***Then***/
		assertEquals(1, studentList.getId());
	}
	
	/**
	* Method : getStudentPageListTest
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* Method 설명 : 페이지 조회
	*/
	@Test
	public void getStudentPageListTest(){
		
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page",2);
		map.put("pageSize",10);
		
		/***When***/
		List<StudentVo> pageList = studentDao.getStudentPageList(map);
		
		/***Then***/
		assertEquals(10, pageList.size());
	}
	
	/**
	* Method : getStudentTotCntTest
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* Method 설명 : 전체 건수 조회
	*/
	@Test
	public void getStudentTotCntTest(){
		
		/***Given***/
		int totalCnt = 0;

		/***When***/
		totalCnt = studentDao.getStudentTotCnt();

		/***Then***/
		assertEquals(25, totalCnt);

	}
	
	@Test
	public void updateStudentTest(){
		/***Given***/
		
		StudentVo studentVo = new StudentVo();
		studentVo.setId(2);
		studentVo.setName("강병관");
		studentVo.setAddr1("대전광역시 중구 중앙로 76");
		studentVo.setAddr2("영민빌딩 2층 대덕인재개발원");
		studentVo.setZipcd("34940");
		studentVo.setPic("sally.png");
		studentVo.setPicpath("D:\\A_TeachingMaterial\\7.JspSrpgin\\fileUpload");
		studentVo.setPicname("sally.png");

		/***When***/
		int count = studentDao.studentUpdate(studentVo);
		
		/***Then***/
		assertEquals(1, count);
		

	}
	
}
