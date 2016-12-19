package models;

/**
 * Created by acer-pc on 17.12.2016.
 */
public class Company {
    private String name;

    public Company(){}

    public Company(String name) {
        this.name = name;
    }

    public Company(Company company) {
        this.name=company.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
