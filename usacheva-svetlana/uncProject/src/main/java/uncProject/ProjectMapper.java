package uncProject;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Света on 06.01.2017.
 */
public class ProjectMapper implements RowMapper{

    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project();
        project.setManagerID(rs.getInt("ManagerID"));
        project.setName(rs.getString("Name"));
        project.setCompanyName(rs.getString("Company"));
        return project;
    }
}
