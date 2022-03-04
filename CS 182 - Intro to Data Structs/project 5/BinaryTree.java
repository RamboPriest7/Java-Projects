//well hello there. 

class BinaryTree
{
    Node root;

    public void BinaryTree() {//do i need a constructor for this?, yes yes i do
        root = null;
    }

    public  int computeHeight(Node root) {// has to be recursive
     return (root == null) ? 0 : 1 + Math.max(computeHeight(root.left), computeHeight(root.right));
       
    }

    public  int recordNodes() {// records number of nodes everytime addNode is called, might be too redundant, yes, yes it is
        //
        return 0;
    }// record ends

    public  Node createNode(int data) { // per the project instructions, this does not have to be recursive, well of course it doesnt lol
        // this is kinda stupid, just make the children null in the Node constructor

        Node temp = new Node(data);

        temp.left = null;
        temp.right = null;

        return temp;
    }// create ends

    public  Node insertNode(Node root, int key) {// per the project instructions, this does not have to be
                                                       // recursive
        // try to make this recursive, i think its possible, might have to make another
        // function -> function that finds/computes the leaf, makes root_parameter child -->
        // second function calls this function to insert nodes
        // return Node, so when you call the "wrapper" insert method, you can set
        // children and leafs with less complex code

        if (root == null) {
            root = new Node(key);
            return root;
        }
        // this makes the left children less than root, and right children more than
        // root, whatever it may be. per instruction, there are no duplicates, so the
        // conditions are binary
        if (key < root.key)
            root.left = insertNode(root.left, key);
        else
            root.right = insertNode(root.right, key);

        return root;

    }// insertNode ends

    public  void insert(int key) {// call this function in a loop to build the tree, with parameter of the array
                                        // named data
        root = insertNode(root, key);
    }
	
	public void printInorder(Node root) {//per the project instructions, this does not have to be recursive
		if (root == null)
		return;
		else {
			printInorder(root.left);
			System.out.print( root.key +" ");  
			printInorder(root.right);  
		}//if ends
	}//print ends
public  void buildTree(int [] arr) {//call insert in a for loop to build the tree
for (int i = 0; i < arr.length; i++) {
    insert(arr[i]);
}//for ends
} //build tree ends
public int countNodes(Node root) {//this logic can also be used for sum and average
return (root == null) ? 0 : 1 + countNodes(root.left) + countNodes(root.right);

}//countNodes ends
public int findMax(Node root) {
 int max, lmax, rmax;
 if (root == null)
 return -1;
max = root.key;
lmax = findMax(root.left);
rmax = findMax(root.right);
//if they are false it just sets max equal to itself
max = (max < lmax) ? lmax : max;
max = (max < rmax) ? rmax : max; 

return max;

}
public int findSum(Node root) {
   return (root == null) ? 0 : root.key + findSum(root.left) + findSum(root.right);
}
public double findAverage(Node root) {//Does this even count? probably not. its genius tho.
 return (double)findSum(root)/countNodes(root);
}
public int findItem(int find, Node root) {//function broken --->> NOT ANYMORE WOOOOOOOO
if (root == null) {return -1;}
    if (root.key == find) {
     return find;
 } 

 int find2 = findItem(find, root.left);
 if (find2 != 1) {return find;}
 
 int find3 = findItem(find, root.right);
 if (find3 != 1) {return find;}
 
 
 return -1;
}


}//class bST ends
