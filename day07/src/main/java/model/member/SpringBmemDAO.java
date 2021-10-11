  package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


class BmemRowMapper implements RowMapper<BmemVO>{

	@Override
	public BmemVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BmemVO data = new BmemVO();

		data.setId(rs.getString("id"));
		data.setPassword(rs.getString("password"));
		data.setName(rs.getString("name"));
		data.setRole(rs.getString("role"));
		return data;
	}
	
}


// 다음을 선언해주어 객체 설정을 해주어야 한다. 
@Repository
public class SpringBmemDAO{

	// TABLE NAME : bmember
	private final String insertSQL="insert into bmember (id,password,name,role) values(?,?,?,?)";
	private final String updateSQL="update bmember set password=?,name=?,role=? where id=?";
	private final String deleteSQL="delete bmember where id=?";
	private final String getBmemSQL="select * from bmember where id=?";
	private final String getBmemListSQL="select * from bmember";

	// 다음의 코드를 통해 설정 파일에서 선언한 데이터 소스를 이용할 수 있게 된다. 
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertMember(BmemVO vo) {
		System.out.println("jdbcTemplate으로 insertMember");
		jdbcTemplate.update(insertSQL, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}
	public void updateMember(BmemVO vo) {
		System.out.println("jdbcTemplate으로 updateMember");
		jdbcTemplate.update(updateSQL, vo.getPassword(), vo.getName(), vo.getRole(), vo.getId());
	}
	public void deleteMember(BmemVO vo) {
		System.out.println("jdbcTemplate으로 deleteMember");
		jdbcTemplate.update(deleteSQL, vo.getId());
	}
	public List<BmemVO> getMemberList(BmemVO vo) {
		System.out.println("jdbcTemplate으로 getMemberList");
		return jdbcTemplate.query(getBmemListSQL, new BmemRowMapper());
	}
	public BmemVO getMember(BmemVO vo) {
		System.out.println("jdbcTemplate으로 getMember");
		Object[] args = {vo.getId()};
		return jdbcTemplate.queryForObject(getBmemSQL, args, new BmemRowMapper());
	}
	// new BmemRowMapper() : 해당 코드가 상단의 BmemRowMapper에 매핑된다. 
}
