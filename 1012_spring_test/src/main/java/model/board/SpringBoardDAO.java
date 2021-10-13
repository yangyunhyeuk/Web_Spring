package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//로우 매퍼에 들어갈 사항이 있기에 인터페이스를 상속받아 규정을 지키며 사용한다. 
class BoardRowMapper implements RowMapper<BoardVO> {
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		BoardVO data = new BoardVO();
		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setContent(rs.getString("content"));
		data.setWdate(rs.getDate("wdate"));
		return data;
	}

}

// 실제 DB와 연관된 파일이다.  
// ServiceImpl에서 사용할 예정이다. 
@Repository()
public class SpringBoardDAO {

	// update, delete, getb, getbList

	private final String insertSQL = "INSERT INTO BOARD (id, title, writer, content) VALUES((SELECT NVL(MAX(ID),0)+1 from BOARD), ?, ?, ?)";
	private final String updateSQL = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE ID=?";
	private final String deleteSQL = "DELETE BOARD WHERE ID=?";
	private final String getBoardSQL = "SELECT * FROM BOARD WHERE ID=?";
	private final String getBoardListSQL = "SELECT * FROM BOARD ORDER BY ID DESC";
	private final String getSearchListSQL = "SELECT * FROM BOARD WHERE title LIKE '%' || ? || '%'";


	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard 실행");
		jdbcTemplate.update(insertSQL, vo.getTitle(), vo.getWriter(), vo.getContent());
	};

	public void updateBoard(BoardVO vo) {
		System.out.println("updateBoard 실행");
		jdbcTemplate.update(updateSQL, vo.getTitle(), vo.getContent(), vo.getId());
	};

	public void deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard 실행");
		jdbcTemplate.update(deleteSQL, vo.getId());
	};

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard 실행");
		Object[] args = { vo.getId() };
		return jdbcTemplate.queryForObject(getBoardSQL, args, new BoardRowMapper());
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("getBoardList 실행");
		return jdbcTemplate.query(getBoardListSQL, new BoardRowMapper());
	}
	public List<BoardVO> getSearchList(BoardVO vo){ 
		System.out.println("getSearchList 실행");
		Object[] args = { vo.getSearch() };
		return jdbcTemplate.query(getSearchListSQL, args, new BoardRowMapper());
	}

}
