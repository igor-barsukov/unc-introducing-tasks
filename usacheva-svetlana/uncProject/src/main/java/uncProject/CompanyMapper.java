package uncProject;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Света on 06.01.2017.
 */
public class CompanyMapper implements RowMapper{

    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company company = new Company();
        company.setName(rs.getString("Name"));
        return company;
    }
}
