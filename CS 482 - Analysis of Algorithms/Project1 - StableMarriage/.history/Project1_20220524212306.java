
import java.lang.*;
import java.util.Scanner;
import java.io.*;

public class Project1 {
    public static void main(String[] args) {
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream("input.txt");
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine()); // returns the line that was skipped
                final String line = sc.nextLine();
                 final Scanner lineScanner = new Scanner(line);
                while(lineScanner.hasNextInt()) {
                    System.out.println(lineScanner.nextInt());
                }
            }
            sc.close(); // closes the scanner
            lineScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}