
//Name: Christian Jarmon
//Project #2: Puddles
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;


public class Project2 {

    static int puddles;
    static int[][] map;
    static boolean[][] visited;

    public static void puddles(int i, int j) {
        //cant be negative or more than the amount of rows and cols, has to be inside grid
        //if the shit is not an island, forget about it
        if (!(i < 0 || j < 0 || i >= map.length || j >= map[0].length || map[i][j] != 0 || visited[i][j])) {
            
            visited[i][j] = true;

            //need to mark all the adjacent indices to prevent double counting


            // up
            puddles(i - 1, j);
            // down
            puddles(i + 1, j);


            // left
            puddles(i, j - 1);
            // right
            puddles(i, j + 1);
            
            //if diagonal puddles counted
            //puddles(i+1, j+1);
            //puddles(i-1, j-1);
        }

    }

    public static void main(String[] args) throws IOException {
        String[] sizes = Files.readAllLines(Paths.get("input.txt")).get(0).split(" ");
        map = new int[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
        visited = new boolean[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];


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

        

        for (int i = 0; i < Integer.parseInt(sizes[0]); i++) {
            for (int j = 0; j < Integer.parseInt(sizes[1]); j++) {
                if (map[i][j] == 0 && !(visited[i][j])) {
                    //if we need another puddle and its not visited add another one, call the puddles function to mark adjacent indices
                    puddles(i, j);
                    puddles++;
                }
            }
        }

        System.out.println(puddles);

    }// main ends


}// class ends

