
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;

public class Project1 {

    static int[][] mensDesire, womensDeisre, matchings;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        mensDesire = new int[N][N];
        womensDeisre = new int[N][N];
        matchings = new int[N][2];
        String [] vals = new String[N*3];
        for (int i = 1; i <= (N*3); i++) {
            vals[i-1] = Files.readAllLines(Paths.get("input.txt")).get(i);
        }

        for (int i = 0; i < (N); i++) {
            String [] temp = new String [N];
            temp = vals[i].split(" ");
            S
        }








    }//main ends
}//class ends

/*
 * try {
 * 
 * FileInputStream fis = new FileInputStream("input.txt");
 * Scanner sc = new Scanner(fis);
 * 
 * while (sc.hasNextLine()) {
 * 
 * final String line = sc.nextLine();
 * final Scanner lineScanner = new Scanner(line);
 * while(lineScanner.hasNextInt()) {
 * System.out.println(lineScanner.nextInt());
 * }
 * System.out.println();
 * }
 * sc.close();
 * 
 * } catch (IOException e) {
 * e.printStackTrace();
 * }
 */