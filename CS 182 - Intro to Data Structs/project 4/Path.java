import java.util.Arrays;
import java.util.Stack;


public class Path  {

//---------------------For you Prof. Berry --------------------
    StackArray rooms = new StackArray(); 
  //At line 32 and 49 the types need to change as well
    //  StackArray rooms = new StackArray();
  
    // StackJava  rooms = new StackJava();
   
      
    static Room green;
    public Path() {
       /* System.out.println("pick a stack you wanna use ---> 1) Linkedlist, 2) Array, or 3) Java Stack");
        int choice = UserInput.getInt();
        if (choice == 1) {
            */
        
            
        
        green = new Room("green", 0);
        rooms.push(green);
        
    }//path con ends

public void checkReturn() {//this method is for when the player starts returning to the green room, to be called when player reaches gold room, POP IS TO BE USED HERE

}//checkReturn ends
public void Restart() {
    rooms = null;
    rooms = new StackArray();
    green = new Room("green", 0);
    System.out.println("rooms being pushed");
    rooms.push(green);
    rooms.peek();
}


public void Continue() {
//this methods will keep track of the data fields of color and code that is currently in the Project4 object
Room newRoom = new Room(Project4.sendColor() , Project4.sendCode() ) ;

getRooms().push(newRoom);
}//Continue ends

public StackArray getRooms() {
    return rooms;
}
public boolean checkIfRoom(Room obj) {
    for (int i = 0;i < obj.getDoors().length; i++) {
if (obj.getDoors()[i].equals(Project4.sendColor())          ) {
    return true;
}
    }//for ends
    return false;
}
public boolean checkValidPush(int code, String color) {//if player entered a door color that is in the room
    
    if (        checkIfRoom(rooms.peek()) == true            && !(code == rooms.peek().getCode())    && checkValidCode(code) == true  ) {
        return true;
    }
    return false;
}
public boolean checkValidPop(int code, String color) {
    if (rooms.peek().getColor().equals(color) && rooms.peek().getCode() == code) {System.out.println("pop is valid"); return true;}
   else { System.out.println("pop is invalid");
    return false; }
}

public boolean checkValidCode(int code) {
if (rooms.isEmpty() == true) {return true;}
if (rooms.getObj(rooms.getSize() - 1).getCode() == code) 
return false;
/*
for (int i = 0; i < rooms.getSize() ; i++) {


    if ((int)rooms.getObj(i).getCode() == code) {
    return false;
}

}//for ends   */
return true;
}//check valid code ends


public static void main(String [] args) {
    Path shits = new Path();
    Room pink = new Room("pink", 223);
    System.out.println(shits.checkValidCode(shits.getRooms().peek().getCode()));
    shits.getRooms().push(pink);
    System.out.println(shits.getRooms().peek());
    System.out.println(shits.getRooms().getObj(1).getColor());
    System.out.println(shits.getRooms().isEmpty());
    System.out.println(shits.getRooms().getSize());
    System.out.println(shits.getRooms().getList());

    shits.getRooms().pop();
    System.out.println(shits.getRooms().getList());
}
}//class Path ends