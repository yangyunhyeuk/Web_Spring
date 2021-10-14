<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.member.*, java.util.List"%>
<%
	// 아이디 값
	// 비밀번호 값

	// vo에 해당값들을 set

	// dao로 getMember() 수행
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setPassword(password);

	SpringMemberDAO dao = new SpringMemberDAO();
	List<MemberVO> data = dao.getMember(vo);

	if (data != null) {
		response.sendRedirect("main.jsp");
	} else {
		response.sendRedirect("index.jsp");
	}
%>