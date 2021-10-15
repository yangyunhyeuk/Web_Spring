package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.DBCP;

public class MemberDAO {

	String MemInsertSQL = "INSERT INTO MEMBER VALUES(?,?,?,?)";
	String MemUpdateSQL = "UPDATE MEMBER SET ID = ? , PASSWORD = ?, NAME=?, ROLE=?";
	String MemDeleteSQL = "DELETE FROM MEMBER WHERE ID=?";
	String getMemSQL = "SELECT * FROM MEMBER WHERE ID=? and PASSWORD=?";
	String getMemListSQL = "SELECT * FROM MEMBER";

	public MemberVO getMember(MemberVO vo) {
		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		MemberVO data = null;
		try {
			pstmt = conn.prepareStatement(getMemSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				data = new MemberVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("getDBData()���� ���");
			e.printStackTrace();
		} finally {
			DBCP.disconnect(pstmt, conn);
		}
		return data;
	}

	public boolean insertMember(MemberVO vo) {
		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null; // sql 구문을 실행하는 역할
		boolean res = false;

		try {
			pstmt = conn.prepareStatement(MemInsertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
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
