
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
    //static ArrayList<Trees> amt_of_trees;

    static class BST implements Cloneable{
        public int value;
        public BST left;
        public BST right;

        public BST(int a) {
            this.value = a;
            this.left = null;
            this.right = null;
        }

        public BST bruteForceCopy() {
            BST ret = new BST(this.value);

            if (this.left != null) {
                ret.left.bruteForceCopy();
            }

            if (this.right != null) {
                ret.right.bruteForceCopy();
            }

            return ret;
        }

        public boolean has(BST tree) {
            return (tree != null);
        }

        public BST addNode(int a) {
            if (this.value < a) {
                if (this.right != null) {
                    return this.right.addNode(a);
                } else {
                    this.right = new BST(a);
                }
            } else if (this.value > a) {
                if (this.left != null) {
                    return this.left.addNode(a);
                } else {
                    this.left = new BST(a);
                }
            }

            return this;
        }// end addNode

        public BST rotateRight() throws CloneNotSupportedException {
            BST ret = (BST)this.clone();
            ret.left.right = new BST(ret.value);

            ret.left.right.right = ret.right;

            ret = ret.left;

            return ret;

        }// end rotate

        public BST rotateLeft() throws CloneNotSupportedException{
        BST ret = (BST)this.clone();

            // this.value = 1000;
            // ret.print();
            // this.print();
            // System.out.println("--------------------------------");

            // ret.value = 2000;
              //ret.print();
            // this.print();
           
            ret.right.left = new BST(ret.value);
            ret.right.left.left = ret.left;
            ret = ret.right;


           

            return ret;

        }// end rotate

        /////////////////////////////////////////////////////////////////////////////////////
        public String traversePreOrder(BST root) {

            if (root == null) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            sb.append(root.value);

            String pointerRight = "└──";
            String pointerLeft = (root.right != null) ? "├──" : "└──";

            traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
            traverseNodes(sb, "", pointerRight, root.right, false);

            return sb.toString();
        }

        public void traverseNodes(StringBuilder sb, String padding, String pointer, BST node,
                boolean hasRightSibling) {
            if (node != null) {
                sb.append("\n");
                sb.append(padding);
                sb.append(pointer);
                sb.append(node.value);

                StringBuilder paddingBuilder = new StringBuilder(padding);
                if (hasRightSibling) {
                    paddingBuilder.append("│  ");
                } else {
                    paddingBuilder.append("   ");
                }

                String paddingForBoth = paddingBuilder.toString();
                String pointerRight = "└──";
                String pointerLeft = (node.right != null) ? "├──" : "└──";

                traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.left != null);
                traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
            }
        }

        public void print() {
            System.out.println(traversePreOrder(this));
        }

        /////////////////////////////////////////////////////////////////////////////////////

    }// class ends



public static void findAmountOfTrees(int N) {
    BigInteger current_count = BigInteger.valueOf(0);
    
   //amt_of_trees.add(BigInteger.valueOf(1));


  



if (N % 2 == 0) {
    int m = N - 1, k = N - 1 - m; 
    for (int i = 0; i < (N/2); i++) {
        current_count.add(amt_of_trees.get(m).multiply(amt_of_trees.get(k)));
        m--; k++;
    }
    current_count = current_count.multiply(current_count);
}


amt_of_trees.add(current_count);


   
    
System.out.println(amt_of_trees.get(N-1));


    
}



    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        amt_of_trees = new ArrayList<BigInteger>();
        amt_of_trees.add(BigInteger.valueOf(1));

        for (int a = 1; a < N; a++)
       {findAmountOfTrees(a);}

       System.out.println(amt_of_trees.g);
        

    }

}