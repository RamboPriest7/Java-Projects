// Christian Jarmon
// Project 2
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;

public class Project2 {

    // Those global variables be poppin.........
    static int N;
    static ArrayList<int[]> intervals;
    static ArrayList<int[]> already_checked_earliest;

    // Is there a pair of intervals still present that conflict?
    public static boolean overlap() {

        /*
         * System.out.println("\n\n-------------");
         * for (int[] a : intervals) {
         * System.out.println(a[0] + " " + a[1] );
         * }
         * System.out.println("-------------\n\n");
         */


        /* if there is a pair of intervals that conflict, this function should return true */
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = 0; j < intervals.size(); j++) {
                if (i != j && ((intervals.get(i)[0] <= intervals.get(j)[0] && intervals.get(i)[1] > intervals.get(j)[0])
                        || (intervals.get(i)[0] < intervals.get(j)[1] && intervals.get(i)[1] >= intervals.get(j)[1]))) {

                    return true;
                }
            }
        }

        return false;
    }

    // this function should only be called if a conflict still exists
    // Find the interval with the earliest start time.
    // If there are two intervals with the same earliest start, picked the one that
    // finishes first
    public static int findEarliest() {
        int min_start = Integer.MAX_VALUE; 
        int min_finish = Integer.MAX_VALUE;
        int index = -1;
        boolean duplicate_earliest = false;


        /* find smallest start time using elementary linear method */

        for (int i = 0; i < intervals.size(); i++) {

            if (intervals.get(i)[0] == min_start && !already_checked_earliest.contains(intervals.get(i))) {

                duplicate_earliest = true;

            } else if (intervals.get(i)[0] < min_start && !already_checked_earliest.contains(intervals.get(i))) {

                index = i;
                /* if the earliest start changes, reset this boolean as it was only true for a previous tentative earliest */
                duplicate_earliest = false; 
               
                min_start = intervals.get(i)[0];

            }
        } // end for loop


        /* Break ties using by finding earliest finish if there is an earliest start tie */
        if (duplicate_earliest) {

            for (int i = 0; i < N; i++) {
                if (intervals.get(i)[1] < min_finish && intervals.get(i)[0] == min_start) {
                    min_finish = intervals.get(i)[1];
                    index = i;
                }
            } // end for loop
        } // end if

        already_checked_earliest.add(intervals.get(index));

        return index;

    }// end findEarliest

    // Self explanatory
    /*  For every interval, if there exists another interval b such that 
    *   the start time or end time of b is between the the start and end of a, 
    *   that is a conflict, therefore remove it.     
    */ 
    public static void removeConflicts() {

        while (overlap()) {

            /* Index of earliest interval in list of intervals */
            int earliest = findEarliest();

            for (int i = 0; i < intervals.size(); i++) {

                if (i != earliest) {
                    // if its start OR end time is in between the interval with the earliest its a
                    // conflict
                    if ((intervals.get(earliest)[0] <= intervals.get(i)[0]
                            && intervals.get(earliest)[1] > intervals.get(i)[0])
                            || (intervals.get(earliest)[0] < intervals.get(i)[1]
                                    && intervals.get(earliest)[1] >= intervals.get(i)[1])) {

                        /*
                         * Remove an interal that conflicts with the interval with earliest start (or
                         * finish if there was a tie)
                         */
                        /*
                         * If the earliest had an index bigger than the one that got removed,
                         * decremement earliest so it still points to the same item in the array
                         */
                        /* also decrement i for the same reason */
                        intervals.remove(i);
                        if (i < earliest) {
                            earliest--;
                        }
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
        intervals = new ArrayList<int[]>();
        already_checked_earliest = new ArrayList<int[]>();

        for (int i = 1; i <= N; i++) {
            String[] interval_string = (Files.readAllLines(Paths.get("input.txt")).get(i)).split(" ");
            intervals.add(new int[] { Integer.parseInt(interval_string[0]), Integer.parseInt(interval_string[1]) });
        }

        removeConflicts();
        System.out.println(intervals.size());

    }// main ends

}// class ends

// ------------NOTES DURING PROGRAMMING
// need to repeat while no conflicts exist
// add reuslting non-overlapping intervals to a diff array,
// and nuke the ones that overlap with another that is the current earliest

// if (intervals.get(earliest)[0] < intervals.get(i)[0] &&
// intervals.get(earliest)[1] > intervals.get(i)[0])
// if (intervals.get(earliest)[0] < intervals.get(i)[1] &&
// intervals.get(earliest)[1] > intervals.get(i)[1])