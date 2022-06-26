// Christian Jarmon
// Project 1
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.Arrays;

public class Project2 {

static int[][] intervals;
static int N;


public static int findCardinality() {
    int result = N;
    return result;
}


    public static void main(String []args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        intervals = new int[N][2];

        for (int i = 1; i <= N; i++) {
            String[] interval_string = (Files.readAllLines(Paths.get("input.txt")).get(i)).split(" ");
            
            intervals[N-1][0] = Integer.parseInt(interval_string[0]);
            intervals[N-1][1] = Integer.parseInt(interval_string[1]);
           
        }
        
 for (int i = 0;i < N; i++)


    }//am



}