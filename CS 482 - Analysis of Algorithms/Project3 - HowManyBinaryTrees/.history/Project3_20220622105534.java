
// Christian Jarmon
// Project 3 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;

public class Project3 {
    static int N;

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int a) {
            this.value = a;
            this.left = null;
            this.right = null;
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

       //this function should only create a tree with head as the root and all possible organizations of the number head-1 and on
    public BST rotateRight() {
        BST ret = this;
        ret.left = this.left;

        ret.right = new BST(this.value);
        ret.right.right
        this.left.right.right = this.right;

        System.out.println(this.left.right.value);
        return this.left;
        
        
    
    
    }//end rotate
    }// class ends


    

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        
        BST test = new BST(3);
        test.addNode(2);
        test.addNode(1);

BST rt_test = test.rotateRight();

        System.out.println(test.value + " " + test.left.value + " " + test.left.left.value);
        System.out.println(rt_test.value + " " + rt_test.left.value + " " + rt_test.right.value);

    }

}