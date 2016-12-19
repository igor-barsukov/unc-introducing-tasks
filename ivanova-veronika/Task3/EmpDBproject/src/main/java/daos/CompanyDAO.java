package daos;

import models.Company;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by acer-pc on 17.12.2016.
 */
public interface CompanyDAO {
    public void setDataSource(DataSource ds);
    Company getCompany(String name);
    List<Company> getAllCompanies();
    void createCompany(Company company);
    void updateCompany(String name, Company newCompany);
    void deleteCompany(String name);
}
