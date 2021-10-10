package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


// 로우 매퍼에 들어갈 사항이 있기에 인터페이스를 상속받아 규정을 지키며 사용한다. 
class BoardRowMapper implements RowMapper<BoardVO> {

	   @Override
	   public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	      BoardVO data=new BoardVO();
	      data.setId(rs.getInt("id"));
	      data.setTitle(rs.getString("title"));
	      data.setWriter(rs.getString("writer"));
	      data.setContent(rs.getString("content"));
	      data.setWdate(rs.getDate("wdate"));
	      return data;
	   }
	   
	}


// JDBC 구현 방법 2가지
// 1. extends로 상속받아 만드는 방법
// 2. jdbc 템플릿 객체를 bean 등록하여 의존성 주입받아 사용


//이름이 없는 이유는 어차피 autowired가 타입을 보기 때문
@Repository()
public class SpringBoardDAO {

	private final String insertSQL="insert into board (id,title,writer,content) values((select nvl(max(id),0)+1 from board),?,?,?)";
	private final String updateSQL="update board set title=?,content=? where id=?";
	private final String deleteSQL="delete board where id=?";
	private final String getBoardSQL="select * from board where id=?";
	private final String getBoardListSQL="select * from board order by id desc";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//자체적으로 DATASOURCE를 쓰기에 커넥션 클로즈를 안쓴다. 
	
	public void insertBoard(BoardVO vo) {
		System.out.println("jdbcTemplate로 insert");
		jdbcTemplate.update(insertSQL, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("jdbcTemplate로 update");
		jdbcTemplate.update(updateSQL, vo.getTitle(),  vo.getContent(),vo.getId());
	}
	
	 public void deleteBoard(BoardVO vo) {
	      System.out.println("jdbcTemplate으로 delete");
	      jdbcTemplate.update(deleteSQL,vo.getId());
	   }
	   

	 public List<BoardVO> getBoardList(BoardVO vo) {
	      System.out.println("jdbcTemplate으로 getBoardList");
	      return jdbcTemplate.query(getBoardListSQL,new BoardRowMapper());
	   }
	   
	   public BoardVO getBoard(BoardVO vo) {
	      System.out.println("jdbcTemplate으로 getBoard");
	      Object[] args= { vo.getId() };
	      return jdbcTemplate.queryForObject(getBoardSQL,args,new BoardRowMapper());
	   }

		// BoardRowMapper는 외부에 따로 빼놓는다 
		// 최상단 확인
	
}




