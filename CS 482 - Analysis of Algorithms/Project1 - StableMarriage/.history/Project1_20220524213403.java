
import java.lang.*;
import java.util.Scanner;
import java.io.*;

public class Project1 {


    int[][] mensDesire, womensDeisre, matchings;
    int N;
    public static void main(String[] args) {
      System.out.println(Files.readAllLines(Paths.get("myfile.txt")).get(1)); 
    }
}

/* 
try {
            
            FileInputStream fis = new FileInputStream("input.txt");
            Scanner sc = new Scanner(fis); 
           
            while (sc.hasNextLine()) {
    
                final String line = sc.nextLine();
                final Scanner lineScanner = new Scanner(line);
                while(lineScanner.hasNextInt()) {
                    System.out.println(lineScanner.nextInt());
                }
                System.out.println();
            }
            sc.close(); 
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        */