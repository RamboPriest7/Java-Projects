import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Tree<E> extends Collection<E> {
  /** Return true if the element is in the tree */
  public boolean search(E e);

  /**
   * Insert element e into the binary tree Return true if the element is inserted
   * successfully
   */
  public boolean insert(E e);

  /**
   * Delete the specified element from the tree Return true if the element is
   * deleted successfully
   */
  public boolean delete(E e);

  /** Get the number of elements in the tree */
  public int getSize();

  /** Inorder traversal from the root */
  public default void inorder() {
  }

  /** Inorder non recursive form root */
  public default void nonRecursiveInorder() {
    // Left as exercise: Implement in BST.
  }

  /** Postorder traversal from the root */
  public default void postorder() {
  }

  /** Postorder non recursive form root */
  public default void nonRecursivePostorder() {
    // Left as exercise: Implement in BST.
  }

  /** Preorder traversal from the root */
  public default void preorder() {
  }

  /** Preorder non recursive form root */
  public default void nonRecursivePreorder() {
    // Left as exercise: Implement in BST.
  }

  public int height();

  /** BreadthFirst traversal from the root */
  public default void breadthFirstTreversal() {
    // Left as an exercise: implement in BST
  }

  @Override /** Return true if the tree is empty */
  public default boolean isEmpty() {
    return this.size() == 0;
  }

  @Override
  public default boolean contains(Object e) {
    return search((E) e);
  }

  @Override
  public default boolean add(E e) {
    return insert(e);
  }

  @Override
  public default boolean remove(Object e) {
    return delete((E) e);
  }

  @Override
  public default int size() {
    return getSize();
  }

  @SuppressWarnings("unchecked")
  @Override
  public default boolean containsAll(Collection<?> c) {
    //tree2.containsAll(tree3);
    //if tree3 has an object that tree2 doesnt, return false
    //this = tree2
    //c = tree3
    for (Object a : c) {//for every object named a in collection named c
      if (!this.contains(a)) //if this does not have object a -->> if tree2 does have an object a that is in tree3
        return false; //return false
    }
    return true;
  }

  @SuppressWarnings("unchecked")
  @Override
  public default boolean addAll(Collection<? extends E> c) {
    // Left as an exercise
//tree2.addAll(tree3);
//tree2 = list
//c = tree3
/*
for every object named a in c
add a to tree2 (this)
*/
    for (Object a : c) { //add all off tree3 to tree2 -->> add all of c to this
      this.add((E) a);
    }

    return false;
  }

  @SuppressWarnings("unchecked")
  @Override
  public default boolean removeAll(Collection<?> c) {
    // Left as an exercise
    //tree2.removeAll(tree);
    for (Object a : c) { //for every object named a in c
      if (this.contains(a)) {//if tree2 contains the object a in c
        this.remove(a); //remove that object from tree2
      } // if ends
    }
    return false;

  }

  @SuppressWarnings("unchecked")
  @Override
  public default boolean retainAll(Collection<?> c) {
    //list2.retainAll(list3);

    //list2 = this
    //list3 = c

    // if this has what is in c keep it, remove everything else
    // this is only supposed to return what is c
    // Left as an exercise
    for (Object a : this) { //for every object in list2
      if (!c.contains(a)) { //if list3 doesnt not have the object in list2
        this.remove(a); //remove from list2
      } // if ends
    }
    return false;

  }

  @Override
  public default Object[] toArray() {
    // Left as an exercise
    //tree2.toArray();
    //this = tree2
    Integer[] arr = new Integer[this.size()];
    int i = 0;
    for (Object a : this) {//for object named a in this (tree2), add all of those objects to an array
      arr[i] = (Integer) a;
      i++;
    }
    
    return (Object[]) arr;
  }// to array ends

  @SuppressWarnings("unchecked")
  @Override
  public default <T> T[] toArray(T[] array) {
    // Left as an exercise
    //list2.toArray(list2)
    Integer[] arr = new Integer[array.length];
    int i = 0;
    for (E a : this) {
      arr[i] = (Integer) a;
      i++;
    }
    return (T[]) arr;
//if i create an object named A, i could E as a general object, if its a Java object, you use Object
  }// to array 2 ends
}
