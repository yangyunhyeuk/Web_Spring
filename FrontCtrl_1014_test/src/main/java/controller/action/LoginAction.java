package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 처음 입장하면 다음의 객체를 만들어 리턴을 정의한다.
		ActionForward forward = new ActionForward();

		System.out.println("LoginAction 입장");

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();

		BoardDAO bDAO = new BoardDAO();

		mVO.setId(id);
		mVO.setPassword(password);

		MemberVO data = mDAO.getMember(mVO);

		if (data == null) {
			System.out.println("로그인 실패");

			forward.setRedirect(false);
			// 헤더를 교체하겠다.
			// 이전 정보를 정리하겠다.
			forward.setPath("index.jsp");
		}

		else {
			System.out.println("로그인 성공");

			HttpSession session = request.getSession();
			session.setAttribute("mid", mVO.getId());
			System.out.println("1");
			
			ArrayList<BoardVO> datas = bDAO.getBoardList();
			
			System.out.println("2");
			request.setAttribute("datas", datas);
			
			System.out.println("3");
			forward.setRedirect(false);
			forward.setPath("board.jsp");

		}

		return forward;

		// setRedirect(true)
		// 헤더를 교체하겠다.
		// 이전 정보를 정리하겠다.

		/*
		 * request.setAttribute("list", list); // dao�� ���� ������ �Խñ� ����
		 * request.setAttribute("paging", paging); // paging ��ü ����
		 * 
		 * forward.setRedirect(false); forward.setPath("main.jsp"); // ������ ���޹�İ�
		 * ��θ� �����Ϸ��� ������̴�.! System.out.println("���ξ׼� ����");
		 * 
		 * return forward;
		 */

	}

}
