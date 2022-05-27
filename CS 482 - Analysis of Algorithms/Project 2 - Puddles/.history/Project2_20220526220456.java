
//Name: Christian Jarmon
//Project #2: Puddles
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;

public class Project2 {

    static int puddles;
    static int[][] map;
    static boolean[][] visited;

   
    
    public static void puddles(, int i, int j) {
        if (!(i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] == 1 || visited[i][j])) {
            visited[i][j] = true;

            //up
            puddles( i - 1, j);
            //right
            puddles( i, j + 1);
            //down
            puddles( i + 1, j);
            //left
            puddles( i, j - 1);
        }
        
    }
  

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

        visited = new boolean[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];


        for (int i = 0; i < Integer.parseInt(sizes[0]); i++) {
            for (int j = 0; j < Integer.parseInt(sizes[1]); j++) {
                if (map[i][j] == 0 && !(visited[i][j])) {
                    puddles(map, i, j);
                    puddles++;
                }
            }
        }

        System.out.println(puddles);

    }// main ends
}// class ends

// Stop Case for a Puddle:
// If current column