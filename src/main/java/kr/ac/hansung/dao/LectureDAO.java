package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Lecture;

@Repository
public class LectureDAO {

	private static JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from class";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// query and return a single object
	// RowMapper --> db에서 읽은 결과recordSet을 실제 자바 객체에 맴핑시켜주는 역할
	public Lecture getLecture(String code, int semeste) {
		String sqlStatement = "select * from lectures where code=?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { code }, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {

				Lecture lecture = new Lecture();

				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setCode(rs.getString("code"));
				lecture.setClassname(rs.getString("classname"));
				lecture.setClassification(rs.getString("classification"));
				lecture.setCredit(rs.getInt("credit"));

				return lecture;
			}
		});
	}

	public List<Lecture> getLecture() {
		String sqlStatement = "select * from lectures";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {

				Lecture lecture = new Lecture();

				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setCode(rs.getString("code"));
				lecture.setClassname(rs.getString("classname"));
				lecture.setClassification(rs.getString("classification"));
				lecture.setCredit(rs.getInt("credit"));

				return lecture;
			}
		});
	}

	public boolean insert(Lecture lecture) {
		int year = lecture.getYear();
		int semester = lecture.getSemester();
		String code = lecture.getCode();
		String classname = lecture.getClassname();
		String classification = lecture.getClassification();
		int credit = lecture.getCredit();

		String sqlStatement = "insert into lectures (year, semester, code,classname,classification,credit) values (?,?,?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement,
				new Object[] { year, semester, code, classname, classification, credit }) == 1);
	}

	public boolean update(Lecture lecture) {
		int year = lecture.getYear();
		int semester = lecture.getSemester();
		String code = lecture.getCode();
		String classname = lecture.getClassname();
		String classification = lecture.getClassification();
		int credit = lecture.getCredit();

		String sqlStatement = "update lectures set year=?, semester=?, classname=? classification=?, credit=? where code=?";

		return (jdbcTemplate.update(sqlStatement,
				new Object[] { year, semester, code, classname, classification, credit }) == 1);
	}

	public boolean delete(String code, int semester, int year) {
		String sqlStatement = "delete from lectures where code=?,semester=?,year=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { code, semester, year }) == 1);
	}

	public List<Lecture> getSemesterList() {
		String sqlStatement = "select distinct year, semester from lectures where year!=2018";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Lecture>() {

			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {

				Lecture lecture = new Lecture();

				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));

				return lecture;
			}
		});
	}

	public List<Lecture> getLectureBySemester(int year, int semester) {
		String sqlStatement = "select * from lectures where year=? and semester=?";

		return jdbcTemplate.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {

				Lecture lecture = new Lecture();

				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setCode(rs.getString("code"));
				lecture.setClassname(rs.getString("classname"));
				lecture.setClassification(rs.getString("classification"));
				lecture.setCredit(rs.getInt("credit"));

				return lecture;
			}
		});
	}

	public int getCreditBySemester(int year, int semester) {
		String sqlStatement = "select sum(credit) from lectures where year=? and semester=?";

		return (jdbcTemplate.queryForObject(sqlStatement, new Object[] { year, semester }, Integer.class));
	}
	

	public int getCreditByClassification(String classification) {
		String sqlStatement = "select sum(credit) from lectures where classification=? and year!=2018";
		return (jdbcTemplate.queryForObject(sqlStatement, new Object[]{classification}, Integer.class));
	}
	
	public List<Lecture> getClassificationList() {
		String sqlStatement = "select distinct classification from lectures";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Lecture>() {

			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Lecture lecture = new Lecture();

				lecture.setClassification(rs.getString("classification"));
				
				return lecture;
			}
		});
	}

	public int getTotalCredit() {
		String sqlStatement = "select sum(credit) from lectures where year!=2018";

		return (jdbcTemplate.queryForObject(sqlStatement, Integer.class));
	}

	public List<Lecture> getAddedLectures() {
		String sqlStatement = "select * from lectures where year=2018 and semester=1";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {

				Lecture lecture = new Lecture();

				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setCode(rs.getString("code"));
				lecture.setClassname(rs.getString("classname"));
				lecture.setClassification(rs.getString("classification"));
				lecture.setCredit(rs.getInt("credit"));

				return lecture;
			}
		});
	}
}
