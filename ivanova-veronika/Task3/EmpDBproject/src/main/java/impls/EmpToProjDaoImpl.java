package impls;

import daos.EmpToProjectDAO;
import mappers.*;
import models.EmpToProject;
import models.Employee;
import models.Project;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by acer-pc on 19.12.2016.
 */
public class EmpToProjDaoImpl implements EmpToProjectDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public EmpToProject getEmpToProject(Integer empID, String name) {

        String SQL = "select * from \"EmpToProject\" where \"Name\" = ? AND \"EmpID\" = ? ";
        EmpToProject empToProject =
                jdbcTemplateObject.queryForObject(SQL,
                        new Object[]{ name,empID}, new EmpToProjectMapper());
        return empToProject;


    }

    public List<Employee> getEmployeesByProjectName(String name) {

        String SQL = "select distinct \"Employee\".* "+
                         "from \"EmpToProject\"  "+
                             "join \"Employee\" "+
                             "on \"EmpToProject\".\"EmpID\"=\"Employee\".\"EmpID\" "+
                         "where \"EmpToProject\".\"Name\"=? "+

                         "union select distinct \"Employee\".* "+
                             "from \"Employee\" "+
                                 "join \"Project\" " +
                                 "on \"Project\".\"Manager\"=\"Employee\".\"EmpID\" "+
                         "where \"Project\".\"Name\"=?";

        List<Employee> employees=jdbcTemplateObject.query(
                SQL,new Object[]{name, name}, new EmployeeMapper());

        return employees;
    }

    public List<Project> getProjectsById(Integer empID) {
        String SQL = "select distinct \"Project\".* "+
                        "from \"EmpToProject\"  "+
                            "join \"Project\" "+
                            "on \"EmpToProject\".\"Name\"=\"Project\".\"Name\" "+
                        "where \"EmpToProject\".\"EmpID\"=? "+

                        "union select  distinct \"Project\".* "+
                            "from \"Employee\" "+
                                "join \"Project\" " +
                                "on \"Project\".\"Manager\"=\"Employee\".\"EmpID\" "+
                            "where \"Employee\".\"EmpID\"=?"
                        ;

        List<Project> projects=jdbcTemplateObject.query(
                SQL,new Object[]{empID, empID}, new ProjectMapper());

        return projects;
    }

    public List<EmpToProject> getAllEmpToProject() {
        String SQL = "select * from \"EmpToProject\" ";
       List<EmpToProject> empToProject =
                jdbcTemplateObject.query(SQL,
                        new EmpToProjectMapper());
        return empToProject;
    }

    public void createEmpToProject(Integer empID, String name) {

        String SQL ="insert into \"EmpToProject\" (\"EmpID\",\"Name\" ) values(?,?)";
        jdbcTemplateObject.update( SQL, empID, name);

    }

    public void deleteEmpToProject(Integer empID, String name) {

        String SQL ="delete from \"EmpToProject\" where  \"EmpID\"=? and \"Name\"=?";
        jdbcTemplateObject.update( SQL, empID, name);

    }
}
