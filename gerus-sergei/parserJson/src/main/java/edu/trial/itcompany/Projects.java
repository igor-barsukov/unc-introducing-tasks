package edu.trial.itcompany;

public class Projects {
    private String projectName;
    private String customer;
    private String manager;

    public Projects(String projectName, String customer, String manager) {
        this.projectName = projectName;
        this.customer = customer;
        this.manager = manager;
    }

    public Projects() {
        projectName = "";
        customer = "";
        manager = "";
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
