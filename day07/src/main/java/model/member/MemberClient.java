package model.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.board.BoardService;
import model.board.BoardVO;

public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		BmemService bs = (BmemService) factory.getBean("memberService");
		BmemVO vo = new BmemVO();
		vo.setId("ronny");
		vo.setPassword("1111");
		vo.setName("�δ� �ݸ�");
		vo.setRole("����");

		bs.insertMember(vo);


		List<BmemVO> datas = bs.getMemberList(vo);
		System.out.println("bs.getmemberList(vo) ��� : " + datas);

		for (BmemVO data : datas) {
			System.out.println(data);
		}

		factory.close();
	}
}
