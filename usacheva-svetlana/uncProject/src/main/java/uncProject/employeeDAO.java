package uncProject; /**
 * Created by Света on 28.12.2016.
 */
import javax.sql.DataSource;

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
    public void createEmployee(String name, String department, int empl_id);
    /*
     * This is the method to be used to list down
     * a record from the Employee table
     */
    public void getEmployees();
    /*
     * This is the method to be used to list down
     * all the records from the Project table
     * corresponding to emplId
     * (returns projects for specified employee).
     */
    public void getProjectsByEmployee(int empId);
    /*
     * This is the method to be used to list down
     * a record from the Project table
     * corresponding to Project name
     * (returns company for specified  project).
     */
    public void getCompanyByProjectName (String name);
    /*
     * This is the method to be used to delete
     * a record into the Employee table
     * corresponding to Employee name.
     */
    public void deleteEmployeeByName(String name);

}
