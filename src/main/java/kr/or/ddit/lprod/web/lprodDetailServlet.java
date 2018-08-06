package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.lprodVo;
import kr.or.ddit.lprod.service.lprodServiceInf;

/**
 * Servlet implementation class lprodDetail
 */
@WebServlet("/lprodDetail")
public class lprodDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		lprodServiceInf lprodService = new kr.or.ddit.lprod.service.lprodService();
		List<lprodVo> lprodList = lprodService.selectAllLprod();

		request.setAttribute("lprodList", lprodList);

		request.getRequestDispatcher("/lprod/lprodDetail.jsp").forward(request, response);
	}


}
