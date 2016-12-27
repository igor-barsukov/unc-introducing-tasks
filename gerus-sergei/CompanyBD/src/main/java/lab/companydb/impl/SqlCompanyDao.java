package lab.companydb.impl;

import lab.companydb.dao.CompanyDao;
import lab.companydb.model.Company;
import lab.companydb.rowmapper.CompanyMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class SqlCompanyDao implements CompanyDao{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<Company> getCompanyByProjectName(String name) throws SQLException {
        String sql = "SELECT \"Company\".*\n" +
                " FROM \"Company\"\n" +
                "      JOIN \"Project\" ON\n" +
                "      \"Company\".\"Name\" = \"Project\".\"Company\"\n" +
                "WHERE \"Project\".\"Name\" = ?";
        List<Company> companies = jdbcTemplateObject.query(sql, new Object[]{name}, new CompanyMapper());
        return companies;
    }
}
