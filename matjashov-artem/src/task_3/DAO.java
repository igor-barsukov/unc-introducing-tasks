package task_3;

import task_3.essence.*;

import java.util.LinkedList;

public interface DAO {
    /**
     * @return list of  all employees
     */
    public LinkedList<Employee> getEmployees();
    /**
     * @param   empId  specific id of employee
     *
     * @return projects for specified employee
     */
    public LinkedList<Project> getProjectsByEmployee(int empId);
    /**
     *
     * @param name specific name of employee
     *
     * @return company for specified  project
     */
    public Company getCompanyByProjectName(String name);
    /**
     * creates new employee at DB
     *
     * @param empId         specific id of employee
     * @param name          specific name of employee
     * @param department    name of department
     */
    public boolean createEmployee(int empId, String name, String department);
    /**
     * deletes specified employee from DB
     *
     * @param name
     * @return
     */
    public boolean deleteEmployeeByName(String name);
}
