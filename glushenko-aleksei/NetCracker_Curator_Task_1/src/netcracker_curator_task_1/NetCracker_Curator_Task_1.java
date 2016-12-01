/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netcracker_curator_task_1;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Glushchenko Alexey
 */
public class NetCracker_Curator_Task_1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner inputLine = new Scanner(System.in);
        RecipientMy task1 = new RecipientMy();     
        FileReaderList file = new FileReaderList();
        
        Map hashMap = new HashMap<String, String>();
        
        System.out.print("Input file path:");               
        String file2Path = inputLine.nextLine();
        System.out.println("File Path: \"" + file2Path + "\"");
        file.Read(file2Path);
        
        ParserFile parser = new ParserFile(file.getDATA(), task1);
        parser.runParsing();
        
    }
    
}
