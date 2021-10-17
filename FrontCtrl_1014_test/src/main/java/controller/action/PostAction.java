package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;

public class PostAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		bVO.setId(request.getParameter("id"));

		BoardVO data = bDAO.getBoard(bVO);
		request.setAttribute("data", data);

		forward.setPath("post.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
