package companydb.rowmapper;


import companydb.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("EmpID");
        String name = rs.getString("Name");
        String department = rs.getString("Department");
        Employee employee = new Employee(id, name, department);
        return employee;
    }
}
