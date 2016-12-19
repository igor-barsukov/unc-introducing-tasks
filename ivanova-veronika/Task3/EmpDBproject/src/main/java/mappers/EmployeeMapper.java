package mappers;

/**
 * Created by acer-pc on 19.12.2016.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import models.Employee;
public class EmployeeMapper  implements RowMapper<Employee> {
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee(rs.getString("Name"), rs.getString("Department"), rs.getInt("EmpID") );
            return employee;
        }
}
