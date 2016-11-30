package edu.trial.itcompany;

import java.util.List;
import java.util.Map;

public interface InformationRecipient {

    /**
     * getListOfEmployeeOnProject hava to show list of employees which work on specified project
     * @param project name of the project
     * @return list of employees which work on specified project
     */
    public List<String> getListOfEmployeeOnProject(String project);

    /**
     * getListOfManagersForEmployee returns the list of superior for specified employee
     * @param empName name of the employee
     * @return the list of managers for empName
     */
    public List<String> getListOfManagersForEmployee(String empName);

    /**
     * getListOfNotBusyEmployees returns the list of employees who don't have the project
     * @return not busy employees
     */
    public List<String> getListOfNotBusyEmployees();

    /**
     * getListOfProjectsForCustomer returns the projects of the customer
     * @param customerName name of the customer
     * @return the projects of the customer
     */
    public List<String> getListOfProjectsForCustomer(String customerName);

}
