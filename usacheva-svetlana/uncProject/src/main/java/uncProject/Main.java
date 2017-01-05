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

    public static void main(String[] args) throws IOException {
       // EmployeeDAO employeeDAO = (EmployeeDAO) ctx.getBean("employeeDAO");
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");


        EmployeeJDBCTemplate employeeJDBCTemplate = (EmployeeJDBCTemplate)context.getBean("employeeJDBCTemplate");


        /*System.out.println("------Employee Creation--------" );
        employeeJDBCTemplate.createEmployee("\'Margaret\'", "\'hr\'");

        System.out.println("------List of employees--------" );
        List<Employee> students = employeeJDBCTemplate.getEmployees();
        for (Employee record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Department : " + record.getDepartment());
        }

        System.out.println("-----------------Write managerID-----------");*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));/*
        String mangID = reader.readLine();
        int managerID = Integer.parseInt(mangID);
        System.out.println("-----------------List of projects-----------");
        List<Project> projects = employeeJDBCTemplate.getProjectsByEmployee(managerID);
        for (Project record : projects) {
            System.out.print("ManagerID : " + record.getManagerID() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Company : " + record.getCompanyName());
        }

        System.out.println("-----------------Write Poject Name-----------");
        String projName = reader.readLine();
        System.out.println("-----------------List of companies-----------");
        List<Company> companies = employeeJDBCTemplate.getCompanyByProjectName("\'" + projName + "\'");
        for (Company record : companies) {
            System.out.print("Name : " + record.getName() );
        }*/




    }
}
