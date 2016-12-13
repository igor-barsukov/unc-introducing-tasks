package edu.trial.itcompany;

import java.util.LinkedList;
import java.util.List;

public class Employee {
    private String personName;
    private String department;
    private List<Projects> projects = new LinkedList<Projects>();

    public Employee() {
        personName = "";
        department = "";
        projects = null;
    }

    public Employee(String personName, String department) {
        this.personName = personName;
        this.department = department;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void addProjects(Projects projects){
        this.projects.add(projects);
    }
    public List<Projects> getProjects() {
        return projects;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }



}
