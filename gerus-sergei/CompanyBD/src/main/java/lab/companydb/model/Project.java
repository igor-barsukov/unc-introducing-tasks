package lab.companydb.model;

public class Project {
    private String name;
    private String company;
    private Integer managerId;

    public Project(String name, String company, int managerId) {
        this.name = name;
        this.company = company;
        this.managerId = managerId;
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


    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}
