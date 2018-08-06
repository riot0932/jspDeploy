package kr.or.ddit.student.Service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.studentServiceInf;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {

	//테스트 메소드 안에 중복되는 내용  : StudentDao 구현체에 대한 생성 로직
	// --> @Before 어노테이션이 붙은 setup 메소드에 위임
	//모든 테스트 메소드에서 StudentService 객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고
	//클래스 변수를 setup메소드에서 초기화하는 로직이 필요
	//테스트 메소드에서 StudentService를 생성하는 로직은 삭제

	private studentServiceInf studentService;

	@Before
	public void setUp(){
		studentService = new kr.or.ddit.student.service.studentService();
	}

	/**
	 * Method : selectAllStudentTest
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC15
	 * 변경이력 :
	 * Method 설명 : 전체 학생 정보 조회 테스트
	 */
	@Test
	public void selectAllStudentTest() {
		/***Given***/

		/***When***/
		List<StudentVo>  studentList = studentService.selectAllStudents();
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
	 * Method 설명 : 특정 학생 상세 조회
	 */
	@Test
	public void getStudent() {

		/***Given***/

		/***When***/
		int id = 1;
		StudentVo studentList = studentService.getStudent(id);


		/***Then***/
		assertEquals(1, studentList.getId());
	}

	/**
	 * Method : getStudentByVo
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC15
	 * 변경이력 :
	 * Method 설명 : 특정 학생 상세 조회
	 */
	@Test
	public void getStudentByVo() {

		/***Given***/

		/***When***/
		int id = 1;
		StudentVo studentVo = new StudentVo();
		studentVo.setId(1);
		StudentVo studentList = studentService.getStudent(id);
		StudentVo studentList2 = studentService.getStudent(studentVo);


		/***Then***/
		assertEquals(1, studentList.getId());
		assertEquals(1, studentList2.getId());
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
		Map<String, Object> resultMap = studentService.getStudentPageList(map);
		
		//학생 페이지 리스트
		List<StudentVo> pageList = (List<StudentVo>) resultMap.get("pageList");
		
		//학생 전체 건수
		int totCnt = (int) resultMap.get("totCnt");
		
		/***Then***/
		assertEquals(10, pageList.size());	//학생 페이지 리스트 건수에 대한 검증
		assertEquals(25, totCnt);			//학생 전체 건수에 대한 검증
	}
	
	@Test
	public void calculatePageNavi(){
		/***Given***/
		int totCnt = 25;
		int pageSize = 10;

		int cnt = totCnt / pageSize;	//몫
		int mod = totCnt % pageSize;	//나머지
		
		if(mod > 0){
			cnt++;
		}
		/***When***/
		//Math.ceil
		Math.ceil(totCnt / pageSize);

		/***Then***/

	}
	
	
}
