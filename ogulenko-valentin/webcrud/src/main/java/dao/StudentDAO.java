package dao;

import model.Student;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by qwerty on 17.02.2017.
 */
public interface StudentDAO {

    void setDataSource(DataSource dataSource);

    List<Student> listStudents();

    void delete(Integer id);

    void saveOrUpdate(Student student);

    Student get(Integer id);
}
