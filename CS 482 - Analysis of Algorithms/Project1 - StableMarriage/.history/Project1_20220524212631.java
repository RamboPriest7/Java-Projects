
import java.lang.*;
import java.util.Scanner;
import java.io.*;

public class Project1 {

    public static void main(String[] args) {
        try {
            
            FileInputStream fis = new FileInputStream("input.txt");
            Scanner sc = new Scanner(fis); // file to be scanned
           
            while (sc.hasNextLine()) {
               // System.out.println(sc.nextLine()); // returns the line that was skipped
                final String line = sc.nextLine();
                 final Scanner lineScanner = new Scanner(line);
                while(lineScanner.hasNextInt()) {
                    System.out.println(lineScanner.nextInt());
                }
                System.out.println();
            }
            sc.close(); // closes the scanner
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}