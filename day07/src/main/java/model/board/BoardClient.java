package model.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		BoardService bs = (BoardService) factory.getBean("boardService");
		BoardVO vo = new BoardVO();
		vo.setContent("���� �ۼ���");
		vo.setTitle("�����Դϴ�");
		vo.setWriter("������");

		bs.insertBoard(vo);

		//System.out.println("bs.insertBoard(vo) ��� : "+vo);

		System.out.println("�ٽ� ���� �� syso");
		
		
		List<BoardVO> datas = bs.getBoardList(vo);
		
		
		System.out.println("�ٽ� ���� �� syso");
		System.out.println("bs.getBoardList(vo) ��� : "+datas);
		
		for (BoardVO data : datas) {
			System.out.println(data);
		}
		
		
	
		factory.close();
	}

}
