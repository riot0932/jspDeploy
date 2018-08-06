package kr.or.ddit.student.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.file.FileUtil;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.studentServiceInf;

/**
 * Servlet implementation class StudetnIpdateServlet
 */
@WebServlet("/studentUpdate")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//학생 정보 수정 화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//학생 ID 파라미터
		int id = Integer.parseInt(request.getParameter("id"));

		//힉생 정보 조회
		
		studentServiceInf studentService = new kr.or.ddit.student.service.studentService();
		StudentVo studentVo = studentService.getStudent(id);

		//request객체에 학생 정보를 설정
		request.setAttribute("studentVo", studentVo);

		// /student/studentUpdate.jsp로 위임
		request.getRequestDispatcher("/student/studentUpdate.jsp").forward(request, response);

	}

	//학생 정보 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		//파라미터 확인
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");

		Part picPart = request.getPart("pic");

		//학생 정보 조회(service)
		studentServiceInf studentService = new kr.or.ddit.student.service.studentService();
		StudentVo studentVo = studentService.getStudent(id);

		//파라미터로 받은 값을 vo에 설정
		studentVo.setName(name);
		studentVo.setAddr1(addr1);
		studentVo.setAddr2(addr2);
		studentVo.setZipcd(zipcd);

		//신규 이미지로 업데이트 하는 경우
		if(picPart.getSize() > 0){
			//업로드 당시 파일명
			//UUID를 통해 임의의 파일명을 하나 작성(picname)
			//업로드 할 경로 (FileUtil.uploadPath)

			String contentDisposition = picPart.getHeader("Content-Disposition");
			String pic = FileUtil.getFileName(contentDisposition);
			String picPath = FileUtil.fileUploadPath;
			String picname = UUID.randomUUID().toString();

			studentVo.setPic(pic);
			studentVo.setPicpath(picPath);
			studentVo.setPicname(picname);

			picPart.write(picPath + File.separator + picname);
			picPart.delete();

		}

		//학생 정보 업데이트
		studentService.studentUpdate(studentVo);
		
		//학생 정보 상세 조회 화면
		response.sendRedirect("/studentDetail?id="+id);
		//redirect : student/studentDetail.jsp
		
	}

}
