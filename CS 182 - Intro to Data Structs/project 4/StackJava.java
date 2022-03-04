import java.util.Stack;

class StackJava implements MyStack {

Stack<Room> cStack = new Stack<Room>();
int size = 0;

 public void push ( Room obj )  {size++; cStack.push(obj);}
public String pop ( ) {size--; String color = cStack.peek().getColor(); cStack.pop(); return color;}
public Room peek ( ) {return cStack.peek();}
public  boolean isEmpty ( ) {return (size ==0);}
public Room getObj(int i) { Stack <Room> temp = cStack; for (int a = 0; a < size - i -1 ; a++) {temp.pop();} return temp.peek();}
public int getSize() {return size;}
public Stack<Room> getList() {return cStack;}

public static void main (String [] args) {
    StackJava test = new StackJava();
    test.push(new Room ("green", 231));
    test.push(new Room ("pink", 131));
    test.push(new Room ("blue", 291));

    System.out.println(test.getObj(1).getColor());
}

}//class ends