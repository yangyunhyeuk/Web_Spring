package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.app.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
// 기존의 OOP 언어체계에서 AOP가 갖는 한계
	
	
	@Autowired
	private SpringBoardDAO boardDAO;
	// 
	@Override
	public void insertBoard(BoardVO vo) {
	/*	if(vo.getId() == 0) {
			throw new IllegalArgumentException("pk 값 : 0  불가");
			// 실행 시에 발생하는 예외
			// 런타임 에러
		}*/
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getSearchList(String title) {
		return boardDAO.getSearchList(title);
	}

	

}
