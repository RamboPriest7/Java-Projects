public class Project5main {
    public static void main(String [] args) {
        System.out.println("recuerden, si la función no es para una instrucción específica, técnicamente no tiene que ser recursiva");
        int [] data = { 50, 30, 60, 10, 80, 55, 40 };
        BinaryTree test = new BinaryTree();
        test.buildTree(data);
        test.printInorder(test.root); System.out.println();
        System.out.println("height " + test.computeHeight(test.root));
        System.out.println("number of nodes " + test.countNodes(test.root));
        System.out.println("max is " + test.findMax(test.root));
        System.out.println("sum is " + test.findSum(test.root));
        System.out.println("average is " + test.findAverage(test.root));
        for (int i: data) {
        System.out.println("finding item " + test.findItem(i, test.root)); //function broken --->> NOT ANYMORE WOOOOOOOO
        }//for ends
          //System.out.println(" " + test.root.key + " " + test.root.left.key  + " " + test.root.right.key+ " " + test.root. left.left.key+ " " + test.root.left.right.key+ " " + test.root.right.left.key+ " " + test.root.right.right.key+ " ");
    
    }
    
}