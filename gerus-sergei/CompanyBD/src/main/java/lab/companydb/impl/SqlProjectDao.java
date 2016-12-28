package lab.companydb.impl;

import lab.companydb.dao.ProjectDao;
import lab.companydb.model.Project;
import lab.companydb.rowmapper.ProjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class SqlProjectDao implements ProjectDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<Project> getProjectsByEmployee(int empId) throws SQLException {
        String sql = "SELECT \"Project\".*\n" +
                "  FROM \"EmpToProject\"\n" +
                "  JOIN \"Project\" ON \"EmpToProject\".\"Name\" = \"Project\".\"Name\"\n" +
                "WHERE \"EmpID\" = ?";
        List<Project> project = jdbcTemplateObject.query(sql, new Object[]{empId}, new ProjectMapper());
        return project;
    }
}
