
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;

public class Project1 {

    static int[][] mensDesire, womensDesire, matchings;
    static int N, notStable = 0;



    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        mensDesire = new int[N][N];
        womensDesire = new int[N][N];
        matchings = new int[N][2];
        String [] vals = new String[N*3];
        for (int i = 1; i <= (N*3); i++) {
            vals[i-1] = Files.readAllLines(Paths.get("input.txt")).get(i);
        }

        for (int i = 0; i < (N); i++) {
            String [] temp = new String [N];
            temp = vals[i].split(" ");
            for (int j = 0; j < (N); j++) {
           mensDesire[i][j] = Integer.parseInt(temp[j]);
        } 
         }//for ends
      
         for (int i = N; i < (N*2); i++) {
            String [] temp = new String [N];
            temp = vals[i].split(" ");
            for (int j = 0; j < (N); j++) {
           womensDesire[i-N][j] = Integer.parseInt(temp[j]);
        } 
         }//for ends
      
         for (int i = N*2; i < (N*3); i++) {
            String [] temp = new String [N];
            temp = vals[i].split(" ");
            for (int j = 0; j < (2); j++) {
           matchings[i-(N*2)][j] = Integer.parseInt(temp[j]);
        } 
         }//for ends
      
//lets say we are on man #3 and woman #2
//they would both switch if 
//mensDesire[3][0] == 2 and womensDesire[2][0] == 3
//in interation, if i and j equal and already existing matching, skip it

for (int i = 1; i <= N; i++) {
    for (int q = 0; q < N; q++) {
        if (matchings)
    }
    for (int j = 1; j <= N; j++) {
        if (j != matchings[i-1][1]) {
            //System.out.println( i + " " + j);
            //System.out.println( "Unstable Check: " + i + " " + j);
            //System.out.println( "In Array: " + mensDesire[i-1][0] + " " + womensDesire[j-1][0]);
           // if (mensDesire[i-1][0] == j && womensDesire[j-1][0] == i) {
           //     notStable++;
           // }

        }
    } 
} 

System.out.println("Instabilities: " + notStable);
 
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