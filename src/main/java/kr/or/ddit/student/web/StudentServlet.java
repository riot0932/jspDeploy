package kr.or.ddit.student.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.studentService;
import kr.or.ddit.student.service.studentServiceInf;

/**
 * Servlet implementation class Student
 */
@WebServlet("/studentList")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//StudentService 객체를 생성, 학생 전체 리스트를 조회
		//학생 전체 리스트request객체에 속성으로 설정
		//studentList.jsp로 forward

		//page, pageSize 파라미터, 파라미터 값이 없을 경우 
		//기본 값으로 page:1, pageSize:10
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");

		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 10 :  Integer.parseInt(pageSizeStr);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page",page);
		map.put("pageSize",pageSize);

		//학생 페이지 리스트, 전체 건수 조회

		studentServiceInf studentService = new studentService();
		//		List<StudentVo> studentList = studentService.getStudentPageList(map);
		Map<String, Object> resultMap =  studentService.getStudentPageList(map);

		//학생 페이지 리스트
		List<StudentVo> studentList = (List<StudentVo>) resultMap.get("pageList");
		request.setAttribute("list", studentList);

		//페이지 네비게이션 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		request.getRequestDispatcher("/student/studentList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
