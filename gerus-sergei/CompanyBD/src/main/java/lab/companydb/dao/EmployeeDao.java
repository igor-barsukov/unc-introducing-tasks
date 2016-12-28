package lab.companydb.dao;

import lab.companydb.model.Employee;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    List<Employee> getEmployees() throws SQLException;
    void setDataSource(DataSource ds) throws SQLException;
    void create(Employee emp) throws SQLException;
    void deleteEmployeeByName(String name) throws SQLException;
}
