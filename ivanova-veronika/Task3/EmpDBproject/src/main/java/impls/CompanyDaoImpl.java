package impls;

import daos.CompanyDAO;
import models.Company;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import mappers.CompanyMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


/**
 * Created by acer-pc on 19.12.2016.
 */
public class CompanyDaoImpl implements CompanyDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplateObject = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);

    }

    public Company getCompany(String name) {
        String SQL = "select * from \"Company\" where \"Name\" = :CompName";
        Map<String, String> namedParameters = Collections.singletonMap("CompName", name);
        Company company  =namedParameterJdbcTemplate.queryForObject(SQL, namedParameters,  new CompanyMapper());
        return company;
    }

    public List<Company> getAllCompanies() {
        String SQL = "select * from \"Company\"";
        List <Company> companies = jdbcTemplateObject.query(SQL,
                new CompanyMapper());
        return companies;
    }

    public void createCompany(Company company) {
        String SQL = "insert into \"Company\" (\"Name\") values (:CompName) ";
        Map<String, String> namedParameters = Collections.singletonMap("CompName", company.getName());
        namedParameterJdbcTemplate.update( SQL, namedParameters);
    }

    public void updateCompany(String name, Company newCompany) {

        Map<String, String> namedParameters = new HashMap();
        namedParameters.put("NewCompName", newCompany.getName());
        namedParameters.put("CompName", name);

        String InsertSQL="insert into \"Company\" (\"Name\") values (:NewCompName)";
        String UpdateSQL= "update \"Project\" set \"Company\"= :NewCompName where \"Company\" = :CompName";
        String SQL = "delete from \"Company\" where \"Name\" = :CompName";

        //Cascade update
        namedParameterJdbcTemplate.update( InsertSQL, namedParameters);
        namedParameterJdbcTemplate.update( UpdateSQL, namedParameters);
        namedParameterJdbcTemplate.update( SQL, namedParameters);

    }

    public void deleteCompany(String name) {

        //Cascade delete
        String SQL = "delete from \"Company\" where \"Name\" = :CompName";
        String CascadeSQL="update \"Project\" set \"Company\"= null where \"Company\" = :CompName";
        Map<String, String> namedParameters = Collections.singletonMap("CompName", name);
        namedParameterJdbcTemplate.update(CascadeSQL, namedParameters);
        namedParameterJdbcTemplate.update(SQL, namedParameters);

    }
}
