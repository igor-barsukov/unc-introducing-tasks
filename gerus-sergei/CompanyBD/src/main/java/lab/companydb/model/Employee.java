package lab.companydb.model;

public class Employee {
    private int empId;
    private String name;
    private String department;

    public Employee() {

    }

    public Employee(int empId, String name, String department){
        this.empId = empId;
        this.name = name;
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
