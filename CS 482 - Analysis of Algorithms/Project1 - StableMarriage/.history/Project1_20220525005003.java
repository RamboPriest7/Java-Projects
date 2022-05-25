
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;

public class Project1 {

    static int[][] mensDesire, womensDesire, matchings;
    static int N, notStable = 0;

public static boolean checkStable(int currManIndex, int currWomanIndex) {
    //cwi would switch if cmi was lower than the index of her current match
    //cmi would switch if cwi was lower then the index of his current match

 //find index, wm, of cmi's current match in matchings
 //find index, mm, of cwi's current match in matchings
    
//return false if wm == matchings[cmi][1]

 //if mm < cmi && wm < cwi -> unstable

 int wm, mm;

 for (int )


}


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        mensDesire = new int[N][N];
        womensDesire = new int[N][N];
        matchings = new int[N][2];
        String[] vals = new String[N * 3];
        for (int i = 1; i <= (N * 3); i++) {
            vals[i - 1] = Files.readAllLines(Paths.get("input.txt")).get(i);
        }

        for (int i = 0; i < (N); i++) {
            String[] temp = new String[N];
            temp = vals[i].split(" ");
            for (int j = 0; j < (N); j++) {
                mensDesire[i][j] = Integer.parseInt(temp[j]);
            }
        } // for ends

        for (int i = N; i < (N * 2); i++) {
            String[] temp = new String[N];
            temp = vals[i].split(" ");
            for (int j = 0; j < (N); j++) {
                womensDesire[i - N][j] = Integer.parseInt(temp[j]);
            }
        } // for ends

        for (int i = N * 2; i < (N * 3); i++) {
            String[] temp = new String[N];
            temp = vals[i].split(" ");
            for (int j = 0; j < (2); j++) {
                matchings[i - (N * 2)][j] = Integer.parseInt(temp[j]);
            }
        } // for ends

       
           


        System.out.println("Instabilities: " + notStable);

    }// main ends
}// class ends

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

 /*
  // finding instability for current CURRMAN
        for (int CURRMAN = 1; CURRMAN < N; CURRMAN++) {
            int currMMI = -1, currWMI = -1;
            // Find index of woman that CURRMAN is matched to.
            for (int i = 0; i < N; i++) {
                if (mensDesire[CURRMAN-1][i] == matchings[CURRMAN-1][1]) {
                    currMMI = i;
                    break;
                }
            }

            // Find index of CURRMAN that curr woman is matched to.

            for (int CURRWOMAN = 1; CURRWOMAN < N; CURRWOMAN++) {
                for (int j = 0; j < N; j++) {
                   if (womensDesire[CURRWOMAN-1][j] == CURRMAN) {
                       currWMI = j;
                       break;
                   }
                }

                

            }
*/