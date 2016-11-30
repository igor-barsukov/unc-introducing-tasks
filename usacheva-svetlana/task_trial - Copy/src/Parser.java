import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by Света on 29.11.2016.
 */
public class Parser {


     static String fileName = "D:/NetCracker/task_trial - Copy/base.dat";
     static List<String> list = new LinkedList<>();

     static ListIterator<String> itr = list.listIterator();
     static Path path = Paths.get(fileName);
    // static String expr;

    public static void readUsingScanner() throws IOException {

        Scanner scanner = new Scanner(path);
        while (scanner.hasNext()){
            list.add(scanner.next());
        }
        itr = list.listIterator();
    }

}
