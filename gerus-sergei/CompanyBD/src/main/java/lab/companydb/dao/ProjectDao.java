package lab.companydb.dao;

import lab.companydb.model.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {
     List<Project> getProjectsByEmployee(int empId) throws SQLException;
}
