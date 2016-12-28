package uncProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by Света on 28.12.2016.
 */
public class EmployeeMapper implements RowMapper{

    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("empl_id"));
        employee.setName(rs.getString("name"));
        employee.setDepartment(rs.getString("department"));
        return employee;
    }

}
