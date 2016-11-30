package edu.trial.itcompany;



import java.io.File;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by acer-pc on 25.11.2016.
 */


public class InformationRecipientImpl implements InformationRecipient {
    public static String PATH="base.dat";


    private String getSubstring(String template, String string)
    {
        Pattern pattern= Pattern.compile(template);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()){
            return matcher.group();

        }
        return  null;

    }

    @Override
    public List<String> getListOfEmployeeOnProject(String project) {
        List<String> emp=new LinkedList<String>();
        String buf="", line;
        String template;
        boolean isNeededProject=false;

        try{
            Scanner sc = new Scanner(new File(PATH));
            while (sc.hasNext()){
                line=sc.nextLine();
                template= "\"(\\w+)[ (\\w+)]{0,}\",";
                if ( line!=null && line.toLowerCase().contains("personname")) {
                    buf=getSubstring(template,line);
                }
                else
                if(line.toLowerCase().contains("projectname") && line.toLowerCase().contains(project.toLowerCase())
                        && buf!="" && !emp.contains(buf) ) {
                    emp.add(buf.substring(1,buf.length()-2));
                    isNeededProject=true;
                }
                else
                if (line.toLowerCase().contains("manager") && isNeededProject)
                {
                    template="\"(\\w+)[ (\\w+)]{0,}\"$";
                    if ((buf=getSubstring(template, line.trim()))!=null)

                        buf=buf.substring(2,buf.length()-1);

                    if (!emp.contains(buf))
                        emp.add(buf);

                    isNeededProject=false;

                }

            }

            sc.close();
            return emp;
        }
        catch (Exception e){

            return  null;
        }


    }

    @Override
    public List<String> getListOfManagersForEmployee(String empName) {
        List<String> managers=new LinkedList<String>();
        String buf="", line;
        String template;
        boolean isNeededEmp=false;
        try{
            Scanner sc = new Scanner(new File(PATH));

            while (sc.hasNext()) {
                line = sc.nextLine();
                template="\"(\\w+)[ (\\w+)]{0,}\"$";
                if (line != null && line.toLowerCase().contains("personname")
                        && line.toLowerCase().contains(empName.toLowerCase())) {
                    isNeededEmp = true;

                }
                else if ((line != null && line.toLowerCase().contains("personname")
                        && !line.toLowerCase().contains(empName.toLowerCase()))) {
                    isNeededEmp = false;
                }
                else if (line != null && line.toLowerCase().contains("manager") && isNeededEmp) {

                    if ((buf = getSubstring(template, line.trim())) != null) {

                        buf = buf.substring(1, buf.length() - 1);
                        if (!managers.contains(buf))
                            managers.add(buf);
                    }
                }


            }

            sc.close();

            return managers;
        }
        catch (Exception e){

            return  null;
        }




    }

    @Override
    public List<String> getListOfNotBusyEmployees() {
        List<String> emp=new LinkedList<String>();
        String buf="", line;
        List<String> managers=new LinkedList<String>();

        try{
            Scanner sc = new Scanner(new File(PATH));
            while (sc.hasNext()){

                line=sc.nextLine();
                String p="\"(\\w+)[ (\\w+)]{0,}\",";

                if ( line!=null && line.toLowerCase().contains("personname")) {
                    buf=getSubstring(p,line);

                }
                else
                if(line.toLowerCase().contains("projects") && line.toLowerCase().contains("]")
                        && buf!="" && !emp.contains(buf) ) {
                    emp.add(buf.substring(1,buf.length()-2));

                }
                else if (line.toLowerCase().contains("manager") )
                {
                    p="\"(\\w+)[ (\\w+)]{0,}\"$";
                    if ((buf=getSubstring(p, line.trim()))!=null)

                        buf=buf.substring(1,buf.length()-1);
                    managers.add(buf);


                }

            }
            for (String elem :emp)
            {
                if (managers.contains(elem))
                    emp.remove(elem);
            }

            sc.close();

            return emp;
        }
        catch (Exception e){

            return  null;
        }

    }

    @Override
    public List<String> getListOfProjectsForCustomer(String customerName) {
        List<String> projects=new LinkedList<String>();
        String buf="", line;

        try{
            Scanner sc = new Scanner(new File(PATH));
            while (sc.hasNext()){

                line=sc.nextLine();
                String p="\"(\\w+)[[ .,!?\\d]+(\\w+)]{0,}\",";

                if ( line!=null && line.toLowerCase().contains("projectname")) {
                    buf=getSubstring(p,line);
                }
                else
                if(line.toLowerCase().contains("customer") && line.toLowerCase().contains(customerName.toLowerCase())
                        && buf!="" && !projects.contains(buf.substring(1,buf.length()-2)) ) {
                    projects.add(buf.substring(1,buf.length()-2));

                }

           }
            sc.close();

            return projects;

        }
        catch (Exception e){

            return  null;
        }

    }
}
