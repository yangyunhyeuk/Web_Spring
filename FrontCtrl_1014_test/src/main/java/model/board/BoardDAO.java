package model.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.common.DBCP;
import model.member.MemberVO;

public class BoardDAO {
	private String BoardList_sql = "select * from board";
	private String Board_sql = "select * from board where id=?";
	private String insertBoard = "insert into board (id,title,writer,content) values((SELECT NVL(MAX(id),0)+1 FROM board),?,?,?)";
	private String BoardCnt = "select count(*) from board";

	public ArrayList<BoardVO> getBoardListPage(int startRow, int endRow) {

		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			String sql = "select * from (select rownum as id, title, writer, content, wdate from board "
					+ "order by id) where id between " + startRow + " and " + endRow;

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO bVO = new BoardVO();

				bVO.setId(rs.getString("id"));
				bVO.setTitle(rs.getString("title"));
				bVO.setWriter(rs.getString("writer"));
				bVO.setContent(rs.getString("content"));
				bVO.setWdate(rs.getDate("wdate"));
				list.add(bVO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("getBoardListPage 발생");
				e.printStackTrace();
			}

		}
		return list;
	}

	public int getTotalCount() {
		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		int total = 0;
		try {
			pstmt = conn.prepareStatement(BoardCnt);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("getTotalCount 발생");
				e.printStackTrace();
			}
		}
		return total;
	}

	public ArrayList<BoardVO> getBoardList() {
		System.out.println("getBoardList 입장");
		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();

		try {
			pstmt = conn.prepareStatement(BoardList_sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("getBoardList try 안 입장");
			while (rs.next()) {
				BoardVO data = new BoardVO();
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
				System.out.println("getBoardList 담기는 중");
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;

	}

	public BoardVO getBoard(BoardVO bVO) {
		System.out.println("getBoard 입장");
		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		BoardVO data = null;

		try {
			pstmt = conn.prepareStatement(Board_sql);
			pstmt.setString(1, bVO.getId());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			System.out.println("getBoardList try 안 입장");

			if (rs.next()) {
				data = new BoardVO();
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCP.disconnect(pstmt, conn);
		}
		return data;

	}

	public boolean insertBoard(BoardVO vo) {
		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null; // sql 구문을 실행하는 역할
		boolean res = false;

		try {
			pstmt = conn.prepareStatement(insertBoard);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			res = true;
		} catch (SQLException e) {
			System.out.println("insertMember 에러발생 ");
			e.printStackTrace();
		} finally {
			DBCP.disconnect(pstmt, conn);
		}
		return res;
	}

}
