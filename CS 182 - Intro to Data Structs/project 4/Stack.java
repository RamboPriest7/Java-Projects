import java.util.ArrayList;

class StackArray implements MyStack {

ArrayList <Room> list = new ArrayList <Room> ();
int top = 0;

    public     void push ( Room obj ) {
        list.add(obj);
        top++;
      System.out.println("current stack is ---->");
        for (int i = 0; i < list.size(); i++) {
          System.out.print(list.get(i).getColor() + "->" + list.get(i).getCode() + ",\n");
      }
        }//push ends
        public String pop ( ) {
            top--;
        Room current = list.get(top);
        list.remove(top);
        System.out.println("current stack is after pop---->");
        for (int i = 0; i < list.size(); i++) {
          System.out.print(list.get(i).getColor() + "->" + list.get(i).getCode() + ",\n");
      }
        return current.getColor();
        
        }//pop ends
        public  Room peek ( )  {
        
            return (Room)list.get(top - 1);
        }// peek ends
        public    boolean empty ( ) {
        return (list.size() == 0);
        }// empty ends
 

public ArrayList getList() {
    return list;
}
public int getSize() {
	return 0;
}
public Room getObj(int i) {
	return null;
}


}//class Stack ends