package uncProject;

import javax.sql.DataSource;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.

/**
 * Created by Света on 28.12.2016.
 */
public class EmployeeJDBCTemplate implements employeeDAO{
    public void setDataSource(DataSource ds) {

    }

    public Employee createEmployee(int empl_id, String name, String department) {
        return null;
    }

    public List<Employee> getEmployees() {
        return null;
    }

    public List<Project> getProjectsByEmployee(int empId) {
        return null;
    }

    public List<Company> getCompanyByProjectName(String name) {
        return null;
    }

    public void deleteEmployeeByName(String name) {

    }
}
