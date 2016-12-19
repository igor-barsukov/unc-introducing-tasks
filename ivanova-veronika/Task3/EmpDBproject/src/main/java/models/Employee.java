package models;

/**
 * Created by acer-pc on 17.12.2016.
 */
public class Employee {
    private  Integer empID;
    private String name;
    private String department;


    public Employee() {}
    public Employee(Employee employee) {
        this.department = employee.getDepartment();
        this.name = employee.getName();
        this.empID = employee.getEmpID();
    }


    public Employee( String name, String department, Integer empID) {
        this.department = department;
        this.name = name;
        this.empID = empID;
    }

    public Integer getEmpID() {
        return empID;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }
}
