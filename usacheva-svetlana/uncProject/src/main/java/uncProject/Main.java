package uncProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uncProject.EmployeeJDBCTemplate;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        EmployeeJDBCTemplate employeeJDBCTemplate = (EmployeeJDBCTemplate)context.getBean("employeeJDBCTemplate");

        System.out.println("------Records Creation--------" );
        employeeJDBCTemplate.createEmployee("John", "manager");

        System.out.println("------Listing Multiple Records--------" );
        List<Employee> students = employeeJDBCTemplate.getEmployees();
        for (Employee record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Department : " + record.getDepartment());
        }

    }
}
