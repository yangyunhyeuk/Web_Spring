package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.app.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
// 기존의 OOP 언어체계에서 AOP가 갖는 한계
	
	
	@Autowired
	private BoardDAO boardDAO;
	private LogAdvice logAdvice;
	// 입맛에 맞는 워치를 사용하는 것이다. 

	
	// 생성자 주입이 가능하도록 this와 new를 결합하여 사용하였다. 
	public BoardServiceImpl() {
		this.logAdvice = new LogAdvice();
	}
		
	
	@Override
	public void insertBoard(BoardVO vo) {
		logAdvice.printLog();
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		logAdvice.printLog();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		logAdvice.printLog();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		logAdvice.printLog();
		return boardDAO.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		logAdvice.printLog();
		return boardDAO.getBoard(vo);
	}

}
