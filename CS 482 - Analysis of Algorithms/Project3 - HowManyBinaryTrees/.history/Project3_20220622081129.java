// Christian Jarmon
// Project 3 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;

public class Project3 {


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
                this.right = new BST(a);
            }
        }
    
    

    return this;
    }//end addNode
    }//class ends

public static void main(String [] args) {

}

}