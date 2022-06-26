
// Christian Jarmon
// Project 1
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.Arrays;

public class Project2 {

    static int[][] intervals;
    static int N;


public static int findEarliest() {
    int min = Integer.MAX_VALUE;
    int min_finish = Integer.MAX_VALUE;
    int index = -1;
    boolean duplicate_earliest = false;

    for (int i = 0; i < N; i++ ) {

if (intervals[i][0] == min) {
duplicate_earliest = true;
} else if (intervals[i][0] < min) {
            index = i;
            min = intervals[i][0];
        }
    }//end for loop


if (duplicate_earliest) {
    for (int i = 0; i < N; i++ ) { 
        if (intervals[i][1] < min_finish ) {
            min_finish = intervals[i][1];
            index = i;
        }
    }//end for loop
}//end if


return index;

}//end findEarliest

    public static int findCardinality() {
        int result = N;
        int earliest = findEarliest();
        for (int i = 0; i < N; i++) {
            if (i !=earliest) {
                if (intervals[i][0] < intervals[earliest][1] || (intervals[i][1] > intervals[earliest][0] && )) {
                    result--;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        intervals = new int[N][2];

        for (int i = 1; i <= N; i++) {
            String[] interval_string = (Files.readAllLines(Paths.get("input.txt")).get(i)).split(" ");

            intervals[i - 1][0] = Integer.parseInt(interval_string[0]);
            intervals[i - 1][1] = Integer.parseInt(interval_string[1]);

        }

        
System.out.println(findCardinality());


        // for (int[] a : intervals) {
        //     for (int b : a) {
        //         System.out.println(b + " ");
        //     }
        //     System.out.println();
        // }

    }// main ends

}// calss ends