package lab.companydb.rowmapper;

import lab.companydb.model.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Сергей on 26.12.2016.
 */
public class ProjectMapper implements RowMapper<Project> {
public  Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("Name");
        String company = rs.getString("Company");
        int managerId = rs.getInt("ManagerID");
        Project project = new Project(name, company, managerId);
        return project;
        }
}
