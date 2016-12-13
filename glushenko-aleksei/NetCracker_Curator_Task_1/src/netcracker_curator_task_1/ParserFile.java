/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netcracker_curator_task_1;

import java.util.ArrayList;

/**
 *
 * @author Glushchenko Alexey
 */
public class ParserFile {
    private ArrayList localData;
    private RecipientMy localRecipientMy;
    
    public ParserFile(ArrayList globalData, RecipientMy globalRecipientMy){
        this.localData = globalData;
        this.localRecipientMy = globalRecipientMy;
    }
    
    private int whatIsIt(String str){
        char[] array = str.toCharArray();
        
        if (str.contains("personName")) return 1;
        if (str.contains("department")) return 2;
        if (str.contains("projects")) return 3;
        if (str.contains("projectName")) return 4;
        if (str.contains("customer")) return 5;
        if (str.contains("manager")) return 6;        
        return -1;
    }
    
    private String getValue(String str){
        int start = str.indexOf(':');
        
        int end = str.lastIndexOf('\"');
        start = str.indexOf('\"', start);
        
        return str.substring(start + 1, end);
    }
    
    private boolean nullProject(String str){
        int brac = str.indexOf('[');
        int kets = str.indexOf(']');
        
        if (brac >= 0 && kets >= 0) return true;
        return false;
    }
    
    private int parsingStrMode = 1;
    public void runParsing(){
        String personName = "", department = "", projectName = "", customer = "", manager = "";        
        
        for(int i = 0; i < localData.size(); i++){
            String str = (String)localData.get(i);
            
            int elementType = whatIsIt(str);
            
            switch (elementType){
                case 1:
                    personName = getValue(str);
                    break;
                case 2:
                    department = getValue(str);                    
                    break;
                case 3:
                    if (nullProject(str)){
                        localRecipientMy.addEmpProjCust(personName, department, "null", "null", "null");
                        //continue;
                    }  
                    break;
                case 4:
                    projectName = getValue(str);
                    System.out.println(projectName);
                    break;
                case 5:
                    customer = getValue(str);
                    break;
                case 6:
                    manager = getValue(str);
                    localRecipientMy.addEmpProjCust(personName, department, projectName, customer, manager);
                    break;
            };             
        }
        localRecipientMy.demo();
    }
}
