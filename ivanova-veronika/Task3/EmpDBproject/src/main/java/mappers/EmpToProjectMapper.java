package mappers;

/**
 * Created by acer-pc on 19.12.2016.
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Project;
import org.springframework.jdbc.core.RowMapper;
import models.EmpToProject;

public class EmpToProjectMapper implements RowMapper<EmpToProject> {
    public EmpToProject mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmpToProject empToProject = new EmpToProject( rs.getInt("EmpID"),rs.getString("Name"));
        return empToProject;
    }
}