package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("bmemDAO")
public class BmemDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// TABLE NAME : bmember
	private final String insertSQL="insert into bmember (id,password,name,role) values(?,?,?,?)";
	private final String updateSQL="update bmember set password=?,name=?,role=? where id=?";
	private final String deleteSQL="delete bmember where id=?";
	private final String getBmemSQL="select * from bmember where id=?";
	private final String getBmemListSQL="select * from bmember";


	public void insertBoard(BmemVO vo) {
		System.out.println("dao로 insert");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void updateBoard(BmemVO vo) {
		System.out.println("dao로 update");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getRole());
			pstmt.setString(4, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void deleteBoard(BmemVO vo) {
		System.out.println("dao로 delete");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public List<BmemVO> getBoardList(BmemVO vo) {
		System.out.println("dao로 getList");
		List<BmemVO> datas=new ArrayList<BmemVO>();
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getBmemListSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BmemVO data=new BmemVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("title"));
				data.setName(rs.getString("writer"));
				data.setRole(rs.getString("content"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt,rs);
		}
		return datas;
	}
	public BmemVO getBoard(BmemVO vo) {
		System.out.println("dao로 get");
		BmemVO data=null;
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getBmemSQL);
			pstmt.setString(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BmemVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("title"));
				data.setName(rs.getString("writer"));
				data.setRole(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt, rs);
		}
		return data;
	}
	
	
}
