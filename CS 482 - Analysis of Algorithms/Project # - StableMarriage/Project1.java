
//Name: Christian Jarmon
//Project #1: Stable Marriage
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class Project1 {

    static int[][] mensDesire, womensDesire;
    static int[] matchings;
    static int N, notStable = 0;
    static int[] menEng, womenEng;
    static int[] menDisEng;
    // use menDisEng to rid of women that were already proposed to
    // if a woman was already proposed to, skip it

    public static boolean allEng() {
        for (int i = 0; i < N; i++) {
            if (womenEng[i] == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean wws(int man, int woman) {
        int index_of_man = -1, index_of_womans_match = -1;

        // herCurrMatch => womensEng[woman-1]

        if (womenEng[woman - 1] == -1) {
            // menEng[womenEng[woman - 1] - 1] = -1;
            womenEng[woman - 1] = man;
            menEng[man - 1] = woman;

            // menDisEng[man-1] = woman;
            return false;
        }

        if (menDisEng[man - 1] == woman) {
            return false;
        }

        for (int i = 0; i < N; i++) {
            if (man == womensDesire[woman - 1][i]) {
                index_of_man = i;
            }
            if (womenEng[woman - 1] == womensDesire[woman - 1][i]) {
                index_of_womans_match = i;
            }
        }

        return (index_of_man < index_of_womans_match);
    }

    public static void proposeDispose() {
        for (int m = 1; m <= N; m++) {
            for (int w = 1; w <= N; w++) {
                if (wws(m, w)) {
                    if (womenEng[w - 1] != -1) {
                        menDisEng[womenEng[w - 1] - 1] = w;
                        menEng[womenEng[w - 1] - 1] = -1;
                    }
                    womenEng[w - 1] = m;
                    menEng[m - 1] = w;

                }
            }
        }
    }

    public static boolean checkUnstable(int currManID, int currWomanID) {

        if (currWomanID == matchings[currManID - 1]) {
            return false;
        }
        // System.out.println("currManID, currWomanID == " + currManID + " " +
        // currWomanID);
        int pref_of_His_Match = -1, pref_of_Her_Match = -1, pref_of_currMan = -1, pref_of_currWoman = -1;
        int herCurrMatch = -1;

        for (int i = 0; i < N; i++) {
            if (matchings[currManID - 1] == mensDesire[currManID - 1][i]) {
                pref_of_His_Match = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (matchings[i] == currWomanID) {
                herCurrMatch = i + 1;
                // System.out.println("CurrWoman " + currWomanID + " " + "Matchings[i] " +
                // matchings[i] + " i=>" + (i+1));
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

        // System.out.println( pref_of_currWoman + " " + pref_of_His_Match + " " +
        // pref_of_currMan + " " + pref_of_Her_Match + " ");
        // System.out.println(pref_of_Her_Match);
        return ((pref_of_currWoman < pref_of_His_Match) && (pref_of_currMan < pref_of_Her_Match));

    }// end function

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        mensDesire = new int[N][N];
        womensDesire = new int[N][N];
        matchings = new int[N];
        menEng = new int[N];
        womenEng = new int[N];
        menDisEng = new int[N];
        for (int i = 0; i < (N); i++) {
            menEng[i] = -1;
            womenEng[i] = -1;
        }
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
            matchings[i - (N * 2)] = Integer.parseInt(temp[1]);

        } // for ends

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (checkUnstable(i, j)) {
                    notStable++;
                }
            }
        }

        System.out.println(notStable);

        while (!allEng()) {
            proposeDispose();
            for (int m = 1; m <= N; m++) {
                System.out.println("Man #" + womenEng[m - 1] + " :: Woman #" + m);
                // System.out.println("Woman #" + m + " :: Man #" + womenEng[m - 1]);
                System.out.println();
            }
            System.out.println("-----------------");
        }
        // for (int m = 1; m <= N; m++) {
        // System.out.println("Man #" + m + " :: Woman #" + menEng[m - 1]);
        // }

    }// main ends
}// class ends
