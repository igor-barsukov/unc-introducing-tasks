package edu.trial.itcompany;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class InformationRecipientImpl implements InformationRecipient {

    public Employees employees;

    public InformationRecipientImpl() throws FileNotFoundException {
        String fileName = "base.dat";
        String textFromFile = FileWorker.read(fileName);
        employees = new Gson().fromJson(textFromFile, Employees.class);
    }

    //возвращает список сотрудников, которые работают на указанном проекте
    public List<String> getListOfEmployeeOnProject(String project) {
        ArrayList<String> employeeOnProject = new ArrayList<String>();
        for (int i = 0; i < employees.Employees.size(); i++) {
            for (int j = 0; j < employees.Employees.get(i).getProjects().size(); j++) {
                if (employees.Employees.get(i).getProjects().get(j).getProjectName().equals(project)) {
                    employeeOnProject.add(employees.Employees.get(i).getPersonName());
                }
            }
        }
        return employeeOnProject;
    }

    //возвращает список менеджеров по проектам
    public List<String> getListOfManagersForEmployee(String empName) {
        ArrayList<String> managersForEmployee = new ArrayList<String>();
        for (int i = 0; i < employees.Employees.size(); i++) {
            for (int j = 0; j < employees.Employees.get(i).getProjects().size(); j++) {
                if (employees.Employees.get(i).getProjects().get(j).getManager().equals(empName) & !managersForEmployee.contains(employees.Employees.get(i).getProjects().get(j).getProjectName())) {
                    managersForEmployee.add(employees.Employees.get(i).getProjects().get(j).getProjectName());
                }
            }
        }
        return managersForEmployee;
    }

    //возвращает список сотрудников, у которых нет проекта
    public List<String> getListOfNotBusyEmployees() {
        ArrayList<String> NotBusyEmployees = new ArrayList<String>();
        for (int i = 0; i < employees.Employees.size(); i++) {
            if(employees.Employees.get(i).getProjects().size() == 0) {
                NotBusyEmployees.add(employees.Employees.get(i).getPersonName());
            }
        }
        if (NotBusyEmployees.size() == 0) {
            NotBusyEmployees.add("У всех сотрудников есть проект");
        }
        return NotBusyEmployees;
    }

    //возвращает список заказчиков проекта
    public List<String> getListOfProjectsForCustomer(String customerName) {
        ArrayList<String> projectsForCustomer = new ArrayList<String>();
        for (int i = 0; i < employees.Employees.size(); i++) {
            for (int j = 0; j < employees.Employees.get(i).getProjects().size(); j++) {
                if(employees.Employees.get(i).getProjects().get(j).getCustomer().equals(customerName) & !projectsForCustomer.contains(employees.Employees.get(i).getProjects().get(j).getProjectName())){
                    projectsForCustomer.add(employees.Employees.get(i).getProjects().get(j).getProjectName());
                }
            }
        }
        return projectsForCustomer;
    }
}
