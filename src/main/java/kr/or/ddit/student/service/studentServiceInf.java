package kr.or.ddit.student.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

public interface studentServiceInf {

	/**
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC15
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	List<StudentVo> selectAllStudents();
	
	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC15
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 :
	*/
	StudentVo getStudent(int id);
	
	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC15
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 :
	*/
	StudentVo getStudent(StudentVo studentVo);
	
	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC15
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 학생 페이지 리스트 조회
	*/
	Map<String, Object> getStudentPageList (Map<String, Integer> map);
	
	/**
	* Method : studentUpdate
	* 최초작성일 : 2018. 7. 17.
	* 작성자 : PC15
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 : 학생 정보 업데이트
	*/
	int studentUpdate(StudentVo studentVo);
	
	
	
}
