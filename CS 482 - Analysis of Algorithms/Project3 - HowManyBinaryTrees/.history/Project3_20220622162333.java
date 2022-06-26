
// Christian Jarmon
// Project 3 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;

public class Project3 {
    static int N;
    static ArrayList<BST> trees;

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int a) {
            this.value = a;
            this.left = null;
            this.right = null;
        }

        BST(BST b) {
            this.va
        }

        public boolean hasChildren() {
            return (this.left != null || this.right != null);
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

        public BST rotateRight() {
            this.left.right = new BST(this.value);

            this.left.right.right = this.right;

            return this.left;

        }// end rotate

        public BST rotateLeft() {

            this.right.left = new BST(this.value);
            this.right.left.left = this.left;

            return this.right;

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

        public void print(PrintStream os) {
            os.println(traversePreOrder(this));
        }

        /////////////////////////////////////////////////////////////////////////////////////

    }// class ends

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));

        BST test = new BST(2);
        test.addNode(3);
        test.addNode(1);
        System.out.println(test.hasChildren());

        test = test.rotateLeft();

        // System.out.println(test.value + " " + test.left.value + " " +
        // test.left.left.value);
        // System.out.println(rt_test.value + " " + rt_test.left.value + " " +
        // rt_test.right.value);

        test.print(System.out);
        System.out.println(test.hasChildren());

    }

}