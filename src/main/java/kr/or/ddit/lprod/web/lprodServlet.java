package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.lprodVo;
import kr.or.ddit.lprod.service.lprodServiceInf;
import kr.or.ddit.lprod.service.lprodService;

/**
 * Servlet implementation class lprodServlet
 */
//left.jsp에서 가리키는 서블릿
@WebServlet("/lprodList")
public class lprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//left.jsp에서 입력해둔 페이지 값을 가져온다.
		//여기서 page와 pageSize는 left.jsp에서 입력한 값의 이름이다. 그래서 jsp에서 쓴 이름 그대로 가져와야 쓸 수 있다.
		//지금 타입은 주소로써 String 타입이다.
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");

		//lprod 페이지 리스트를 조회하기 위해서 키값을 int형으로 변환 해줘야 한다.
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 1 : Integer.parseInt(pageSizeStr);

		//키는 주소 이기 때문에 String 키 값은 int형이기 때문에 Integer
		Map<String, Integer> map = new HashMap<String, Integer>();
		//앞에는 키의 이름, 뒤에는 키값
		//키의 이름은 xml에서 입력한 이름과 동일 해야함
		map.put("page", page);
		map.put("pageSize", pageSize);

		
		lprodServiceInf lprodService = new lprodService();
		Map<String, Object> resultMap = lprodService.getlprodPageList(map);
		
		List<lprodVo> lprodList = (List<lprodVo>) resultMap.get("pageList");
		request.setAttribute("list", lprodList);
		
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		request.getRequestDispatcher("/lprod/lprodList.jsp").forward(request, response);

	}


}
