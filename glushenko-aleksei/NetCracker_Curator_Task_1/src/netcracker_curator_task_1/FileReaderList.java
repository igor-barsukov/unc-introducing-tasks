/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netcracker_curator_task_1;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Glushchenko Alexey
 */
public class FileReaderList {
    private String filePath;
    public String getFilePath() {
        return filePath;
    }
    
    private ArrayList DATA;
    public ArrayList getDATA() {
        return DATA;
    }
    
    public FileReaderList(){
        this.filePath = null;
        DATA = new ArrayList<String>();
    }
    
    public void Read(String _filePath){
        this.filePath = _filePath;

        File Data;
        BufferedReader FileBufferedReaderData = null;
        try{
            Data = new File(filePath); 

            FileBufferedReaderData = new BufferedReader(new FileReader(Data));
            String str;
            while ((str = FileBufferedReaderData.readLine())!= null){
                DATA.add(str);
            }

        } catch (Exception e) {
           System.err.println(e.getLocalizedMessage());
        }finally{
            try {
                FileBufferedReaderData.close();
            } catch (Exception e) {
                if (FileBufferedReaderData != null)
                    System.err.println(e.getLocalizedMessage());
            }
        }
    }
    public int GetCountString(){
        return DATA.size();
    }
    
    public String GetString(int indexStr){
        if (indexStr >= DATA.size()){
            System.err.println("Нет такой строки. Максимальный индекс " + DATA.size());
            return null;
        }
        if (indexStr < 0){
            System.err.println("Нет такой строки. Минимальный индекс 0");
            return null;
        }
           
        return (String)DATA.get(indexStr);            
    }
    
    public char GetChar(int indexStr, int indexChar){
        String str = GetString(indexStr);
        if (indexChar >= str.length()){
            System.err.println("Нет такого символа. Максимальный индекс символа " + str.length());
            return '\0';
        }
        if (indexChar < 0){
            System.err.println("Нет такого символа. Минимальный индекс символа  0");
            return '\0';
        }      
           
        return ((String)DATA.get(indexStr)).charAt(indexStr);            
    }
}
