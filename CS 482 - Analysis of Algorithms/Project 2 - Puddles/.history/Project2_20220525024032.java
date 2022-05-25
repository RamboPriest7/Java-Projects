//Name: Christian Jarmon
//Project: #1 Stable Marriage
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;

public class Project2 {

    static int puddles;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        String[]sizes = Files.readAllLines(Paths.get("input.txt")).get(0).split(" ");
        map = new int[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
        
        System.out.println(puddles);

    }// main ends
}// class ends
