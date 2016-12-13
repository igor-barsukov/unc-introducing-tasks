/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;


/**
 *
 * @author qwerty
 */
public class Parser {
    
//    public String test(){
//        return 
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InformationRecipientImpl i = new InformationRecipientImpl();
        System.out.println(i.getListOfEmployeeOnProject("Windows 300"));
        System.out.println(i.getListOfManagersForEmployee("Surname7"));
        System.out.println(i.getListOfProjectsForCustomer("Microsoft"));
        System.out.println(i.getListOfNotBusyEmployees());
    }
    
}
