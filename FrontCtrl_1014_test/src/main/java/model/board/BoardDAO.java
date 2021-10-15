package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.common.DBCP;
import model.member.MemberVO;

public class BoardDAO {
	private String BoardList_sql = "select * from board";

	public ArrayList<BoardVO> getBoardList() {
		System.out.println("getBoardList 입장");
		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();

		try {
			pstmt = conn.prepareStatement(BoardList_sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("getBoardList try 안 입장");

			if (rs.next()) {
				BoardVO data = new BoardVO();
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
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

}
