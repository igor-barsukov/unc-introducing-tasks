package models;

/**
 * Created by acer-pc on 17.12.2016.
 */
public class EmpToProject {
    private Integer empID;
    private String project;


    public EmpToProject(){}
    public EmpToProject(Integer empID, String project) {
        this.empID = empID;
        this.project = project;
    }

    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}

