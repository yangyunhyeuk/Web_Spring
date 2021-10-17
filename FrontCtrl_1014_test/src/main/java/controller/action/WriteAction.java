package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;

public class WriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		System.out.println("WriteAction 입장");

		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		bVO.setWriter(request.getParameter("id"));
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));

		if (bDAO.insertBoard(bVO)) {
			System.out.println("게시글 작성 완료");
			forward.setRedirect(true);
			forward.setPath("board.do");
		} else {
			System.out.println("게시글 작성 실패");
			forward.setRedirect(true);
			forward.setPath("board.do");
		}

		return forward;

	}

}
