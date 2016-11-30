import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {



    public  static void main(String[] args) throws IOException {

        InformationRecipientImpl inf = new InformationRecipientImpl();
        inf.getListOfEmployeeOnProject("\"DWDM\",");
        inf.getListOfManagersForEmployee("\"Ivanov\",");
        inf.getListOfNotBusyEmployees();
        inf.getListOfProjectsForCustomer("\"Microsoft\",");

    }
}
