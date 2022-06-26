// Christian Jarmon
// Project 2
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;


public class Project2 {

    //Those global variables be poppin.........
    static int N;
    static ArrayList<int[]> intervals;
    static ArrayList<Integer> already_checked_earliest;


    //Is there a pair of intervals still present that conflict?
    public static boolean overlap() {

        /*
         * System.out.println("\n\n-------------");
         * for (int[] a : intervals) {
         * System.out.println(a[0] + " " + a[1] );
         * }
         * System.out.println("-------------\n\n");
         */

        for (int i = 0; i < intervals.size(); i++) {
            for (int j = 0; j < intervals.size(); j++) {
                if (i != j && ((intervals.get(i)[0] < intervals.get(j)[0] && intervals.get(i)[1] > intervals.get(j)[0])
                        || (intervals.get(i)[0] < intervals.get(j)[1] && intervals.get(i)[1] > intervals.get(j)[1]))) {
                
                    return true;
                }
            }
        }

        return false;
    }

    // this function should only be called if a conflict still exists
    //Find the interval with the earie
    public static int findEarliest() {
        int min = Integer.MAX_VALUE;
        int min_finish = Integer.MAX_VALUE;
        int index = -1;
        boolean duplicate_earliest = false;

        for (int i = 0; i < intervals.size(); i++) {

            if (intervals.get(i)[0] == min && !already_checked_earliest.contains(i)) {
                duplicate_earliest = true;
            } else if (intervals.get(i)[0] < min && !already_checked_earliest.contains(i)) {

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

        already_checked_earliest.add(index);

        return index;

    }// end findEarliest

    public static void findCardinality() {
        // int result = N;
        // System.out.println(overlap());
        while (overlap()) {

            int earliest = findEarliest();

            if (earliest == -1) {
                break;
            }
          
            for (int i = 0; i < intervals.size(); i++) {
              
                if (i != earliest) {
                    // if its start OR end time is in between the interval with the earliest its a
                    // conflict
                    if ((intervals.get(earliest)[0] < intervals.get(i)[0]
                            && intervals.get(earliest)[1] > intervals.get(i)[0])
                            || intervals.get(earliest)[0] < intervals.get(i)[1]
                                    && intervals.get(earliest)[1] > intervals.get(i)[1]) {
                      

                        intervals.remove(i);
                      
                        i--;
                      
                    }
                }
            }
        } // end while

        // System.out.println("overlap is: " + overlap() + " ::the earliest is now: " +
        // findEarliest());

        // return result;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        // intervals = new int[N][2];
        intervals = new ArrayList<int[]>();
      
        already_checked_earliest = new ArrayList<Integer>();

        for (int i = 1; i <= N; i++) {
            String[] interval_string = (Files.readAllLines(Paths.get("input.txt")).get(i)).split(" ");
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(interval_string[0]);
            temp[1] = Integer.parseInt(interval_string[1]);
            intervals.add(temp);
        
       
        }

        // System.out.println(already_checked_earliest.size());
        findCardinality();
        System.out.println(intervals.size());

       

    }// main ends

}// class ends


//------------NOTES DURING PROGRAMMING
// need to repeat while no conflicts exist
// add reuslting non-overlapping intervals to a diff array,
// and nuke the ones that overlap with another that is the current earliest

// if (intervals.get(earliest)[0] < intervals.get(i)[0] &&
// intervals.get(earliest)[1] > intervals.get(i)[0])
// if (intervals.get(earliest)[0] < intervals.get(i)[1] &&
// intervals.get(earliest)[1] > intervals.get(i)[1])

