
// Christian Jarmon
// Project 3 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;

public class Project3 {
    static int N;
    static ArrayList<BST> trees;

    static class BST implements Cloneable{
        public int value;
        public BST left;
        public BST right;

        public BST(int a) {
            this.value = a;
            this.left = null;
            this.right = null;
        }

        public Object clone() throws CloneNotSupportedException 
        {
           return (BST)super.clone();
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

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));

        BST test = new BST(2);
        test.addNode(3);
        test.addNode(1);
       
     //test.print();
       test.rotateLeft();
       //test.print();
       

        // System.out.println(test.value + " " + test.left.value + " " +
        // test.left.left.value);
        // System.out.println(rt_test.value + " " + rt_test.left.value + " " +
        // rt_test.right.value);

       
        

    }

}