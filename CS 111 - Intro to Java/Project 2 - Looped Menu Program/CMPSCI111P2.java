 /* Christian Jarmon
  * CMPSCI 111L - Spring 2020
  * Project 2
  */
import java.lang.Math;
import java.util.Scanner;
import java.util.Random;
 
class CMPSCI111P2 {
public static void main(String args[]) {
  Random numr = new Random();
  Scanner scan = new Scanner(System.in);
  int option = 0;
//OPTION SELECTION
while (option != 5 || option > 5) {
  
  System.out.println("Select an option: 1) Print a rectangle");
System.out.println("                  2) Print a downwards right triangle");
System.out.println("                  3) Print a upwards right triangle");
System.out.println("                  4) Print a random rectangle");
System.out.println("                  5) Exit");
 
//INPUT
if (scan.hasNextInt()) {
  option = scan.nextInt();
  System.out.println(option);
  }
  

  
  //SWITCH FOR PRINTING OUT OPTION#
switch (option) {
case 1: for (int i = 0; i < 5; i++) {
for (int q = 0; q < 7; q++) {
System.out.print("*");
}// * loop ends
System.out.println();
}//shape for loop ends
break;
case 2: //for this case start a loop at 1 and print i + 1 with condition i <=6
for (int b = 1; b <= 6; b++) {
for (int i = 0; i < (b); i++) {
System.out.print("*");
}
System.out.println();

}//* loop ends
break;
  case 3: for (int b = 6; b > 0; b--) {
for (int i = 0; i < (b); i++) {
System.out.print("*");
}
System.out.println();

}//* loop ends 
  break;
  case 4: //for this case, the height and width are randomly generated , copy case 1 and make q and i random values, height/i is (1, 6) and width/q is (2, 10)
    int height = ( (int)((Math.random()*10)+ 2) );
   int width = ( (int)((Math.random()*6)+ 1) );
    for (int i = 0; i < height; i++) {
for (int q = 0; q < width; q++) {
System.out.print("*");
}// * loop ends
System.out.println();
}//shape for loop ends
  
break;
  default: if (option == 5) {
  System.out.println("Goodbye");
  } else {
  System.out.println("not a valid a input");
  }
}//switch ends
 
 System.out.println();
}//while ends
 
 
 
}//PSVmain ends
}// class ends

 
 

