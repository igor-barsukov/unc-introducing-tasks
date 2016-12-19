package mappers;

/**
 * Created by acer-pc on 19.12.2016.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import models.Company;


public class CompanyMapper implements RowMapper<Company> {
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company company = new Company(rs.getString("Name"));
        return company;
    }
}