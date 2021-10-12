package model.member;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



class MemberRowMapper implements RowMapper<MemberVO> {
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data = new MemberVO();
		data.setId(rs.getString("id"));
		data.setPassword(rs.getString("password"));
		data.setName(rs.getString("name"));
		data.setRole(rs.getString("role"));
		return data;
	}

}

@Repository()
public class SpringMemberDAO {
	private final String insertSQL = "INSERT INTO MEMBER (id, password, name, role) VALUES(?, ?, ?, ?)";
	private final String updateSQL = "UPDATE MEMBER SET PASSWORD=? NAME=? ROLE=?";
	private final String deleteSQL = "DELETE MEMBER WHERE ID = ?";
	private final String getMember = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
	private final String getMemberList = "SELECT * FROM MEMBER";

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertMember(MemberVO vo) {
		System.out.println("insertMember 작업 시작");
		System.out.println(vo);
		jdbcTemplate.update(insertSQL, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}

	public void updateMember(MemberVO vo) {
		System.out.println("updateMember 작업 시작");
		jdbcTemplate.update(updateSQL, vo.getPassword(), vo.getName(), vo.getRole());
	}

	public void deleteMember(MemberVO vo) {
		System.out.println("deleteMember 작업 시작");
		jdbcTemplate.update(deleteSQL, vo.getId());
	}

	public List<MemberVO> getMember(MemberVO vo) {
		System.out.println("getMember 작업 시작");
		Object[] args = { vo.getId(), vo.getPassword() };
		return jdbcTemplate.query(getMember, args, new MemberRowMapper());

	}

	public List<MemberVO> getMemberList(MemberVO vo) {
		System.out.println("getMemberList 작업 시작");
		return jdbcTemplate.query(getMemberList, new MemberRowMapper());

	}

}
