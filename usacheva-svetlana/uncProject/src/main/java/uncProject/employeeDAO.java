package uncProject; /**
 * Created by Света on 28.12.2016.
 */
import javax.sql.DataSource;
import java.util.List;

public interface employeeDAO {

    /*
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);
    /*
     * This is the method to be used to create
     * a record in the Employee table.
     */
    public Employee createEmployee( int emplId, String name, String department);
    /*
     * This is the method to be used to list down
     * a record from the Employee table
     */
    public List<Employee> getEmployees();
    /*
     * This is the method to be used to list down
     * all the records from the Project table
     * corresponding to emplId
     * (returns projects for specified employee).
     */
    public List<Project> getProjectsByEmployee(int empId);
    /*
     * This is the method to be used to list down
     * a record from the Project table
     * corresponding to Project name
     * (returns company for specified  project).
     */
    public List<Company> getCompanyByProjectName (String name);
    /*
     * This is the method to be used to delete
     * a record into the Employee table
     * corresponding to Employee name.
     */
    public void deleteEmployeeByName(String name);

}
