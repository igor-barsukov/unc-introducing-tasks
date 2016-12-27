package lab.companydb.dao;

import lab.companydb.model.Company;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Сергей on 21.12.2016.
 */
public interface CompanyDao {
    List<Company> getCompanyByProjectName(String name) throws SQLException;
}
