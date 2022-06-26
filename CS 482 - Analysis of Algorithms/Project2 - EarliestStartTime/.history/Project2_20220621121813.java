
// Christian Jarmon
// Project 1
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Project2 {

    //static int[][] intervals;
    static boolean[] is_conflict, already_checked_earliest;
    static int N;

    static ArrayList<int[]> intervals;

    public static boolean overlap() {
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = 0; j < N; j++) {
                if (intervals.get(j)[0] < intervals.get(i)[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    // this function should only be called if a conflict still exists
    public static int findEarliest() {
        int min = Integer.MAX_VALUE;
        int min_finish = Integer.MAX_VALUE;
        int index = -1;
        boolean duplicate_earliest = false;


        for (int i = 0; i < intervals.size(); i++) {

            
                if (intervals.get(i)[0] == min && i != index) {
                    duplicate_earliest = true;
                } else if (intervals.get(i)[0] < min) {

                  
                        index = i;
                        min = intervals.get(i)[0];
                    
                }
            } // end for loop
        

        if (duplicate_earliest) {
            for (int i = 0; i < N; i++) {
                if (intervals.get(i)[1] < min_finish) {
                    min_finish = intervals.get(i)[1];
                    index = i;
                }
            } // end for loop
        } // end if

        already_checked_earliest[index] = true;
        return index;

    }// end findEarliest

    public static void findCardinality() {
       // int result = N;
        //System.out.println(overlap());
     while (overlap())  { 
        int earliest = findEarliest();
        for (int i = 0; i < intervals.size(); i++) {
            if (i != earliest) {
                if (intervals.get(i)[0] < intervals.get(earliest)[1]
                        || (intervals.get(i)[1] > intervals.get(earliest)[0] && intervals.get(i)[0] < intervals.get(earliest)[0])) {
                     System.out.println((intervals.get(i)[0] < intervals.get(earliest)[1]) + " " +
                     intervals.get(i)[0] + " " + intervals.get(earliest)[1]);
                    // result--;

                    intervals.remove(i);
                    //System.out.println(intervals.size());
                    //result--;
                }
            }
        }
    }//

        //return result;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        //intervals = new int[N][2];
        intervals = new ArrayList<int[]>();
        is_conflict = new boolean[N];
        already_checked_earliest = new boolean[N];


    

        for (int i = 1; i <= N; i++) {
            String[] interval_string = (Files.readAllLines(Paths.get("input.txt")).get(i)).split(" ");
            int [] temp = new int[2];
            temp[0] = Integer.parseInt(interval_string[0]);
            temp[1] = Integer.parseInt(interval_string[1]);
            intervals.add(temp);
           // interval[i - 1][0] = Integer.parseInt(interval_string[0]);
            //intervals[i - 1][1] = Integer.parseInt(interval_string[1]);
            is_conflict[i - 1] = false;
            already_checked_earliest[i - 1] = false;
        }

        

        //System.out.println(findEarliest());
        findCardinality();
        System.out.println(intervals.size());

        // for (int[] a : intervals) {
        // for (int b : a) {
        // System.out.println(b + " ");
        // }
        // System.out.println();
        // }

    }// main ends

}// calss ends

// need to repeat while no conflicts exist
// add reuslting non-overlapping intervals to a diff array,
// and nuke the ones that overlap with another that is the current earliest


