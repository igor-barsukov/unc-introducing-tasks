package lab.companydb.Test;


import lab.companydb.dao.CompanyDao;
import lab.companydb.dao.EmployeeDao;
import lab.companydb.dao.ProjectDao;
import lab.companydb.model.Company;
import lab.companydb.model.Employee;
import lab.companydb.model.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Сергей on 21.12.2016.
 */
public class App {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        ProjectDao projectDao = (ProjectDao) context.getBean("projectDao");
        CompanyDao companyDao = (CompanyDao) context.getBean("companyDao");

        List<Project> projects = projectDao.getProjectsByEmployee(2);
        for (Project proj: projects) {
            System.out.println("Name: "+ proj.getName() + "\nCompany: " + proj.getCompany() + "\nManagerId: " + proj.getManagerId());
        }

        List<Company> companies = companyDao.getCompanyByProjectName("Project 2");
        for (Company comp: companies) {
            System.out.println("Name: "+ comp.getName());
        }

        Employee emp1 = new Employee();
        emp1.setName("Сидоров2");
        emp1.setDepartment("Department2");
        employeeDao.create(emp1);

        //employeeDao.deleteEmployeeByName("Сидоров2");

        List<Employee> employees = employeeDao.getEmployees();
        for (Employee empl: employees) {
            System.out.println("Id: "+ empl.getEmpId()+ "\nName employee: " + empl.getName()+ "\nDepartment: " + empl.getDepartment());
        }
    }
}
