package task_3.application;

import task_3.implementation_DAO.PostgreSQLDAO;

public class Main {
    public static void main(String... args){
        App app = new App(new PostgreSQLDAO());
        app.run();
    }
}
