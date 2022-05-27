
//Name: Christian Jarmon
//Project #2: Puddles
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;

public class Project2 {

    static int puddles;
    static int[][] map;
    static boolean runtime_check = true;

    // --------------------------------
    public static void countPuddles(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0 && visited[i][j] == false) {
                    puddles(map, i, j, visited);
                    puddles++;
                }
            }
        }
        
    }

    public static void puddles(int[][] map, int i, int j, boolean[][] visited) {
        if (!(i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] == 1 || visited[i][j] == true)) {
            visited[i][j] = true;
            // Travel in all direction: north, east, south and west.

            //up
            puddles(map, i - 1, j, visited);// North
            //right
            puddles(map, i, j + 1, visited);// East
            //down
            puddles(map, i + 1, j, visited);
            //left
            puddles(map, i, j - 1, visited);
        }
        
    }
    // --------------------------------

    public static void main(String[] args) throws IOException {
        String[] sizes = Files.readAllLines(Paths.get("input.txt")).get(0).split(" ");
        map = new int[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];

        String[] vals = new String[Integer.parseInt(sizes[0])];
        for (int i = 1; i < Integer.parseInt(sizes[0]) + 1; i++) {
            vals[i - 1] = Files.readAllLines(Paths.get("input.txt")).get(i);
        }

        for (int i = 0; i < Integer.parseInt(sizes[0]); i++) {
            String[] temp = new String[Integer.parseInt(sizes[1])];
            temp = vals[i].split(" ");
            for (int j = 0; j < Integer.parseInt(sizes[1]); j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        System.out.println(puddles);

    }// main ends
}// class ends

// Stop Case for a Puddle:
// If current column