package uncProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uncProject.EmployeeJDBCTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        EmployeeJDBCTemplate employeeJDBCTemplate = (EmployeeJDBCTemplate)context.getBean("employeeJDBCTemplate");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /*Show employees list*/
        System.out.println("------List of employees--------" );
        List<Employee> employees = employeeJDBCTemplate.getEmployees();
        for (Employee record : employees) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Department : " + record.getDepartment());
        }

         /*Employee Creation*/
        System.out.println("------Employee Creation--------" );
        System.out.println("Write employee name:" );
        String emplName = reader.readLine();
        System.out.println("Write department name:" );
        String depName = reader.readLine();
        employeeJDBCTemplate.createEmployee("\'" + emplName + "\'", "\'" + depName + "\'");

        /*Show projects list by managerID*/
        System.out.println("-----------------Write managerID for list of projects-----------");
        String mangID = reader.readLine();
        int managerID = Integer.parseInt(mangID);
        System.out.println("-----------------List of projects-----------");
        List<Project> projects = employeeJDBCTemplate.getProjectsByEmployee(managerID);
        for (Project record : projects) {
            System.out.print("ManagerID : " + record.getManagerID() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Company : " + record.getCompanyName());
        }

        /*Show companies list by project name*/
        System.out.println("-----------------Write Poject Name-----------");
        String projName = reader.readLine();
        System.out.println("-----------------List of companies-----------");
        List<Company> companies = employeeJDBCTemplate.getCompanyByProjectName("\'" + projName + "\'");
        for (Company record : companies) {
            System.out.print("Name : " + record.getName() );
        }

        /*Delete an employee by name. Here the CASCADE DELETION is used. CASCADE is chosen in postgreSQL properties*/
        System.out.println("-----------------Write Employee Name For Del-----------");
        emplName = reader.readLine();
        employeeJDBCTemplate.deleteEmployeeByName("\'" + emplName + "\'");
        employees = employeeJDBCTemplate.getEmployees();
        for (Employee record : employees) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Department : " + record.getDepartment());
        }

      /*  try {
            employeeJDBCTemplate.getEmployees();
            employeeJDBCTemplate.createEmployee("\'" + emplName + "\'", "\'" + depName + "\'");
            employeeJDBCTemplate.getProjectsByEmployee(managerID);
            employeeJDBCTemplate.getCompanyByProjectName("\'" + projName + "\'");
            employeeJDBCTemplate.deleteEmployeeByName("\'" + emplName + "\'");

        } catch (Exception e) {
            System.out.println("Smth wrong happens. Try again!");
        }*/

    }


}
