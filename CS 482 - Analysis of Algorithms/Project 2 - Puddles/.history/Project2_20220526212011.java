//Name: Christian Jarmon
//Project #2: Puddles
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;

public class Project2 {

    static int puddles;
    static int[][] map;
    

    public static boolean checkConnection(int[] a, int[] b) {
        ArrayList<Integer> z = new ArrayList<Integer>(), x = new ArrayList<Integer>();
 for (int i =0; i < a.length;i++) {
     if (a[i] == 0) {z.add(i);}
 }




 for (int i =0; i < a.length;i++) { 
    if (b[i] == 0) {z.add(i);
        if (z.contains(i))      }

 }
    }//end function


    public static void main(String[] args) throws IOException {
        String[]sizes = Files.readAllLines(Paths.get("input.txt")).get(0).split(" ");
        map = new int[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
        
        String [] vals = new String[Integer.parseInt(sizes[0])];
        for (int i = 1; i < Integer.parseInt(sizes[0])+1; i++) {
           vals[i-1] = Files.readAllLines(Paths.get("input.txt")).get(i);
        }

        for (int i = 0; i < Integer.parseInt(sizes[0]); i++) {
            String[] temp = new String[Integer.parseInt(sizes[1])];
            temp = vals[i].split(" ");
            for (int j = 0; j < Integer.parseInt(sizes[1]); j++){
                map[i][j] =  Integer.parseInt(temp[j]);
            }
        }
       
        System.out.println(checkConnection(a,b));


        System.out.println(puddles);

    }// main ends
}// class ends

//Stop Case for a Puddle:
        //If current column 