package companydb.service;

import companydb.model.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void removeEmployee(int id);

    Employee getEmployeeById(int id);

    List<Employee> listEmployee();
}
