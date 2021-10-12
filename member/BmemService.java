  package model.member;

import java.util.List;

import model.board.BoardVO;

public interface BmemService {
	void insertMember(BmemVO vo);
	void updateMember(BmemVO vo);
	void deleteMember(BmemVO vo);
	List<BmemVO> getMemberList(BmemVO vo);
	BmemVO getMember(BmemVO vo);
}
