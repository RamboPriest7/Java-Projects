
// Christian Jarmon
// Project 1
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Project2 {

    // static int[][] intervals;
    static boolean[] is_conflict;// , already_checked_earliest;
    static int N;

    static ArrayList<int[]> intervals;
    static ArrayList<Boolean> already_checked_earliest;






    public static boolean overlap() {
        /* 
        System.out.println("\n\n-------------");
        for (int[] a : intervals) {
                         System.out.println(a[0] + " " + a[1] );
                         }
                         System.out.println("-------------\n\n"); */


        for (int i = 0; i < intervals.size(); i++) {
            for (int j = 0; j < intervals.size(); j++) {
                if (i != j && ((intervals.get(i)[0] < intervals.get(j)[0] && intervals.get(i)[1] > intervals.get(j)[0])
                        || (intervals.get(i)[0] < intervals.get(j)[1] && intervals.get(i)[1] > intervals.get(j)[1]))) {
                    //System.out.println(intervals.get(j)[0] + " " + intervals.get(i)[1]);
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

        if (already_checked_earliest.get(index)) {
            index = -1;
        }
        if (index != -1) {
            already_checked_earliest.set(index, true);
        }

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
            System.out.println("Still goin...");
            System.out.println(earliest + " -- ");
            for (int i = 0; i < intervals.size(); i++) {
                System.out.println("stuff is happening");
                if (i != earliest) {
                    // if its start OR end time is in between the interval with the earliest its a
                    // conflict
                    if ((intervals.get(earliest)[0] < intervals.get(i)[0]
                            && intervals.get(earliest)[1] > intervals.get(i)[0])
                            || intervals.get(earliest)[0] < intervals.get(i)[1]
                                    && intervals.get(earliest)[1] > intervals.get(i)[1]) {
                        // intervals.get(earliest)[0] < intervals.get(i)[0] &&
                        // intervals.get(earliest)[1] > intervals.get(i)[0]
                        // System.out.println((intervals.get(i)[0] < intervals.get(earliest)[1]) + " " +
                        // intervals.get(i)[0] + " " + intervals.get(earliest)[1]);
                        // result--;

                        intervals.remove(i);
                        already_checked_earliest.remove(i);
                                        System.out.println("something was removed");
                        // for (int[] a : intervals) {
                        // System.out.println(a[0] + " " + a[1] );
                        // }
                        // System.out.println(intervals.size());
                        // result--;
                    }
                }
            }
        } // end while


System.out.println("overlap is: "  + overlap() + " ::the earliest is now: " + findEarliest());

        // return result;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        // intervals = new int[N][2];
        intervals = new ArrayList<int[]>();
        is_conflict = new boolean[N];
        already_checked_earliest = new ArrayList<Boolean>();

        for (int i = 1; i <= N; i++) {
            String[] interval_string = (Files.readAllLines(Paths.get("input.txt")).get(i)).split(" ");
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(interval_string[0]);
            temp[1] = Integer.parseInt(interval_string[1]);
            intervals.add(temp);
            // interval[i - 1][0] = Integer.parseInt(interval_string[0]);
            // intervals[i - 1][1] = Integer.parseInt(interval_string[1]);
            is_conflict[i - 1] = false;
            already_checked_earliest.add(false);
        }

        // System.out.println(already_checked_earliest.size());
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

// if (intervals.get(earliest)[0] < intervals.get(i)[0] &&
// intervals.get(earliest)[1] > intervals.get(i)[0])
// if (intervals.get(earliest)[0] < intervals.get(i)[1] &&
// intervals.get(earliest)[1] > intervals.get(i)[1])


//for some reason the findCard function is terminating even tho the function still returns true

//the overlap functions call findEarliest twice, resetting the return value and doesnt remove 4, 5
//we must have a function 