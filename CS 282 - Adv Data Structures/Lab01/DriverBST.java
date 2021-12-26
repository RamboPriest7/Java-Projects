import java.util.ArrayList;
import java.util.Arrays;

public class DriverBST {

	
		// TODO Auto-generated method stub
   public static void main(String[] args) {
      new DriverBST();
   }

   public DriverBST() {
   	  
      BST<String> tree = new BST<String>();   
      System.out.print("The height of tree is " + tree.height());
   	
      BST<String> tree1 = new BST<String>(new String[]
               {"Tom", "George", "Jean", "Jane", "Kevin", "Peter", "Susan", 
                 "Jen", "Kim", "Michael", "Michelle"});
      System.out.print("\nThe breadth-first traversal of tree1 is ");
      tree1.breadthFirstTraversal();
      System.out.print("\nThe height of tree1 is " + tree1.height());
   		    
      BST<Integer> tree2 = 
               new BST<Integer>(new Integer[]{50, 30, 80, 20, 40, 65, 90,60});    
   		    
      System.out.print("\nThe in-order traversal for tree2 is ");
      tree2.inorder();
      System.out.print("\nThe non recursive in-order traversal for tree2 is ");
      tree2.nonRecursiveInorder();
      System.out.print("\nThe pre-order traversal for tree2 is ");
      tree2.preorder();
      System.out.print("\nThe non recursive pre-order traversal for tree2 is ");
      tree2.nonRecursivePreorder();
      System.out.print("\nThe post-order traversal for tree2 is ");
      tree2.postorder();
      System.out.print("\nThe non recursive post-order traversal for tree2 is ");
      tree2.nonRecursivePostorder();
      System.out.print("\nThe breadth-first traversal for tree2 is ");
      tree2.breadthFirstTraversal();
      System.out.print("\nThe height of tree2 is " + tree2.height());  
      BST<Integer> tree3 = 
             		new BST<Integer>(new Integer[]{50, 20, 65, 60});   
      System.out.print("\nThe breadth-first traversal for tree3 is ");
      tree3.breadthFirstTraversal();
      System.out.print("\nThe height of tree3 is " + tree3.height()); 
      System.out.println("\ntree2 contains all of tree3 ? "+ tree2.containsAll(tree3));
      BST<Integer> tree4 = 
             		new BST<Integer>(new Integer[]{22, 52});   
      tree2.addAll(tree4);
      System.out.print("\nThe breadth-first traversal for tree2 is ");
      tree2.breadthFirstTraversal();
      System.out.print("\nThe height of tree2 is " + tree2.height()); 
      tree2.retainAll(tree4);
      System.out.print("\nThe breadth-first traversal for tree2 is ");
      tree2.breadthFirstTraversal();
      System.out.print("\nThe height of tree2 is " + tree2.height()); 
      tree3.removeAll(tree4);
      System.out.print("\nThe breadth-first traversal for tree3 is ");
      tree3.breadthFirstTraversal();
      System.out.print("\nThe height of tree3 is " + tree3.height());
      tree2 =  new BST<Integer>(new Integer[]{50, 45, 35, 48, 59, 51, 58});
      Object[] list1 = tree2.toArray();
   			 
      System.out.println("\n"+new ArrayList(Arrays.asList(list1)));
   		    
      Integer[] list2 = new Integer[tree2.size()];
      list2 = tree2.toArray(list2);
   		   
      System.out.println(new ArrayList<Integer>(Arrays.asList(list2))+"\n");
   		    
   }
		  
		

}


