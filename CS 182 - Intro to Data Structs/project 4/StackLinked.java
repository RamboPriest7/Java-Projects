 

class StackLinked implements MyStack {
    int size = 0;
    Room [] rooms = new Room[20];
    class StackNode {
Room data;
StackNode next;


StackNode(Room i) {
    this.data = i;
}
}//class stacknode ends
StackNode root;
StackNode head;

public void push(Room obj) {
    rooms[size] = obj;
StackNode newNode = new StackNode(obj);
if (root == null) {
    size++;
    root = newNode;
   head = root;
} else {
    size++;
    StackNode temp = root;
    root = newNode;
    newNode.next = temp;
}
System.out.println("pushed finished");
}// push ends 
public String pop ( ) {
if (root == null) {return "String is empty";}
    size--;
    Room pop = root.data;
    root = root.next;
return pop.getColor();
}//pop ends
 public Room peek ( ) {

    return (root == null) ? null : root.data;
}//peek ends
public boolean isEmpty ( ) {
return (root == null);
}//empty ends
public int getSize() {
    return size;
}
//for getObj set a temproot = head, use a for loop with i < parameter and set temproot
public Room getObj(int i) {
return rooms[i];
}
public Room[] getList() {
    Room [] list = new Room[size];
    for (int i = 0; i < size; i++ ) {
        list[i] = rooms[i];
    }
return list;
}
public static void main(String [] args) {
StackLinked  test = new StackLinked();
Room test1 = new Room("Pink", 123);
Room test2 = new Room("blue", 124);
Room test3 = new Room("yellow", 113);
test.push(test1);
test.push(test2);
test.push(test3);
for (int i = 0; i < test.getSize(); i++ ) {
System.out.println(test.getObj(i).getColor());
}
}//main ends


}//class ends;