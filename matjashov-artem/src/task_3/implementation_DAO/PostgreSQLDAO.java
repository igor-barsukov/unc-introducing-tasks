package task_3.implementation_DAO;

import task_3.DAO;
import task_3.essence.*;

import java.util.LinkedList;

public class PostgreSQLDAO implements DAO {
    @Override
    public LinkedList<Employee> getEmployees() {
        return null;
    }

    @Override
    public LinkedList<Project> getProjectsByEmployee(int empId) {
        return null;
    }

    @Override
    public Company getCompanyByProjectName(String name) {
        return null;
    }

    @Override
    public boolean createEmployee(int empId, String name, String department) {
        return false;
    }

    @Override
    public boolean deleteEmployeeByName(String name) {
        return false;
    }
}
