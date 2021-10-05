package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.board.BoardVO;

@Service("memberService")
public class BmemServiceImpl implements BmemService {

	@Autowired
	private BmemDAO memberDAO;
	private BmemVO memberVO;

	@Override
	public void insertMember(BmemVO vo) {
		// TODO Auto-generated method stub
		memberDAO.insertMember(vo);
	}

	@Override
	public void updateMember(BmemVO vo) {
		// TODO Auto-generated method stub
		memberDAO.updateMember(vo);
	}

	@Override
	public void deleteMember(BmemVO vo) {
		// TODO Auto-generated method stub
		memberDAO.deleteMember(vo);
	}

	@Override
	public List<BmemVO> getMemberList(BmemVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.getMemberList(vo);
	}

	@Override
	public BmemVO getMember(BmemVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.getMember(vo);
	}

}
