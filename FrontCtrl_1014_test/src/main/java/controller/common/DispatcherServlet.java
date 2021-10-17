package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.BoardAction;
import controller.action.JoinAction;
import controller.action.LoginAction;
import controller.action.MainAction;
import controller.action.PostAction;
import controller.action.WriteAction;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;

		// 클라이언트 요청정보 추출
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length());
		System.out.println(action);
		if (action.equals("/login.do")) {
			forward = new LoginAction().execute(request, response);
		} 
		/*
		else if (action.equals("/logout.do")) {

		} */
		else if (action.equals("/main.do")) {
			forward = new MainAction().execute(request, response);
		}
		else if (action.equals("/board.do")) {
			forward = new BoardAction().execute(request, response);
		}
	
		else if (action.equals("/join.do")) {
			forward = new JoinAction().execute(request, response);
		}
		
		else if (action.equals("/write.do")) {
			forward = new WriteAction().execute(request, response);
		}
		
		else if (action.equals("/post.do")) {
			forward = new PostAction().execute(request, response);
		}
		else {
			// 1. 무조건 index.jsp로 이동
			// 2. 에러 페이지로 이동
		}

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (forward != null) {
			// 3) ����ڿ��� ���ȭ�� ���
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 필터로 적용하지 않은 경우 UTF-8, 인코딩 설정이 필요하다.
		doAction(request, response);
	}

}
