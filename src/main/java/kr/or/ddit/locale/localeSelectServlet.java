package kr.or.ddit.locale;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class localeSelect
 */
@WebServlet("/localeSelect")
public class localeSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param = request.getParameter("locale");
		System.out.println(param);
		
		if(param == null){
			param = "ko";
		}
		
		System.out.println("param ="+ param);
		request.setAttribute("locale",param);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/jstl/localeSelect.jsp");
		rd.forward(request, response);
		
	}

}
