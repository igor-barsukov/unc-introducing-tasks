package lab.companydb.impl;

import lab.companydb.dao.EmployeeDao;
import lab.companydb.model.Employee;
import lab.companydb.rowmapper.EmployeeMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Сергей on 21.12.2016.
 */
public class SqlEmployeeDao implements EmployeeDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<Employee> getEmployees() throws SQLException {
        String sql = "SELECT * FROM \"Employee\"";
        List<Employee> employees = jdbcTemplateObject.query(sql, new EmployeeMapper());
        return employees;
    }

    public void create(Employee emp) {
        String sql = "INSERT INTO \"Employee\"(\"Name\", \"Department\") VALUES (? , ?)";
        jdbcTemplateObject.update(sql, new Object[]{emp.getName(), emp.getDepartment()});
    }

    public void deleteEmployeeByName(String name) throws SQLException {
        String sql = "DELETE FROM \"Employee\" WHERE \"Name\" = ?";
        jdbcTemplateObject.update(sql, new Object[]{name});
    }
}
