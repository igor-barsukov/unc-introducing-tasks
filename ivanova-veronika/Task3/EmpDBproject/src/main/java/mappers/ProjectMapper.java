package mappers;

/**
 * Created by acer-pc on 19.12.2016.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import models.Project;

public class ProjectMapper implements RowMapper<Project> {
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project(rs.getString("Name"),rs.getInt("Manager"),  rs.getString("Company") );
        return project;
    }
}
