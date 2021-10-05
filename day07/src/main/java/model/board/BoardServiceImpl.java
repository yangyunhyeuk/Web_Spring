package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.app.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
// ������ OOP ���ü�迡�� AOP�� ���� �Ѱ�
	
	
	@Autowired
	private BoardDAO boardDAO;
	private LogAdvice logAdvice;
	// �Ը��� �´� ��ġ�� ����ϴ� ���̴�. 

	
	// ������ ������ �����ϵ��� this�� new�� �����Ͽ� ����Ͽ���. 
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
