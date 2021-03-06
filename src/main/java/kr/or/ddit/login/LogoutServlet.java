package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.logout 요청시 session 무료화 작업
		//2.login.jsp redirect
		
		//session 획득
		HttpSession session = request.getSession();
		session.invalidate();
//		session.removeAttribute("userVo");
		//redirect 획득
		response.sendRedirect("/login/login.jsp");
		
		//1.loginSession.jsp 확인
		
		//2.데이터가 없을 경우 : login.jsp 에서 로그인
		//	2-1 loginSession.jsp확인
		//	2-2 main.jsp 에서 로그아웃
		//	2-3 loginSession.jsp 확인
		
		//3.데이터가 있을 경우 : login.jsp
		//	3-1 main.jsp에서 로그아웃
		//	3-2 loginSession.jsp 확인
		
	}

}
