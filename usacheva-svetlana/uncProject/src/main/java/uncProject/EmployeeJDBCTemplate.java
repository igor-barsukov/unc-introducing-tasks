package uncProject;

import javax.sql.DataSource;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Света on 28.12.2016.
 */
public class EmployeeJDBCTemplate implements employeeDAO{

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource ds) {

        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void createEmployee(String name, String department) {

        String SQL = "insert into \"Employee\" (\"EmpID\", \"Name\", \"Department\") " +
                "values (DEFAULT , "+name+" ,"+department+" )";
        jdbcTemplateObject.update(SQL);
        System.out.println("Created Record Name = " + name + " Department = " + department);
    }

    public List<Employee> getEmployees() {

        String SQL = "select * from \"Employee\"";
        List <Employee> employees = jdbcTemplateObject.query(SQL,new EmployeeMapper());
        return employees;
    }

    public List<Project> getProjectsByEmployee(int empl_id) {

        String SQL = "select * from \"Project\" WHERE  \"Project\".\"ManagerID\" = " + empl_id;
        List <Project> projects = jdbcTemplateObject.query(SQL,new ProjectMapper());
        return projects;
    }

    public List<Company> getCompanyByProjectName(String name) {

        String SQL = "select \"Company\".\"Name\" \n" +
                "from \"Company\",\n" +
                "\"Project\"\n" +
                "WHERE \"Project\".\"Company\" = \"Company\".\"Name\" and\n" +
                "\"Project\".\"Name\" = " + name;
        List <Company> companies = jdbcTemplateObject.query(SQL,new CompanyMapper());
        return companies;
    }

    public void deleteEmployeeByName(String name) {

        String SQL = "delete from \"Employee\" where \"Employee\".\"Name\" = " + name;
        jdbcTemplateObject.update(SQL);
        getEmployees();
    }
}
