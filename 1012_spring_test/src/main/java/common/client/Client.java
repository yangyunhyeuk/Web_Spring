package common.client;

import java.util.List;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.board.BoardService;
import model.board.BoardVO;
import model.member.MemberService;
import model.member.MemberVO;

public class Client {
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		BoardService bs = (BoardService) factory.getBean("boardService");
		BoardVO bvo = new BoardVO();

		// insert // insert // insert // insert // insert // insert

		bvo.setContent("내용 작성중");
		bvo.setTitle("제목입니다");
		bvo.setWriter("관리자");
		bs.insertBoard(bvo);
		List<BoardVO> bdatas = bs.getBoardList(bvo);
		for (BoardVO data : bdatas) {
			System.out.println("List<BoardVO> bdatas : "+data);
		}

		// search // search // search // search // search // search

		//System.out.println("핵심 관심 전 syso");
		Scanner scanner = new Scanner(System.in);
		System.out.println("검색할 제목을 입력하세요");
		String title = null;
		if (scanner.hasNext()) {
			title = scanner.nextLine();
		}
		bvo.setSearch(title);
		List<BoardVO> bSearchdatas = bs.getSearchList(bvo);

		if(bSearchdatas.isEmpty()) {
			System.out.println("검색목록이 없습니다.");
		}else {
			System.out.println("bs.getSearchList(title) 출력 : " + bSearchdatas);
		}

		for (BoardVO data : bSearchdatas) {
			System.out.println(data);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// 회원가입 // 회원가입 // 회원가입 // 회원가입 // 회원가입 // 회원가입
		MemberService ms = (MemberService) factory.getBean("memberService");
		MemberVO mvo = new MemberVO();

		mvo.setId("rexa");
		mvo.setPassword("1234");
		mvo.setName("call");
		mvo.setRole("trainer");
		ms.insertMember(mvo);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// 로그인 // 로그인 // 로그인 // 로그인 // 로그인 // 로그인

		mvo.setId("1");
		mvo.setPassword("4");

		List<MemberVO> mdatas = ms.getMember(mvo);

		if (mdatas.isEmpty()) {
			System.out.println("로그인 실패");
		} else {
			System.out.println("로그인 성공");
		}
		for (MemberVO s : mdatas) {
			System.out.println("List<MemberVO> mdatas = ms.getMember(mvo) : "+s);
		}

		factory.close();

	}
}
