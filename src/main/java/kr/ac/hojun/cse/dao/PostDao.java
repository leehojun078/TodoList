package kr.ac.hojun.cse.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hojun.cse.model.Post;

@Repository
public class PostDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Post> getPosts() {
		String sqlStatement = "select * from post";
		
		//마감기한이 지난 post가 있는지 확인
		checkPost();
		
		return jdbcTemplate.query(sqlStatement, new RowMapper<Post>(){

			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setPriority(rs.getString("priority"));
				post.setDeadline(rs.getDate("deadline"));
				post.setState(rs.getString("state"));
				post.setDescription(rs.getString("description"));
			
				return post;
			}
		});
	}
	
	// deadline이 어제부터  1년 전까지였던 post의 state를 수정
	public void checkPost() {
		
		String sqlStateUpdateStateByDeadline = "update post set state='미완료'"
				+ "WHERE date(deadline) >= date(subdate(now(), INTERVAL 365 DAY)) "
				+ "and date(deadline) < date(now()) "
				+ "and state='진행중'";
		
		jdbcTemplate.update(sqlStateUpdateStateByDeadline);
	}
	
	public boolean addPost(Post post) {
		
		String title = post.getTitle();
		String priority = post.getPriority(); 
		Date deadline = post.getDeadline();
		String state = post.getState();
		String description = post.getDescription();
		
		String sqlStatement = "insert into post (title, priority, deadline, state, description) values(?,?,?,?,?)";
		
		return (jdbcTemplate.update(sqlStatement, 
				new Object[] {title, priority, deadline, state, description}) == 1);
	}

	public boolean deletePost(int id) {
		
		String sqlStatement = "delete from post where id = ?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
	}

	public Post getPostById(int id) {

		String sqlStatement = "select * from post where id = ?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {id}, new RowMapper<Post>() {
			
			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {

				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setPriority(rs.getString("priority"));
				post.setDeadline(rs.getDate("deadline"));
				post.setState(rs.getString("state"));
				post.setDescription(rs.getString("description"));

				return post;
			}
		});
	}

	public boolean updatePost(Post post) {
		
		int id = post.getId();
		String title = post.getTitle();
		String priority = post.getPriority(); 
		Date deadline = post.getDeadline();
		String state = post.getState();
		String description = post.getDescription();
		
		String sqlStatement = "update post set title=?, priority=?, deadline=?, state=?, description=? "
							+ "where id=?";
		
		return (jdbcTemplate.update(sqlStatement, 
				new Object[] {title, priority, deadline, state, description, id}) == 1);
	}

	//post의 state를 '완료'로 설정
	public boolean completePost(int id) {

		String sqlStatement = "update post set state = '완료' where id = ?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);
	}
}
