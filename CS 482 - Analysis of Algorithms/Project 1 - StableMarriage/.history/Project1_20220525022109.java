//Name: Christian Jarmon
//Project: #1 Stable Marriage
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;

public class Project1 {

    static int[][] mensDesire, womensDesire;
    static int[] matchings;
    static int N, notStable = 0;

    public static boolean checkUnstable(int currManID, int currWomanID) {

        if (currWomanID == matchings[currManID - 1]) {
            return false;
        }
        //System.out.println("currManID, currWomanID == " + currManID + " " + currWomanID);
        int pref_of_His_Match = -1, pref_of_Her_Match = -1, pref_of_currMan = -1, pref_of_currWoman = -1;
        int herCurrMatch = -1;

        for (int i = 0; i < N; i++) {
            if (matchings[currManID - 1] == mensDesire[currManID - 1][i]) {
                pref_of_His_Match = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (matchings[i] == currWomanID) {
                herCurrMatch = matchings[i];
                // System.out.println("Matchings[i] " + matchings[i] + " i=>" + i);
            }
        }

        for (int i = 0; i < N; i++) {
            // System.out.println("her Desire " + womensDesire[currWomanID - 1][i]);
            if (herCurrMatch == womensDesire[currWomanID - 1][i]) {
                pref_of_Her_Match = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (currManID == womensDesire[currWomanID - 1][i]) {
                pref_of_currMan = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (currWomanID == mensDesire[currManID - 1][i]) {
                pref_of_currWoman = i;
            }
        }
       // System.out.println( pref_of_currWoman + " " + pref_of_His_Match + " " + pref_of_currMan + " " + pref_of_Her_Match + " ");
        // System.out.println(pref_of_Her_Match);
        return ((pref_of_currWoman < pref_of_His_Match) && (pref_of_currMan < pref_of_Her_Match));

    }// end function

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        mensDesire = new int[N][N];
        womensDesire = new int[N][N];
        matchings = new int[N];
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
                matchings[i - (N * 2)] = Integer.parseInt(temp[1]);
            }
        } // for ends

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (checkUnStable(i, j)) {
                    notStable++;
                }
            }
        }

        System.out.println(notStable);

    }// main ends
}// class ends
