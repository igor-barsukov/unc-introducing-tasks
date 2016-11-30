import edu.trial.itcompany.InformationRecipient;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Света on 28.11.2016.
 */
public class InformationRecipientImpl extends Parser implements InformationRecipient{

    List<String> ListOfEmployeeOnProject = new LinkedList<>();
    List<String> ListOfManagersForEmployee = new LinkedList<>();
    List<String> ListOfNotBusyEmployees = new LinkedList<>();
    List<String> ListOfProjectsForCustomer = new LinkedList<>();
    @Override
    public  void getListOfEmployeeOnProject(String project) throws IOException {

        Parser.readUsingScanner();
        while (itr.hasNext()){
            if (itr.next().equals(project)){
                while (!(itr.previous().equals("\"personName\":"))){
                    itr.hasPrevious();
                }
                itr.next();
                ListOfEmployeeOnProject.add(itr.next());
                while (!(itr.next().equals(project))){
                    itr.hasNext();
                }
            }

        }

       System.out.println(ListOfEmployeeOnProject);
    }

    @Override
    public void getListOfManagersForEmployee(String empName) throws IOException {

        Parser.readUsingScanner();
        while (itr.hasNext()){
            if (itr.next().equals(empName)){
                while (!(itr.next().equals("]")) && !(itr.previous().equals("[]"))){
                  //  itr.previous();
                    if (itr.next().equals("\"manager\":")){
                       // itr.next();
                        ListOfManagersForEmployee.add(itr.next());
                    //    itr.next();
                    }
                }
            }
           // itr.next();
        }

       System.out.println(ListOfManagersForEmployee);

    }

    @Override
    public void getListOfNotBusyEmployees() throws IOException {

        Parser.readUsingScanner();
        while (itr.hasNext()){
            if (itr.next().equals("[]")){
                while (!(itr.previous().equals("\"personName\":"))){
                    itr.hasPrevious();
                }
                itr.next();
                ListOfNotBusyEmployees.add(itr.next());
                while (!(itr.next().equals("[]"))){
                    itr.hasNext();
                }
            }

        }

        System.out.println(ListOfNotBusyEmployees);

    }

    @Override
    public void getListOfProjectsForCustomer(String customerName) throws IOException {
        Parser.readUsingScanner();
        while (itr.hasNext()){
            if (itr.next().equals(customerName)){
                while (!(itr.previous().equals("\"projectName\":"))){
                    itr.hasPrevious();
                }
                itr.next();
                ListOfProjectsForCustomer.add(itr.next());
                while (!(itr.next().equals(customerName))){
                    itr.hasNext();
                }
            }

        }

        System.out.println(ListOfProjectsForCustomer);
    }
}
