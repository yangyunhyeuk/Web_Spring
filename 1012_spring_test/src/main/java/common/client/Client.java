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

		bvo.setContent("���� �ۼ���");
		bvo.setTitle("�����Դϴ�");
		bvo.setWriter("������");
		bs.insertBoard(bvo);
		List<BoardVO> bdatas = bs.getBoardList(bvo);
		for (BoardVO data : bdatas) {
			System.out.println("List<BoardVO> bdatas : "+data);
		}

		// search // search // search // search // search // search

		//System.out.println("�ٽ� ���� �� syso");
		Scanner scanner = new Scanner(System.in);
		System.out.println("�˻��� ������ �Է��ϼ���");
		String title = null;
		if (scanner.hasNext()) {
			title = scanner.nextLine();
		}
		bvo.setSearch(title);
		List<BoardVO> bSearchdatas = bs.getSearchList(bvo);

		if(bSearchdatas.isEmpty()) {
			System.out.println("�˻������ �����ϴ�.");
		}else {
			System.out.println("bs.getSearchList(title) ��� : " + bSearchdatas);
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
		// ȸ������ // ȸ������ // ȸ������ // ȸ������ // ȸ������ // ȸ������
		MemberService ms = (MemberService) factory.getBean("memberService");
		MemberVO mvo = new MemberVO();

		mvo.setId("rexa");
		mvo.setPassword("1234");
		mvo.setName("call");
		mvo.setRole("trainer");
		ms.insertMember(mvo);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// �α��� // �α��� // �α��� // �α��� // �α��� // �α���

		mvo.setId("1");
		mvo.setPassword("4");

		List<MemberVO> mdatas = ms.getMember(mvo);

		if (mdatas.isEmpty()) {
			System.out.println("�α��� ����");
		} else {
			System.out.println("�α��� ����");
		}
		for (MemberVO s : mdatas) {
			System.out.println("List<MemberVO> mdatas = ms.getMember(mvo) : "+s);
		}

		factory.close();

	}
}
