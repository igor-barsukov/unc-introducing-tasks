/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netcracker_curator_task_1;
import edu.trial.itcompany.InformationRecipient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Glushchenko Alexey
 */
public class RecipientMy implements InformationRecipient{
    public class Employee{
        private String personName;
        public String getPersonName() {
            return personName;
        }
        
        private String department;
        public String getDepartment() {
            return department;
        }
        
        public Employee(String _personName, String _department){
            this.personName = _personName;
            this.department = _department;
        } 

    }
    public class Project{
        private String projectName;
        public String getProjectName() {
            return projectName;
        } 
        
        private String customer;
        public String getCustomer() {
            return customer;
        }

        private String manager;
        public String getManager() {
            return manager;
        }
        
        public Project(String _projectName, String _customer, String manager){
            this.projectName = _projectName;
            this.customer = _customer;
            this.manager = manager;
        }
    }
    public class Customer{
        private String customer;
        public String getCustomer() {
            return customer;
        }
        
        public Customer(String _customer){
            this.customer = _customer;
        }
    }
    /*
    List <String> ListOfEmployeeOnProject;
    public List<String> getListOfEmployeeOnProject() {
        return ListOfEmployeeOnProject;
    }
    List <String> ListOfManagersForEmployee;
    public List<String> getListOfManagersForEmployee() {
        return ListOfEmployeeOnProject;
    }
    List <String> ListOfNotBusyEmployees;
    public List<String> getListOfNotBusyEmployees() {
        return ListOfEmployeeOnProject;
    }
    List <String> ListOfProjectsForCustomer;
    public List<String> getListOfProjectsForCustomer() {
        return ListOfEmployeeOnProject;
    }
    */
    
    @Override
    public List<String> getListOfEmployeeOnProject(String project) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getListOfManagersForEmployee(String empName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getListOfNotBusyEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getListOfProjectsForCustomer(String customerName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
