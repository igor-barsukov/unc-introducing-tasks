package impls;

/**
 * Created by acer-pc on 19.12.2016.
*/

import java.util.List;
import javax.sql.DataSource;
import mappers.EmployeeMapper;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import daos.EmployeeDAO;
import models.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class EmpDaoImpl implements EmployeeDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplateObject = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Employee getEmployee(Integer empID) {
        String SQL = "select * from \"Employee\" where \"EmpID\" = :EmpID";
        Map<String, Integer> namedParameters = Collections.singletonMap("EmpID", empID);
        Employee employee =namedParameterJdbcTemplate.queryForObject(SQL, namedParameters,  new EmployeeMapper());

        return employee;
    }

    public List<Employee> getAllEmployees() {
        String SQL = "select * from \"Employee\"";
        List <Employee> employees = jdbcTemplateObject.query(SQL,
                new EmployeeMapper());
        return employees;
    }

    public void createEmployee(Employee employee) {
        Map<String, String> namedParameters = new HashMap();

        namedParameters.put("EmpName", employee.getName());
        namedParameters.put("Department", employee.getDepartment());

        String SQL = "insert into \"Employee\" (\"Name\", \"Department\") values (:EmpName, :Department)";
        namedParameterJdbcTemplate.update(SQL,namedParameters);
    }

    public void updateEmployee(Integer empID, Employee newEmployee) {

        String SQL = "update \"Employee\" set \"Name\" = ?, \"Department\" = ? where \"EmpID\"= ?";
        jdbcTemplateObject.update(SQL, newEmployee.getName(), newEmployee.getDepartment(), empID);


    }




    public void deleteEmployee(Integer empID) {
        String CascadeSQL = "delete from \"EmpToProject\" where \"EmpID\" = :EmpID ";
        String UpdateSQL = "update \"Project\" set \"Manager\" = null  where \"Manager\" = :EmpID";
        String SQL = "delete from \"Employee\" where \"EmpID\" = :EmpID";
        Map<String, Integer> namedParameters = Collections.singletonMap("EmpID", empID);

        namedParameterJdbcTemplate.update(CascadeSQL, namedParameters) ;
        namedParameterJdbcTemplate.update(UpdateSQL, namedParameters) ;
        namedParameterJdbcTemplate.update(SQL, namedParameters);

    }

    public void deleteEmployeeByName(String name) {

        String CascadeSQL = "delete " +
                " from \"EmpToProject\"" +
                " where \n" +
                "  \"EmpToProject\".\"EmpID\" in (" +
                "    Select \"Employee\".\"EmpID\"" +
                "    from \"Employee\"" +
                "    where \"Employee\".\"Name\"= :EmpName)";

        String UpdateSQL = "update \"Project\" set \"Manager\" = null  where " +
                "\"Manager\" in (   Select \"Employee\".\"EmpID\" " +
                "    from \"Employee\"" +
                "    where \"Employee\".\"Name\"= :EmpName)";


        String SQL = "delete from \"Employee\" where \"Name\" = :EmpName";

        Map<String, String> namedParameters = Collections.singletonMap("EmpName", name);

        //cascade delete
        namedParameterJdbcTemplate.update(CascadeSQL, namedParameters);
        namedParameterJdbcTemplate.update(UpdateSQL, namedParameters);
        namedParameterJdbcTemplate.update(SQL, namedParameters);
    }
}
