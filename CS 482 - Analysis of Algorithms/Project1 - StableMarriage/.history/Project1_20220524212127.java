
import java.lang.*;
import java.util.Scanner;
import java.io.*;

public class Project1 {
    public static void main(String[] args) {
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream("Demo.txt");
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine()); // returns the line that was skipped
              //  final String line = scan.nextLine();
//final Scanner lineScanner = new Scanner(line);
while(lineScanner.hasNextInt()) {
    oak.add(lineScanner.nextInt());
}
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}