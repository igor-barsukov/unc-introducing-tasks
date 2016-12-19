package daos;

import models.*;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by acer-pc on 17.12.2016.
 */
public interface ProjectDAO {

    public void setDataSource(DataSource ds);
    Project getProject(String name);
    List<Project> getAllProjects();
    void createProject(Project project);
    void updateProject(String name, Project newProject);
    void deleteProject(String name);
    Company  getCompanyByProjectName(String name);

}
