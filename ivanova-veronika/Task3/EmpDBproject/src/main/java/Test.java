/**
 * Created by acer-pc on 19.12.2016.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daos.*;
import models.*;
import java.util.List;



public class Test {

    public static void taskTest(ApplicationContext ctx){

        Integer empID=1;
        String nameToDel="Ivanov";
        String projectName="Test";

        Employee employee = new Employee();
        employee.setName("Sidorov");
        employee.setDepartment("Dep123");


        EmployeeDAO employeeDAO =
                (EmployeeDAO) ctx.getBean("employeeDAO");
        ProjectDAO projectDAO =
                (ProjectDAO) ctx.getBean("projectDAO");
        CompanyDAO companyDAO =
                (CompanyDAO) ctx.getBean("companyDAO");
        EmpToProjectDAO empToProjectDAO =
                (EmpToProjectDAO) ctx.getBean("empToProjectDAO");



        System.out.println("Get All Employees");
        List<Employee> employees= employeeDAO.getAllEmployees();
        for (Employee em : employees)
        {
            System.out.println( "\nId: " + em.getEmpID()
                    + "\nName: " + em.getName()
                    + "\nDep: " + em.getDepartment());
        }


        System.out.println("\nGet Projects By Employee");
        List<Project> projects = empToProjectDAO.getProjectsById(empID);
        for (Project p : projects) {
            System.out.println( "\nName: " + p.getName()
                    + "\nComp: " + p.getCompany()
                    + "\nMan: " + p.getManagerID()
            );
        }

        System.out.println("\nGet Company By Project");

        Company company=projectDAO.getCompanyByProjectName(projectName);
        System.out.println(company.getName());


        System.out.println("\nCreate Employee");
        employeeDAO.createEmployee(employee);
        System.out.println("Employee was added.  ");



        System.out.println("\nCreate Employee");


        employeeDAO.deleteEmployeeByName(nameToDel);
        System.out.println("Employee was deleted. \nNew list of employees: ");

        employees=employeeDAO.getAllEmployees();
        for (Employee em : employees)
        {
            System.out.println("\nId: " + em.getEmpID()
                    + "\nName: " + em.getName()
                    + "\nDep: " + em.getDepartment());
        }






    }

    public static void main(String args[]){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("SpringConfig.xml");


        taskTest(ctx);


    }

}
