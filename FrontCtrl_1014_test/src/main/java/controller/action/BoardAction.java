package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.page.Paging;

public class BoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		BoardDAO bDAO = new BoardDAO();

		int totalCount = bDAO.getTotalCount();

		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

		System.out.println("BoardAction������ page :" + page);

		Paging paging = new Paging();
		paging.setPageNo(page); 
		paging.setTotalCount(totalCount);

		page = ((page - 1) * 10) + 1; 
		paging.setPageSize(page + 9); 
		System.out.println("페이지 사이즈 측정");
		System.out.println(page);
		System.out.println(paging.getPageSize());
		
		ArrayList<BoardVO> list = bDAO.getBoardListPage(page, paging.getPageSize());
		request.setAttribute("list", list); 
		request.setAttribute("paging", paging); 


		ArrayList<BoardVO> datas = bDAO.getBoardList();
		System.out.println(datas);
		request.setAttribute("datas", datas);

		forward.setPath("board.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
