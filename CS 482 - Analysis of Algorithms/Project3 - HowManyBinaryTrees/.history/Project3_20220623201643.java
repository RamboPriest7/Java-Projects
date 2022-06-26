
// Christian Jarmon
// Project 3 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Project3 {
    static int N;
    static ArrayList<BigInteger> amt_of_trees;


    public static void findAmountOfTrees(int N) {

        BigInteger current_count = BigInteger.valueOf(0);

        if (N % 2 == 0) {

            int m = N - 1, k = N - 1 - m;
            for (int i = 0; i < (N / 2); i++) {
                current_count = current_count.add((amt_of_trees.get(m).multiply(amt_of_trees.get(k))));
                m--;
                k++;
            }
            current_count = current_count.add(current_count);

        } else {

            int m = N - 1, k = N - 1 - m;
            for (int i = 0; i < ((N - 1) / 2); i++) {
                current_count = current_count.add(amt_of_trees.get(m).multiply(amt_of_trees.get(k)));
                m--;
                k++;
            }

            current_count = current_count.add(current_count);
            current_count = current_count.add((amt_of_trees.get(m).multiply(amt_of_trees.get(m))));

        }

        amt_of_trees.add(current_count);

    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        amt_of_trees = new ArrayList<BigInteger>();
        amt_of_trees.add(BigInteger.valueOf(1));

        for (int a = 1; a <= N; a++) {
            findAmountOfTrees(a);
        }
a
        System.out.println(amt_of_trees.get(N));

    }

}