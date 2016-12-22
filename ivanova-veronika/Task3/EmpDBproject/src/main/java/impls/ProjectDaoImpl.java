package impls;

import daos.ProjectDAO;

import mappers.CompanyMapper;
import mappers.ProjectMapper;

import models.Company;
import models.Project;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.util.List;


/**
 * Created by acer-pc on 19.12.2016.
 */
public class ProjectDaoImpl implements ProjectDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);

    }

    public Project getProject(String name) {
        String SQL = "select * from \"Project\" where \"Name\" = ?";
          Project project =
                jdbcTemplateObject.queryForObject(SQL,
               new Object[]{name}, new ProjectMapper());
        return project;
    }

    public List<Project> getAllProjects() {

        String SQL = "select * from \"Project\"";
        List <Project> projects = jdbcTemplateObject.query(SQL,
                new ProjectMapper());
        return projects;
    }

    public void createProject(Project project) {
        String SQL = "insert into \"Project\" (\"Manager\", \"Company\", \"Name\") values (?, ?,?)";

        jdbcTemplateObject.update( SQL, project.getManagerID(), project.getCompany(), project.getName());

    }

    public void updateProject(String name, Project newProject) {
        String SQL;
        if (name.equals(newProject.getName())) {
            SQL = "update \"Project\" set \"Manager\" = ?, \"Company\"=? where \"Name\" = ?";

            jdbcTemplateObject.update(SQL, newProject.getManagerID(), newProject.getCompany(),name);

        }
        else {

            String InsertSQL="insert into \"Project\" (\"Manager\", \"Company\", \"Name\") values (?, ?,?)";

            String UpdateSQL= "update \"EmpToProject\" set \"Name\" = ? where \"EmpToProject\".\"Name\"= ? ";
            SQL = "delete from \"Project\" where \"Name\" = ?";

            //if PK was changed - cascade update
            jdbcTemplateObject.update(InsertSQL, newProject.getManagerID(), newProject.getCompany(), newProject.getName());
            jdbcTemplateObject.update(UpdateSQL, newProject.getName(), name);
            jdbcTemplateObject.update(SQL, name);

        }
    }

    public void deleteProject(String name) {

        String CascadeSQL = "delete from \"EmpToProject\" where \"Name\" = ? ";
        String SQL = "delete from \"Project\" where \"Name\" = ?";
        jdbcTemplateObject.update(CascadeSQL, name);
        jdbcTemplateObject.update(SQL, name);

    }

    public Company getCompanyByProjectName(String name) {
        String SQL = "select \"Company\".* " +
                         "from \"Project\" " +
                            "join \"Company\" on " +
                            "\"Project\".\"Company\" = \"Company\".\"Name\" " +
                         "where \"Project\".\"Name\" = ?";
        Company company = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{name}, new CompanyMapper());


        return  company;
    }
}
