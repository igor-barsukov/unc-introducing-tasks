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
    static public class Employee{
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
    static public class Project{
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
    static public class Customer{
        private String customer;
        public String getCustomer() {
            return customer;
        }
        
        public Customer(String _customer){
            this.customer = _customer;
        }
    }
    
    public ArrayList emp = new ArrayList();
    public ArrayList prj = new ArrayList();
        
    public Map EmplProj = new HashMap<String, String>();
    public Map ManagEmp = new HashMap<String, String>();
    public Map ProjCust = new HashMap<String, String>();
    
    public void addEmpProjCust(String _personName, String _department, String _projectName, String _customer, String _manager){
        emp.add(new Employee(_personName, _department));
        prj.add(new Project(_projectName, _customer, _manager));
        
        EmplProj.put(_projectName, _personName);
        ManagEmp.put(_personName, _manager);
        ProjCust.put(_projectName, _customer);
    }
    public void demo(){
        System.out.println(((Employee)emp.get(0)).personName);
        System.out.println(ManagEmp.values());
        System.out.println(ProjCust.values());
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
