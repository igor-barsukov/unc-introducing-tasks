package daos;

import models.Employee;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by acer-pc on 17.12.2016.
 */
public interface EmployeeDAO {
    public void setDataSource(DataSource ds);
    Employee getEmployee(Integer empID);
    List<Employee> getAllEmployees();
    void createEmployee(Employee employee);
    void updateEmployee(Integer empID, Employee newEmployee);
    void deleteEmployee(Integer empID);
    void deleteEmployeeByName(String name);
}
