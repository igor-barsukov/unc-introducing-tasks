/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author qwerty
 */
public class InformationRecipientImpl implements InformationRecipient {

    List<String> ListOfEmployeeOnProject = new ArrayList<>();
    List<String> ListOfManagersForEmployee = new ArrayList<>();
    List<String> ListOfNotBusyEmployees = new ArrayList<>();
    List<String> ListOfProjectsForCustomer = new ArrayList<>();
    
    @Override
    public List<String> getListOfEmployeeOnProject(String project) {
        JSONParser parser = new JSONParser();
	try {
            JSONObject jsonEmployee;
            JSONObject jsonProjects;
            JSONArray msg = (JSONArray)parser.parse(new FileReader("base.dat"));
            for(int i =0; i <msg.size(); i++) {
                jsonEmployee = (JSONObject)msg.get(i);
                JSONArray arr = (JSONArray) jsonEmployee.get("projects");
                for(int j =0; j <arr.size(); j++) {
                    jsonProjects = (JSONObject)arr.get(j);
                    if (jsonProjects.get("projectName").toString().equals(project)) {
                        ListOfEmployeeOnProject.add(jsonEmployee.get("personName").toString());
                    }
                }
            }
	}   
        catch (FileNotFoundException e) {
            e.printStackTrace();
	} 
        catch (IOException | ParseException e) {
            e.printStackTrace();
	}
        
        return ListOfEmployeeOnProject;
    }

    @Override
    public List<String> getListOfManagersForEmployee(String empName) {
        JSONParser parser = new JSONParser();
	try {
            JSONObject jsonEmployee;
            JSONObject jsonProjects;
            JSONArray msg = (JSONArray)parser.parse(new FileReader("base.dat"));
            for(int i =0; i < msg.size(); i++) {
                jsonEmployee = (JSONObject)msg.get(i);
                if (jsonEmployee.get("personName").toString().equals(empName)) {
                    JSONArray arr = (JSONArray) jsonEmployee.get("projects");
                    for(int j =0; j <arr.size(); j++) {
                        jsonProjects = (JSONObject)arr.get(j);
                        ListOfManagersForEmployee.add(jsonProjects.get("manager").toString());
                    }
                    i = msg.size();
                }
                
            }
	}   
        catch (FileNotFoundException e) {
            e.printStackTrace();
	} 
        catch (IOException | ParseException e) {
            e.printStackTrace();
	}
        
        return ListOfManagersForEmployee;
    }

    @Override
    public List<String> getListOfNotBusyEmployees() {
        JSONParser parser = new JSONParser();
	try {
            JSONObject jsonEmployee;
            JSONArray msg = (JSONArray)parser.parse(new FileReader("base.dat"));
            for(int i =0; i <msg.size(); i++) {
                jsonEmployee = (JSONObject)msg.get(i);
                JSONArray arr = (JSONArray) jsonEmployee.get("projects");
                if (arr.isEmpty()) {
                    ListOfNotBusyEmployees.add(jsonEmployee.get("personName").toString());
                }
            }
	}   
        catch (FileNotFoundException e) {
            e.printStackTrace();
	} 
        catch (IOException | ParseException e) {
            e.printStackTrace();
	}
        
        return ListOfNotBusyEmployees;
    }

    @Override
    public List<String> getListOfProjectsForCustomer(String customerName) {
        Set<String> hs = new HashSet<>();
        JSONParser parser = new JSONParser();
	try {
            JSONObject jsonEmployee;
            JSONObject jsonProjects;
            JSONArray msg = (JSONArray)parser.parse(new FileReader("base.dat"));
            for(int i =0; i <msg.size(); i++) {
                jsonEmployee = (JSONObject)msg.get(i);
                JSONArray arr = (JSONArray) jsonEmployee.get("projects");
                for(int j =0; j <arr.size(); j++) {
                    jsonProjects = (JSONObject)arr.get(j);
                    if (jsonProjects.get("customer").toString().equals(customerName)) {
                        hs.add(jsonProjects.get("projectName").toString());
                    }
                }
            }
	}   
        catch (FileNotFoundException e) {
            e.printStackTrace();
	} 
        catch (IOException | ParseException e) {
            e.printStackTrace();
	}

        ListOfProjectsForCustomer.addAll(hs);
        return ListOfProjectsForCustomer;
    }
    
}
