package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.board.BoardVO;
import model.member.MemberDAO;
import model.member.MemberVO;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();

		mVO.setId(request.getParameter("id"));
		mVO.setPassword(request.getParameter("password"));
		mVO.setName(request.getParameter("name"));
		mVO.setRole(request.getParameter("role"));

		if (mDAO.insertMember(mVO)) {
			System.out.println("회원가입 성공");

			forward.setRedirect(false);
			forward.setPath("main.jsp");
		} else {
			System.out.println("회원가입 실패");
			forward.setRedirect(false);
			forward.setPath("main.jsp");

		}

		return forward;
	}

}
