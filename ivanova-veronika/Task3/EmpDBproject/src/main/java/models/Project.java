package models;

/**
 * Created by acer-pc on 17.12.2016.
 */
public class Project {
    private String name;
    private String company;
    private Integer managerID;


    public Project() {}
    public Project(Project project) {
        this.managerID = project.getManagerID();
        this.company = project.getCompany();
        this.name =project.getName();
    }

    public Project(String name, Integer managerID, String company) {
        this.managerID = managerID;
        this.company = company;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
}
