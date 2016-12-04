package edu.trial.itcompany;

import java.util.LinkedList;
import java.util.List;

public class Employees {
    List<Employee> Employees = new LinkedList<Employee>();

    public List<Employee> getEmployees() {
        return new LinkedList<Employee>(Employees);
    }

    public void addEmployee(Employee employee) {
        this.Employees.add(employee);
    }
}





