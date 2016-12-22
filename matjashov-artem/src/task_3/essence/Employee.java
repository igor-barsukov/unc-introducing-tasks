package task_3.essence;

public class Employee {
    private int     empId;
    private String  name;
    private String  department;

    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmpId(int empId)
    {
        this.empId = empId;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getName(){
        return name;
    }
    public int getEmpId(){
        return empId;
    }
    public String getDepartment(){
        return department;
    }
    public String toString(){
        return name;
    }
}
