package dao;

import controller.StudentMapper;
import model.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by qwerty on 17.02.2017.
 */
public class StudentJDBCTemplate implements StudentDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Student> listStudents() {
        String SQL = "select * from Student";
        List <Student> students = jdbcTemplate.query(SQL, new StudentMapper());
        return students;
 /*       List<Student> listStudent = jdbcTemplate.query(SQL, new RowMapper<Student>() {


            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student aStudent = new Student();

                aStudent.setId(rs.getInt("id"));
                aStudent.setName(rs.getString("name"));
                aStudent.setAge(rs.getInt("age"));

                return aStudent;
            }

        });*/

       // return listStudent;
    }

    public void delete(Integer id){
        String sql = "DELETE FROM student WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public void saveOrUpdate(Student student) {
       if (student.getId() != null) {
            // update
            String sql = "UPDATE student SET name=?, age=? WHERE id=?";
            jdbcTemplate.update(sql, student.getName(), student.getAge());
        } else {
            // insert
            String sql = "INSERT INTO student (id, name, age)"
                    + " VALUES (DEFAULT, ?, ?)";
            jdbcTemplate.update(sql, student.getName(), student.getAge());
        }

    }

    public Student get(Integer id) {
        String SQL = "select * from student where id=?";
        Student student = (Student) jdbcTemplate.query(SQL, new StudentMapper());
        return student;
    }
}