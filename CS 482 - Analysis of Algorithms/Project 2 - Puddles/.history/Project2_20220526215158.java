
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
    public static void countPuddles(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && visited[i][j] == false) {
                    puddles(grid, i, j, visited);
                    puddles++;
                }
            }
        }
        
    }

    public static void puddles(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1 || visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        // Travel in all direction: north, east, south and west.
        puddles(grid, i - 1, j, visited);// North
        puddles(grid, i, j + 1, visited);// East
        puddles(grid, i + 1, j, visited);// South
        puddles(grid, i, j - 1, visited);// West
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

        System.out.println(countPuddles(map));

    }// main ends
}// class ends

// Stop Case for a Puddle:
// If current column