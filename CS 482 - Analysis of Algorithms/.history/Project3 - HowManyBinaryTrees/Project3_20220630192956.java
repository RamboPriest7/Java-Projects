// Christian Jarmon
// Project 3 


public class Project3 {
    static int N;
    static ArrayList<BigInteger> amt_of_trees;

    public static void findAmountOfTrees(int number_of_nodes) {
        for (int N = 1; N <= number_of_nodes; N++) {
            //System.out.println(N);
            BigInteger current_count = BigInteger.valueOf(0);

            if (N % 2 == 0) {
                /* If the amount of nodes are even, there exists 2 sets of trees
                 * that are derived by making a tree with N as the head and successive
                 * LEFT subtrees of N-1...1 (the first tree below).
                 * There exists N/2 trees which are mirror images of each other.
                 * Mirror images meaning the depth of the subtrees
                 * For example, if there are N=4 nodes,
                 * 2 of the trees will be the first right rotation plus the initial tree
                 *
                 *          4             3                 2                    1
                 *         /             / \               / \                    \
                 *        3             2   4             1   3                    2
                 *       /      ==>>   /           ==>>        \        ==>>        \
                 *      2             1                         4                    3
                 *     /                                                              \
                 *    1                                                                4
                 *
                 * The total of amount of trees that can be produced from this derivation is N-1 (so 3 rotations for N=4)
                 *
                 * Notice how the 1st & 4th and the 2nd & 3rd trees are mirror images in terms of subtree depth.
                 *
                 * Once the first N/2 trees have the possible trees calculated,
                 * that value can be taken and multipled by 2 as the right 2 trees will have the same values
                 * 
                 * The amount of possible trees for when N is the head is:
                 * The amount of possible trees for the number of nodes in its left and right 
                 * subtree depth.
                 * For the first tree, there is 3 nodes on the left subtree and 0 on the right subtree
                 *
                 * Make use of the counting principle. 
                 * For 3 nodes, there are 5 possible tree (which would be calculated before this), 
                 * for 0 there is only 1, the empty tree
                 * That means there are 5 * 1 possible trees for the FIRST tree.
                 *
                 * The next will be the amount of trees for
                 * 2 nodes * 1 node ==> 2 possible tree (the second tree) and so on.....
                 *
                 *
                 * Do the above calculation for the first half rotations (N-1..(N/2 + 1) as the head).
                 *
                 */


                int m = N - 1, k = N - 1 - m;
                /* m = Count of left subtree depth, k = Count of right subtree depth */
                /* m decreases by 1 after 1 right rotation, k increases by 1. */
                /* Subtract 1 from N to exclude root */


                for (int i = 0; i < (N / 2); i++) {
                    current_count = current_count.add((amt_of_trees.get(m).multiply(amt_of_trees.get(k))));
                    m--;
                    k++;
                }
                current_count = current_count.add(current_count);
                /* Possible trees of first N/2 rotations multiplied by 2*/

            } else {
                /* If the amount of nodes are odd, there exists 2 sets of trees
                 * each of the amount (N-1)/2 which are mirror images of each other
                 * in terms of subtree depth
                 * Almost the same as the Even N case, however there is a middle
                 * tree which has a unique set of values
                 * For example, if there are N=5 nodes,
                 * 2 of the trees will be the first 2 right rotations
                 *
                 *            5                4                   3                      2                        1
                 *           /                / \                 / \                    / \                        \
                 *          4                3   5               2   4                  1   3                        2
                 *         /                /                   /     \                      \                        \
                 *        3                2                   1       5                      4                        3
                 *       /       ==>>     /            ==>>                    ==>>            \        ==>>            \
                 *      2                1                                                      5                        4
                 *     /                                                                                                  \
                 *    1                                                                                                    5
                 *
                 * Notice how the 1st & 5th and the 2nd & 4rd trees are mirror images in terms of subtree depth.
                 *
                 * Once the first (N-1)/2 trees have the possible trees calculated,
                 * that value can be taken and multipled by 2 as the right 2 trees will have the same values
                 *
                 * Now, diverging from the Even N case, we must take the amount of possible trees for ((N-1)/2) nodes and add its square,
                 * which is the middle tree.
                 *
                 *
                */


                int m = N - 1, k = N - 1 - m;
                /* m = Count of left subtree depth, k = Count of right subtree depth */
                /* m decreases by 1 after 1 right rotation, k increase by 1. */


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

    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        amt_of_trees = new ArrayList<BigInteger>();
        amt_of_trees.add(BigInteger.valueOf(1)); /* amt_of_trees.get(0) => 1 */

        /* Base case: Amount of trees for N nodes will be calculated
        *  via an amalgamation of amounts of trees for N-1.....1 Nodes
        *  For N = 1, it should return 1 but it must be calculated by the function
        *  using the first element.
        */

        findAmountOfTrees(N);

        System.out.println(amt_of_trees.get(N));

    }

}
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;