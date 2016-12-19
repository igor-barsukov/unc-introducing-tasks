package daos;

import models.EmpToProject;
import models.Employee;
import models.Project;

import javax.sql.DataSource;
import java.util.List;


/**
 * Created by acer-pc on 17.12.2016.
 */
public interface EmpToProjectDAO {
    public void setDataSource(DataSource ds);
    EmpToProject getEmpToProject(Integer empID, String name);
    List<Employee> getEmployeesByProjectName(String name);
    List<Project> getProjectsById(Integer empID);
    List<EmpToProject> getAllEmpToProject();
    void createEmpToProject(Integer empID, String name);
    void deleteEmpToProject(Integer empID, String name);


}
