/*

 green room, doors: brown, pink and blue rooms.
 pink room, doors: green, brown and blue rooms.
 brown room, doors: pink, green and red rooms.
 blue room doors: green, pink and yellow rooms
 red room, doors: brown and yellow rooms.
 yellow room, doors: red, blue and gold rooms.
 gold room, door:  yellow room.

gold, yellow, red, brown, pink, green 

*/
class Room{
String [] doors;
String color = "";
int code = 0;
// for the code, whatever the number is entered in the pop/push field, record and use setCode
public Room(String newColor, int newCode) {
color = newColor.toLowerCase();

	code = newCode;

switch (color) {
case "green": doors = new String[]{"brown", "pink", "blue"};
break;
case "pink": doors = new String[]{"green", "brown", "blue" };
break;

case "brown": doors = new String[]{"pink", "green" , "red" };
break;

case "blue": doors = new String[]{"green", "pink" ,"yellow" };
break;

case "red": doors = new String[]{"brown" , "yellow" };
break;

case "yellow": doors =new String[]{"red", "blue", "gold" };
break;

case "gold": doors = new String[]{"yellow"};
break;
}//switch ends
}//Room con ends
public String getColor() {
	return color;
}

public int getCode() {
	return code;
}

public void setColor(String newColor) {
	color = newColor;
}

public void setCode(int newCode) {
	code = newCode;
}

public String[] getDoors() {
	return doors;
}
public int getNumDoors() {
return doors.length;
}

}//class Room ends