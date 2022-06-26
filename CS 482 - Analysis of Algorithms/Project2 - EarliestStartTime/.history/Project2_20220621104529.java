// Christian Jarmon
// Project 1
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.Arrays;

public class Project2 {

static int[][] intervals;
static int N;



    public static void main(String []args) throws NumberFormatException, IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        intervals = new int[N][2];


    }



}