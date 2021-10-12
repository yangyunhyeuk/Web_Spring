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


// ������ �������־� ��ü ������ ���־�� �Ѵ�. 
@Repository
public class SpringBmemDAO{

	// TABLE NAME : bmember
	private final String insertSQL="insert into bmember (id,password,name,role) values(?,?,?,?)";
	private final String updateSQL="update bmember set password=?,name=?,role=? where id=?";
	private final String deleteSQL="delete bmember where id=?";
	private final String getBmemSQL="select * from bmember where id=?";
	private final String getBmemListSQL="select * from bmember";

	// ������ �ڵ带 ���� ���� ���Ͽ��� ������ ������ �ҽ��� �̿��� �� �ְ� �ȴ�. 
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertMember(BmemVO vo) {
		System.out.println("jdbcTemplate���� insertMember");
		jdbcTemplate.update(insertSQL, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}
	public void updateMember(BmemVO vo) {
		System.out.println("jdbcTemplate���� updateMember");
		jdbcTemplate.update(updateSQL, vo.getPassword(), vo.getName(), vo.getRole(), vo.getId());
	}
	public void deleteMember(BmemVO vo) {
		System.out.println("jdbcTemplate���� deleteMember");
		jdbcTemplate.update(deleteSQL, vo.getId());
	}
	public List<BmemVO> getMemberList(BmemVO vo) {
		System.out.println("jdbcTemplate���� getMemberList");
		return jdbcTemplate.query(getBmemListSQL, new BmemRowMapper());
	}
	public BmemVO getMember(BmemVO vo) {
		System.out.println("jdbcTemplate���� getMember");
		Object[] args = {vo.getId()};
		return jdbcTemplate.queryForObject(getBmemSQL, args, new BmemRowMapper());
	}
	// new BmemRowMapper() : �ش� �ڵ尡 ����� BmemRowMapper�� ���εȴ�. 
}
