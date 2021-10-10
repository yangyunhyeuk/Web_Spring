package model.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		BoardService bs = (BoardService) factory.getBean("boardService");
		BoardVO vo = new BoardVO();
		vo.setContent("내용 작성중");
		vo.setTitle("제목입니다");
		vo.setWriter("관리자");

		bs.insertBoard(vo);

		//System.out.println("bs.insertBoard(vo) 출력 : "+vo);

		System.out.println("핵심 관심 전 syso");
		
		
		List<BoardVO> datas = bs.getBoardList(vo);
		
		
		System.out.println("핵심 관심 후 syso");
		System.out.println("bs.getBoardList(vo) 출력 : "+datas);
		
		for (BoardVO data : datas) {
			System.out.println(data);
		}
		
		
	
		factory.close();
	}

}
