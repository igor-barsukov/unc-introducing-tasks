package lab.companydb.rowmapper;

import lab.companydb.model.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper implements RowMapper<Company> {
    public Company mapRow(ResultSet resultSet, int i) throws SQLException {
        String name = resultSet.getString("Name");
        Company company = new Company(name);
        return company;
    }
}
