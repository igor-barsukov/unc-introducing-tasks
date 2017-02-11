package companydb.Impl;

import companydb.dao.EmployeeDao;
import companydb.model.Employee;
import companydb.rowmapper.EmployeeMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO \"Employee\"(\"Name\", \"Department\") VALUES (? , ?)";
        jdbcTemplateObject.update(sql, new Object[]{employee.getName(), employee.getDepartment()});
    }

    @Override
    public void updateEmployee(Employee employee) {
    }

    @Override
    public void removeEmployee(int id) {
        String sql = "DELETE FROM \"Employee\" WHERE \"EmpID\" = ?";
        jdbcTemplateObject.update(sql, new Object[]{id});
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM \"Employee\" WHERE \"EmpID\" = ?";
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> listEmployee() {
        String sql = "SELECT * FROM \"Employee\"";
        List<Employee> employeeList = jdbcTemplateObject.query(sql, new EmployeeMapper());

        return employeeList;
    }
}
