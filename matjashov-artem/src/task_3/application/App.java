package task_3.application;

import task_3.DAO;
import task_3.essence.*;

import java.util.LinkedList;

class App {
    private DAO dao;

    App(DAO dao){
        this.dao = dao;
    }

    void run(){
        printAllEmployees();
        printProjectsByEmployee();
        printCompanyByProjectName();
        createEmployee();
        deleteEmployeeByName();
    }

    private void deleteEmployeeByName() {
        boolean result = dao.deleteEmployeeByName("Artem");
        if (result)
            System.out.println("All Ok");
        else
            System.out.println("Error");
    }

    private void createEmployee() {
        boolean result = dao.createEmployee(9, "Artem", "Design");
        if (result)
            System.out.println("All Ok");
        else
            System.out.println("Error");
    }

    private void printCompanyByProjectName() {
        System.out.println("*** Print company for specific project ***");
        System.out.println(dao.getCompanyByProjectName("Facebook"));
    }

    void printAllEmployees(){
        System.out.println("*** Print all employees ***");
        LinkedList<Employee> employees = dao.getEmployees();
        for (Employee employee: employees)
            System.out.println(employee);
    }
    void printProjectsByEmployee(){
        System.out.println("*** Print project for specific employee ***");
        int empId = 9;
        LinkedList<Project> projects = dao.getProjectsByEmployee(empId);
        for (Project project: projects)
            System.out.println(project);
    }
}
